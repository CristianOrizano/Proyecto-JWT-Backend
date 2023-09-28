package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.dto.EmpleadoDTO;
import com.proyectojwt.entity.Empleado;

public interface IEmpleadoService {
	
	//metodo para update or add
	public EmpleadoDTO guardar(EmpleadoDTO em);
	
	//metodo eliminar
	public void eliminar(int codigo);
	
	//metodo buscar
	public EmpleadoDTO buscarEmpleado(int cod);
	
	//metodo para listar
	public List<EmpleadoDTO> listaremplado();

}
