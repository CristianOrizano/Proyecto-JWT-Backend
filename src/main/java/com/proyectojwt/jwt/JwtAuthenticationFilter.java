package com.proyectojwt.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.proyectojwt.security.UsuarioDetails;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UsuarioDetails customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		  System.out.println("Entro al filtro==================");
		//obtenemos el token de la solicitud HTTP
				String token = obtenerJWTdeLaSolicitud(request);
				
				//validamos el token
				//si token no es vacio y tiene contenido
				if(StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
					//obtenemos el username del token
					String username = jwtTokenProvider.obtenerUsernameDelJWT(token);
					
					//cargamos el usuario asociado al token
					UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
					//se utiliza para representar la autenticacion del usuario
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					//establecemos usuario autenticado
					//puede acceder arecusrsos protegidos basado en su rol
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
				filterChain.doFilter(request, response);
		
	}
	
	//obtener el token enviado por el usuario
	//Bearer token de acceso
		private String obtenerJWTdeLaSolicitud(HttpServletRequest request) {
			String bearerToken = request.getHeader("Authorization");
			if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
				return bearerToken.substring(7,bearerToken.length());
			}
			return null;
		}
	

}
