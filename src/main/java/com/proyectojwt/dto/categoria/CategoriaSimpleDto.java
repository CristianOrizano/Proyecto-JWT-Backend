package com.proyectojwt.dto.categoria;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaSimpleDto {
    private Long  codigocate;
    private String nombre;
}
