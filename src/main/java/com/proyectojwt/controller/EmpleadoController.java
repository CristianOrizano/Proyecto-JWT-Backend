package com.proyectojwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojwt.dto.EmpleadoDTO;
import com.proyectojwt.dto.EstadoDTO;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.entity.Estado;
import com.proyectojwt.service.IEmpleadoService;

@RestController
@RequestMapping("/api/res")
@CrossOrigin("*")
public class EmpleadoController {
	
	@Autowired
	IEmpleadoService emplead;
	
	//list
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/empleado")
	public ResponseEntity<List<EmpleadoDTO>> listaempleado() {
		
		List<EmpleadoDTO>lista= emplead.listaremplado();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	//buscar empleado
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/empleado/{cod}")
	public ResponseEntity<EmpleadoDTO> buscar(@PathVariable("cod")int codi) {
		
		EmpleadoDTO empl= emplead.buscarEmpleado(codi);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}

	//add 
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/empleado")
	public ResponseEntity<EmpleadoDTO> Addempleado(@Valid @RequestBody EmpleadoDTO emp) {
		emp.setCodigo(0);
		EmpleadoDTO empl = emplead.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.CREATED);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/empleado")
	public ResponseEntity<EmpleadoDTO> Updateempleado(@Valid @RequestBody EmpleadoDTO emp) {
		
		EmpleadoDTO empl = emplead.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}
	
	
	//delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/empleado/{cod}")
	public ResponseEntity<Map<String, Object>> eliminaremple(@PathVariable("cod") int cod) {
		Map<String, Object> salida = new HashMap<>();
		EmpleadoDTO emp = emplead.buscarEmpleado(cod);
		EstadoDTO estado = new EstadoDTO();
		estado.setCodestad(2);
		emp.setEstad(estado);
		emplead.guardar(emp);
		String men = "empleado eliminado exitoso";
		salida.put("mensaje", men);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}
	
	

}
