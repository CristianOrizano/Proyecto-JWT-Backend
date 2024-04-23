package com.proyectojwt.dto.boleta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectojwt.dto.cliente.ClienteDTO;
import com.proyectojwt.dto.cliente.ClienteSimpleDto;
import com.proyectojwt.dto.usuario.UsuarioSimpleDto;
import com.proyectojwt.entity.Usuario;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class BoletaListDto {
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
   // @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    private ClienteSimpleDto cliente;
    private UsuarioSimpleDto usuario;
    private double total;
}
