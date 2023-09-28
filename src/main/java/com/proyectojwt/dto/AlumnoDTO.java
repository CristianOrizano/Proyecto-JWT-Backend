package com.proyectojwt.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlumnoDTO {
	
	private int codigo;

	@Size(min = 3,message = "el nombre minimo 3 caracteres")
	@NotBlank(message = "El nombre obligatorio")
	private String nombre;
	
	@Size(min = 3,message = "el apellido minimo 3 caracteres")
	@NotBlank(message = "El apellido obligatorio")
	private String apellido;

	@Size(min = 3,message = "la direccion minimo 3 caracteres")
	@NotBlank(message = "la direccion obligatorio")
	private String direccion;
	
	 private CiudadDTO ciudad;
	
	
	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
