package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.entity.Empleado;
import com.proyectojwt.entity.Usuario;

public interface IUsuarioService {
	//metodo para update or add
	public Usuario guardar(Usuario em);
	
	//metodo para buscar nombre usernmae
	public Usuario buscarnameuser(String nombre);
	
	//metodo listar usuarios
	public List<Usuario> listaUsuario();

}
