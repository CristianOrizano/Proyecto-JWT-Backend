package com.proyectojwt.dto.categoria;


import com.proyectojwt.entity.Producto;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
public class CategoriaSaveDto {
    private String nombre;
    private String descripcion;
    private List<Producto> listaCategorias;
}
