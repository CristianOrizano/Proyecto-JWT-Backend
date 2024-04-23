package com.proyectojwt.controller;

import java.util.List;


import com.proyectojwt.dto.cliente.ClienteSaveDto;
import com.proyectojwt.dto.empleado.EmpleadoDTO;
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

import com.proyectojwt.dto.cliente.ClienteDTO;
import com.proyectojwt.service.IClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	IClienteService clienteService;

	@GetMapping()
	public ResponseEntity<List<ClienteDTO>> listaclientes() {
		List<ClienteDTO>lista = clienteService.listarcliente();
		return ResponseEntity.ok(lista);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable("id")Long codi) {
		ClienteDTO clienteDTO= clienteService.findById(codi);
		return ResponseEntity.ok(clienteDTO);
	}
	@PostMapping()
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteSaveDto emp) {
		ClienteDTO empl = clienteService.create(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(empl);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> Update(@Valid @RequestBody ClienteSaveDto emp, @PathVariable("id") Long cod) {
		ClienteDTO empl = clienteService.edit(cod,emp);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable("id")Long cod) {
		ClienteDTO clienteDTO = clienteService.disabled(cod);
		return ResponseEntity.ok(clienteDTO);
	}

}
