package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Ciudad;
import com.proyectojwt.repository.CiudadRepository;
import com.proyectojwt.service.ICiudad;

@Service
public class CiudadService implements ICiudad{
	@Autowired
	CiudadRepository ciudadRepo;

	@Override
	public List<Ciudad> listadCiudad() {
		
		List<Ciudad>lis= ciudadRepo.findAll();
		
		return lis;
	}
	
	

}
