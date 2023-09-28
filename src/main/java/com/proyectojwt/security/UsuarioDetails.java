package com.proyectojwt.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectojwt.entity.Rol;
import com.proyectojwt.entity.Usuario;
import com.proyectojwt.repository.UsuarioRepository;

@Service
public class UsuarioDetails implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	/*@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("entro UserDetailsService  "+username);
		UserDetails us = null;
		Usuario usuario = repository.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		var roles = new ArrayList<GrantedAuthority>();
		
		//obtenemos los roles, para obtener el nombre
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		
		System.out.println(usuario.toString());
		us = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return us;
	}*/
	
	//como mi clase Usuario implementa de UserDetails es correcto
	  @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Usuario usuario = repository.findByUsername(username);
	        if(usuario == null){
	            throw new UsernameNotFoundException("Usuario no encontrado");
	        }
	        return usuario;
	    }

}
