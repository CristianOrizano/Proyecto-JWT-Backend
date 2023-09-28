package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Demo;
import com.proyectojwt.repository.DemoRepository;
import com.proyectojwt.service.IDemo;

@Service
public class DemoService implements IDemo{

	@Autowired
	DemoRepository demoRepo;
	
	@Override
	public Demo guardar(Demo em) {
		return demoRepo.save(em);
	}

	@Override
	public List<Demo> listaDemos() {
		List<Demo> lista= demoRepo.findAll();
		return lista;
	}

}
