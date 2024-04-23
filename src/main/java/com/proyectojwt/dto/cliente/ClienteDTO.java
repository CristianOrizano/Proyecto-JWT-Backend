package com.proyectojwt.dto.cliente;


import com.proyectojwt.dto.CiudadDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {
	
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
	private int ndocumento;
	private int telefono;
	private boolean state;

}
