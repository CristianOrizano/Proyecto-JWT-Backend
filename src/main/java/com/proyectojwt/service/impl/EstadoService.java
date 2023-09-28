package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Estado;
import com.proyectojwt.entity.Rol;
import com.proyectojwt.repository.EstadoRepository;
import com.proyectojwt.service.IEstado;

@Service
public class EstadoService implements IEstado{
	
	@Autowired
	EstadoRepository repoEsta;

	@Override
	public List<Estado> listEstados() {
		
		return repoEsta.findAll();
	}
	
	

}
