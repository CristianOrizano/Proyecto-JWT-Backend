package com.proyectojwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "tb_categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ide_cat")
	private Long  codigocate;
	private String nombre;
	private String descripcion;

	@Column(nullable = false)
	private boolean state;

	@JsonIgnore
	@OneToMany(mappedBy = "cate",cascade = CascadeType.ALL)
	private List<Producto> listaCategorias;
}
