package com.proyectojwt.service;

import com.proyectojwt.dto.boleta.BoletaDto;
import com.proyectojwt.dto.boleta.BoletaListDto;
import com.proyectojwt.entity.Boleta;

import java.util.List;

public interface IBoletaService {

    public void registrarBoleta(BoletaDto bean);

     List<BoletaListDto> findAll();
}
