package com.proyectojwt.entity;

import java.util.Date;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@Entity
@Table(name = "tb_empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_adm")
	private Long codigo;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private double sueldo;

	 @Temporal(TemporalType.DATE)
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
	// @JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechanaci;

    @Column(name = "codciudad")
	private int idCiudad;

	@ManyToOne
	@JoinColumn(name="codciudad", insertable = false, updatable = false)
	private Ciudad ciudad;

	private boolean state;

	// Hibernate no intentará insertar ni actualizar el valor de esa columna
	// cuando se persista un objeto Empleado en la base de datos.
	// @JoinColumn(name="codciudad", insertable = false, updatable = false)
}
