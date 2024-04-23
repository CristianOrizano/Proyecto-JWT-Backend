package com.proyectojwt.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteSimpleDto {
    private int codigo;

    private String nombre;

    private String apellido;
}
