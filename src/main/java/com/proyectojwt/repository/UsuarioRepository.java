package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	
	Usuario findByUsername(String username);

}
