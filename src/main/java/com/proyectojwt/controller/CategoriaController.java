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

import com.proyectojwt.entity.Categoria;
import com.proyectojwt.service.ICategoria;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	ICategoria cateserv;
	
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> listacategoria() {
		
		List<Categoria>lista= cateserv.listadoCategorias();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}

}
