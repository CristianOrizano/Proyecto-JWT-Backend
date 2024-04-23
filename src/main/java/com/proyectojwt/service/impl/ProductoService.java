package com.proyectojwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Producto;
import com.proyectojwt.repository.ProductoRepository;
import com.proyectojwt.service.IProducto;

@Service
public class ProductoService implements IProducto{

	@Autowired
	private ProductoRepository repo;
	
	
	@Override
	public Producto guardar(Producto ad) {
		return repo.save(ad);
		
	}

	@Override
	public List<Producto> listadoProductos() {
	
		return repo.findAll();
	}

	@Override
	public Producto buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}

	@Override
	public void eliminar(int esta) {
		repo.deleteById(esta); 
		
	}

	@Override
	public List<Producto> buscarPorDescripcion(String descripcion) {
		return repo.findByDescripcionContainingIgnoreCase(descripcion);

	}


}
