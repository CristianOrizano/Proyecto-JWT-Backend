package com.proyectojwt.dto.empleado;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class EmpleadoSaveDto {
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
    private int idCiudad;
}
