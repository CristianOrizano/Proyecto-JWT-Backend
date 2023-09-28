package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.entity.Producto;

public interface IProducto {
	
	public Producto guardar(Producto ad);
	
	public List<Producto> listadoProductos();
	
	public Producto buscar(int cod);
	
	public void eliminar(int esta);

}
