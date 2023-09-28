package com.proyectojwt.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class EmpleadoDTO {
	
	private int codigo;
	
	@Size(min = 3,message = "el nombre minimo 3 caracteres")
	@NotBlank(message = "El nombre obligatorio")
    private String nombre;
    
	@NotBlank(message = "El apellido obligatorio")
	@Size(min = 3,message = "el apellido minimo 3 caracteres")
    private String apellido;
	
	@NotBlank(message = "La direccion obligatorio")
	@Size(min = 3,max=20,message = "la direccion min:3 max:20 caracteres")
    private String direccion;
    
	@Min(value = 100000000, message = "El número de teléfono debe tener al menos 9 dígitos")
    private int telefono;
    
    @DecimalMin(value = "10.0", message = "El sueldo debe ser igual o mayor a 10")
	@DecimalMax(value = "10000.0", message = "El sueldo debe ser menor o igual a 10.000")
    private double sueldo;
    
    private Date fechanaci;
    
    private EstadoDTO estad;
    
    private CiudadDTO ciudad;
     
    
	
	public EstadoDTO getEstad() {
		return estad;
	}
	public void setEstad(EstadoDTO estad) {
		this.estad = estad;
	}
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Date getFechanaci() {
		return fechanaci;
	}
	public void setFechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}
    
    
}
