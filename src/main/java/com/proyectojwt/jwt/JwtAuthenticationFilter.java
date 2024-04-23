package com.proyectojwt.jwt;

import java.io.IOException;


import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

		//obtener el token enviado por el usuario
		//Bearer token de acceso
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;

		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
			jwtToken = requestTokenHeader.substring(7);
			try{
				username = this.jwtTokenProvider.getUserNameFromToken(jwtToken);
			}catch (ExpiredJwtException exception){
				System.out.println("El token ha expirado");
			}catch (Exception e){
				System.out.println("ocurrio un error========>"+e.getMessage());
				e.printStackTrace();
			}
		}else{
			System.out.println("Token invalido , no empieza con bearer string");
		}

		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
			//cargamos el usuario asociado al token
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
			if(this.jwtTokenProvider.isTokenValid(jwtToken,userDetails)){

				//se utiliza para representar la autenticacion del usuario
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				//establecemos usuario autenticado
				//puede acceder arecusrsos protegidos basado en su rol
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}else{
			System.out.println("El token no es valido");
		}
		filterChain.doFilter(request,response);
	}

}
