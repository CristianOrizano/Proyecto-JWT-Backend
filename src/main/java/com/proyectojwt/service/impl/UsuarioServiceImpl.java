package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Usuario;
import com.proyectojwt.repository.EmpleadoRepository;
import com.proyectojwt.repository.UsuarioRepository;
import com.proyectojwt.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	 @Autowired
	 UsuarioRepository repousua;

	@Override
	public Usuario guardar(Usuario em) {
		return  repousua.save(em);
	}

	@Override
	public Usuario buscarnameuser(String nombre) {
		
		Usuario usu= repousua.findByUsername(nombre);
		return usu;
	}

	@Override
	public List<Usuario> listaUsuario() {
		List<Usuario> lista = repousua.findAll();
		return lista;
	}

}
