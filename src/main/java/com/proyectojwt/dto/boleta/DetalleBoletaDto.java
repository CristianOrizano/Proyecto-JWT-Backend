package com.proyectojwt.dto.boleta;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DetalleBoletaDto {
    private int idProducto;
    private int cantidad;
}
