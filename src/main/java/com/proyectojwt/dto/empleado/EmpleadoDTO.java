package com.proyectojwt.dto.empleado;

import java.util.Date;


import com.proyectojwt.dto.CiudadDTO;
import com.proyectojwt.dto.EstadoDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmpleadoDTO {
	private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private double sueldo;
    private Date fechanaci;
    private CiudadDTO ciudad;
    private boolean state;
}
