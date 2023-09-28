package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.dto.AlumnoDTO;
import com.proyectojwt.entity.Alumno;
import com.proyectojwt.entity.Empleado;

public interface IAlumnoService {
	   //metodo para update or add
		public AlumnoDTO guardar(AlumnoDTO alumnoDTO);
		
		//metodo eliminar
		public void eliminar(int codigo);
		
		//metodo buscar
		public AlumnoDTO buscarAlumno(int cod);
		
		//metodo para listar
		public List<AlumnoDTO> listarAlumno();
		
		//metodo para listar sin dto
		public List<Alumno> listarsindto();
	
	

}
