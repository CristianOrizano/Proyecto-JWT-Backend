package com.proyectojwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.proyectojwt.dto.empleado.EmpleadoSaveDto;
import jakarta.validation.Valid;
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

import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.dto.EstadoDTO;
import com.proyectojwt.service.IEmpleadoService;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin("*")
public class EmpleadoController {
	@Autowired
	IEmpleadoService emplead;

	@GetMapping()
	public ResponseEntity<List<EmpleadoDTO>> listaempleado() {
		List<EmpleadoDTO>lista= emplead.listaremplado();
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoDTO> buscar(@PathVariable("id")Long codi) {
		EmpleadoDTO empl= emplead.findById(codi);
		return ResponseEntity.ok(empl);
	}
	@PostMapping()
	public ResponseEntity<EmpleadoDTO> Addempleado(@Valid @RequestBody EmpleadoSaveDto emp) {
		EmpleadoDTO empl = emplead.create(emp);
		return new ResponseEntity<>(empl,HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmpleadoDTO> Updateempleado(@Valid @RequestBody EmpleadoSaveDto emp, @PathVariable("id") Long id) {
		
		EmpleadoDTO empl = emplead.edit(id,emp);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<EmpleadoDTO> eliminaremple(@PathVariable("id") Long cod) {
		EmpleadoDTO empleadoDTO = emplead.disabled(cod);
		return ResponseEntity.ok(empleadoDTO);
	}
	
	

}
