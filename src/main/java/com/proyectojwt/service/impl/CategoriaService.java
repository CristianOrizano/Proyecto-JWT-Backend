package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Categoria;
import com.proyectojwt.repository.CategoriaRepository;
import com.proyectojwt.service.ICategoria;

@Service
public class CategoriaService implements ICategoria{
	
	@Autowired
	CategoriaRepository repocate;

	@Override
	public List<Categoria> listadoCategorias() {
		List<Categoria> lista = repocate.findAll();
		return lista;
	}

}
