package com.proyectojwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.proyectojwt.entity.Estado;
import com.proyectojwt.entity.Producto;
import com.proyectojwt.service.IProducto;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private IProducto proser;


	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> ListarProd() {
		List<Producto> lista = proser.listadoProductos();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/productos/{cod}")
	public ResponseEntity<Producto> buscar(@PathVariable("cod")int codi) {
		
		Producto empl= proser.buscar(codi);
		return new ResponseEntity<>(empl,HttpStatus.OK);
	}
	

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/productos")
	public ResponseEntity<Producto> insertar(@RequestBody Producto prod) {
		prod.setCodigoele(0);
		Producto pro = proser.guardar(prod);
		return new ResponseEntity<>(pro, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PutMapping("/productos")
	public ResponseEntity<Producto> update(@RequestBody Producto prod) {
		Producto pro = proser.guardar(prod);
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("/productos/{cod}")
	public ResponseEntity<Map<String, Object>> eliminar(@PathVariable("cod") int cod) {
		Map<String, Object> salida = new HashMap<>();
		Producto emp = proser.buscar(cod);
		if (emp == null) {
			salida.put("mensaje", "El codigo no existe");
			return new ResponseEntity<>(salida, HttpStatus.OK);
		}
		proser.eliminar(cod);
		String men = "producto eliminado exitoso";
		salida.put("mensaje", men);
		return new ResponseEntity<>(salida, HttpStatus.OK);
	}

}
