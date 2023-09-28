package com.proyectojwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyectojwt.jwt.JwtAuthenticationEntryPoint;
import com.proyectojwt.jwt.JwtAuthenticationFilter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Bean
	public PasswordEncoder metodo() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)
			throws Exception {
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder).and().build();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .exceptionHandling()//como manejar exepciones
		    .authenticationEntryPoint(jwtAuthenticationEntryPoint)//para manejar excepcion de error
		    .and()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //no maneje sesiones y que cada solicitud sea autónoma
		    .and()
		    .authorizeRequests()
		    .antMatchers("/services/**").permitAll()
		    .antMatchers("/usuario/**").permitAll()
		    .antMatchers(HttpMethod.OPTIONS).permitAll()
		  // .antMatchers("/api/**").permitAll()
		    .anyRequest()
		    .authenticated();
		    // .and()
		     //.httpBasic();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); //filtro personalizado
		
		
	}
	
	
	
	
	/*  @Bean
      UserDetailsService userDetailsService(BCryptPasswordEncoder encoder){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("cristian").password(encoder.encode("123")).roles("USER").build());
    manager.createUser(User.withUsername("carlos").password(encoder.encode("456")).roles("ADMIN").build());
    
    return manager;
     }  */

	
	
}
