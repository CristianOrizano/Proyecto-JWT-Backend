package com.proyectojwt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.dto.AlumnoDTO;
import com.proyectojwt.entity.Alumno;
import com.proyectojwt.entity.Ciudad;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.exepciones.ResourceNotFoundException;
import com.proyectojwt.repository.AlumnoRepository;
import com.proyectojwt.repository.CiudadRepository;
import com.proyectojwt.service.IAlumnoService;

@Service
public class AlumnoServciceImpl implements IAlumnoService{
	//NOta: findByCodigo no devuelve optional asi que no usar orElseThrow
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	AlumnoRepository alumrepo;
	
	@Autowired
	CiudadRepository ciudrepo;
	
	@Override
	public AlumnoDTO guardar(AlumnoDTO alumnoDTO) {
		
		//recibo el dto y convierto a entidad 
		//para save en la BD
		Alumno alu= mapearAEntidad(alumnoDTO);
		
		alumrepo.save(alu);
		
		//volver a mapear a DTO para mostrar datos
		AlumnoDTO alumnodto= mapearADTO(alu);
		return  alumnodto;
	}

	@Override
	public void eliminar(int codigo) {
		
		alumrepo.deleteById(codigo);
	}

	@Override
	public AlumnoDTO buscarAlumno(int cod) {
		
		Alumno al= alumrepo.findById(cod).orElseThrow(() -> new ResourceNotFoundException("empleado", "id", cod));
		AlumnoDTO alumnodto= mapearADTO(al);
		return  alumnodto;
	}

	@Override
	public List<AlumnoDTO> listarAlumno() {
		
		List<Alumno> lista= alumrepo.findAll();
		return lista.stream().map(alumno -> mapearADTO(alumno)).collect(Collectors.toList());
	}
	
	
	//utilizamos el model maper para convertir entidades
	private AlumnoDTO mapearADTO(Alumno alumn) {

		AlumnoDTO alumnoDTO = modelMapper.map(alumn, AlumnoDTO.class);
		return alumnoDTO;
	}
	
	private Alumno mapearAEntidad(AlumnoDTO alumnoDTO) {
		
		Alumno alumno = modelMapper.map(alumnoDTO, Alumno.class);
		return alumno;
	}

	@Override
	public List<Alumno> listarsindto() {
		List<Alumno> lista= alumrepo.findAll();
		return lista;
	}

}
