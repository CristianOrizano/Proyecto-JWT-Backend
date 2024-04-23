package com.proyectojwt.dto.boleta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectojwt.entity.Cliente;
import com.proyectojwt.entity.DetalleBoleta;
import com.proyectojwt.entity.Usuario;
import com.proyectojwt.repository.DetalleBoletaRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
public class BoletaDto {
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    private Long idcliente;
    private int idusuario;
    private double total;
    private List<DetalleBoletaDto> listaDetalleBol;



}
