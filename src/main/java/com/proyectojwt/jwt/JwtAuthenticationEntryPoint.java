package com.proyectojwt.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//esta clase sirve para controlar los errores de que el usuario no esta autorizado
//o intenta acceder a recursos protegidos sin token
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("entro en entryponit===");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
		
	}
	
	

}
