package com.proyectojwt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.dto.AlumnoDTO;
import com.proyectojwt.dto.EmpleadoDTO;
import com.proyectojwt.entity.Alumno;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.exepciones.ResourceNotFoundException;
import com.proyectojwt.repository.EmpleadoRepository;
import com.proyectojwt.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private ModelMapper modelMapper;
	
    @Autowired
    EmpleadoRepository repoempl;
	
	@Override
	public EmpleadoDTO guardar(EmpleadoDTO em) {
		Empleado empleado = mapearAEntidad(em);
		 repoempl.save(empleado);
		EmpleadoDTO emplDTO= mapearADTO(empleado);
		return  emplDTO;
	}

	@Override
	public void eliminar(int codigo) {
		repoempl.deleteById(codigo);
		
	}
	@Override
	public EmpleadoDTO buscarEmpleado(int cod) {
		Empleado empl= repoempl.findById(cod).orElseThrow(() -> new ResourceNotFoundException("empleado", "id", cod));
		EmpleadoDTO emplDTO= mapearADTO(empl);
		return emplDTO;
	}

	@Override
	public List<EmpleadoDTO> listaremplado() {
		
		List<Empleado> lista= repoempl.findAll();
		return lista.stream().map(alumno -> mapearADTO(alumno)).collect(Collectors.toList());
	}
	
	
	//utilizamos el model maper para convertir entidades
	private EmpleadoDTO mapearADTO(Empleado empl) {

		EmpleadoDTO empleadoDTO = modelMapper.map(empl, EmpleadoDTO.class);
		return empleadoDTO;
	}
	
	private Empleado mapearAEntidad(EmpleadoDTO empleadoDTO) {
		
		Empleado empleado = modelMapper.map(empleadoDTO, Empleado.class);
		return empleado;
	}
	
	

	
	
}
