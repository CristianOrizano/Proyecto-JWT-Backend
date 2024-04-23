package com.proyectojwt.dto.categoria;

import lombok.Builder;
import lombok.Data;


@Data
public class CategoriaDto {
    private Long  codigocate;
    private String nombre;
    private String descripcion;
    private boolean state;

}
