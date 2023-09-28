package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.entity.Demo;
import com.proyectojwt.entity.Empleado;

public interface IDemo {
	//metodo para update or add
		public Demo guardar(Demo em);
	
		//metodo para listar
		public List<Demo> listaDemos();

}
