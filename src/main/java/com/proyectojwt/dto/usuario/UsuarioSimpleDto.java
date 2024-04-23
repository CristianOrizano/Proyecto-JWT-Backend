package com.proyectojwt.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioSimpleDto {

    private String email;

    private String nombre;

    private String apellido;
}
