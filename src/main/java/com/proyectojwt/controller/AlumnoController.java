package com.proyectojwt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojwt.dto.AlumnoDTO;
import com.proyectojwt.entity.Alumno;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.service.IAlumnoService;
import com.proyectojwt.service.IEmpleadoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AlumnoController {
	
	@Autowired
	IAlumnoService alumnoser;
	
	//sin dto
	/*@GetMapping("/alumno")
	public List<Alumno> listaalumno() {
		
		List<Alumno>lista = alumnoser.listarsindto();
		return lista;
	} */
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/alumno")
	public List<AlumnoDTO> listaalumno() {
		
		List<AlumnoDTO>lista = alumnoser.listarAlumno();
		return lista;
	} 
	
	//buscar empleado
	@GetMapping("/alumno/{cod}")
	public AlumnoDTO buscar(@PathVariable("cod")int codi) {
		
		AlumnoDTO alumdto= alumnoser.buscarAlumno(codi);
		return alumdto;
	}

	//add //si le mande id(FK) es porq usa dto
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PostMapping("/alumno")
	public ResponseEntity<AlumnoDTO> Addalumno(@Valid @RequestBody AlumnoDTO emp) {
		emp.setCodigo(0);
		AlumnoDTO empl = alumnoser.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.CREATED);
	}
	
	
	//update
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PutMapping("/alumno")
	public ResponseEntity<AlumnoDTO> Updatealumno(@Valid @RequestBody AlumnoDTO emp) {
		
		AlumnoDTO empl = alumnoser.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}
	
	//delete
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@DeleteMapping("/alumno/{cod}")
	public ResponseEntity<String> eliminaralumn(@PathVariable("cod")int cod) {
		alumnoser.eliminar(cod);
		  String men="alumno eliminado exitoso";
		  
		  return new ResponseEntity<>(men,HttpStatus.OK);
	}

}
