package com.proyectojwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojwt.entity.Ciudad;
import com.proyectojwt.entity.Estado;
import com.proyectojwt.service.ICiudad;
import com.proyectojwt.service.IEstado;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CiudadController {
	@Autowired
	ICiudad serCiudad;
	@Autowired
	IEstado serEstado;

	@GetMapping("/ciudad")
	public ResponseEntity<List<Ciudad>> listCiudad() {
		List<Ciudad>lista= serCiudad.listadCiudad();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}

	@GetMapping("/estado")
	public ResponseEntity<List<Estado>> listEstado() {
		List<Estado>lista= serEstado.listEstados();
		return new ResponseEntity<>(lista,HttpStatus.OK);
 }
}
