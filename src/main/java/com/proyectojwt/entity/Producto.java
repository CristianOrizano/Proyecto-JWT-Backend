package com.proyectojwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_ele")
	private int codigoele;
	
	@ManyToOne
	@JoinColumn(name="ide_cat")
	private Categoria cate;//ASOC.
	
	private String descripcion;
	
	private int stock;
	
	private double precio;
	
	private String marca;
	
	private String nimagen;
	
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;//ASOC.

	public int getCodigoele() {
		return codigoele;
	}

	public void setCodigoele(int codigoele) {
		this.codigoele = codigoele;
	}

	public Categoria getCate() {
		return cate;
	}
	

	public String getNimagen() {
		return nimagen;
	}

	public void setNimagen(String nimagen) {
		this.nimagen = nimagen;
	}

	public void setCate(Categoria cate) {
		this.cate = cate;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	
}
