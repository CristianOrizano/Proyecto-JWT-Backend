package com.proyectojwt.controller;

import java.util.List;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.categoria.CategoriaSimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.proyectojwt.entity.Categoria;
import com.proyectojwt.service.ICategoria;


@RestController
@RequestMapping("/api/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	ICategoria categoriaService;
	
	// @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping()
	public ResponseEntity<List<CategoriaDto>> listacategoria() {
		List<CategoriaDto>lista= categoriaService.findAll();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public  ResponseEntity<CategoriaDto> findById(@PathVariable("id") Long id){
		CategoriaDto category = categoriaService.findById(id);

		return ResponseEntity.ok(category);
	}
	@PostMapping
	ResponseEntity<CategoriaDto> create(@RequestBody CategoriaSaveDto categoryBody) {
		CategoriaDto category = categoriaService.create(categoryBody);

		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}

	@PutMapping("/{id}")
	ResponseEntity<CategoriaDto> edit(@PathVariable("id") Long id, @RequestBody CategoriaSaveDto categoryBody) {
		CategoriaDto category = categoriaService.edit(id, categoryBody);
		return ResponseEntity.ok(category);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<CategoriaDto> disabled(@PathVariable("id") Long id) {
		CategoriaDto category = categoriaService.disabled(id);

		return ResponseEntity.ok(category);
	}

	@GetMapping("/listasimple")
	ResponseEntity<List<CategoriaSimpleDto>> select() {
		List<CategoriaSimpleDto> categories = categoriaService.ListSimple();

		return ResponseEntity.ok(categories);
	}




}
