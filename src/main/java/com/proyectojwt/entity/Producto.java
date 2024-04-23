package com.proyectojwt.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
