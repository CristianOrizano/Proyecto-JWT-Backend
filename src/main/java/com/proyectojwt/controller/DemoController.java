package com.proyectojwt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojwt.entity.Demo;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.service.IDemo;
import com.proyectojwt.service.IEmpleadoService;

@RestController
@RequestMapping("/momo/demo")
@CrossOrigin("*")
public class DemoController{
	
	@Autowired
	IDemo demoSer;
	
	//list
	@GetMapping()
	public ResponseEntity<List<Demo>> listaDemo() {
		
		List<Demo>lista= demoSer.listaDemos();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping()
	public ResponseEntity<Demo> AddDemo(@RequestBody Demo emp) {
		emp.setCodigo(0);
		Demo empl = demoSer.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping()
	public ResponseEntity<Demo> Updateempleado(@Valid @RequestBody Demo emp) {
		
		Demo empl = demoSer.guardar(emp);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}
	
	
	

}
