package com.proyectojwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@Column(name="ide_cat")
	private int codigocate;
	
	@Column(name="descripcion")
	private String nombre;

	public int getCodigocate() {
		return codigocate;
	}

	public void setCodigocate(int codigocate) {
		this.codigocate = codigocate;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
