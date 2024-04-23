package com.proyectojwt.service.impl;

import com.proyectojwt.dto.boleta.BoletaDto;
import com.proyectojwt.dto.boleta.BoletaListDto;
import com.proyectojwt.dto.boleta.DetalleBoletaDto;
import com.proyectojwt.dto.boleta.mapper.BoletaMapper;
import com.proyectojwt.entity.*;
import com.proyectojwt.repository.BoletaRepository;
import com.proyectojwt.repository.DetalleBoletaRepository;
import com.proyectojwt.repository.ProductoRepository;
import com.proyectojwt.service.IBoletaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoletaService implements IBoletaService {
    @Autowired
    private BoletaRepository boletaRepository;

    @Autowired
    private DetalleBoletaRepository repodeta;

    @Autowired
    private ProductoRepository ele;

    @Autowired
    private BoletaMapper boletaMapper;


    @Transactional
    public void registrarBoleta(BoletaDto bean) {
        try {
            Cliente cliente = new Cliente();
            cliente.setCodigo(bean.getIdcliente());

            Usuario usuario = new Usuario();
            usuario.setId_usuario(bean.getIdusuario());

            // Grabar Boleta
            Boleta boleta = new Boleta();
            boleta.setFechaEmision(new Date());
            boleta.setCliente(cliente);
            boleta.setUsuario(usuario);
            boleta.setTotal(bean.getTotal());

            Boleta boletaGuardada = boletaRepository.save(boleta);

            // Asignar el ID de la boleta a los detalles
            List<DetalleBoleta> detalles = new ArrayList<>();
            for (DetalleBoletaDto detalleDTO : bean.getListaDetalleBol()) {
                DetalleBoleta detalle = new DetalleBoleta();
                DetalleBoletaPK pk = new DetalleBoletaPK();
                pk.setIdBoleta(boletaGuardada.getId()); // Asignar el ID de la boleta
                pk.setIdProducto(detalleDTO.getIdProducto()); // Asignar el ID del producto

                detalle.setPk(pk);
                detalle.setCantidad(detalleDTO.getCantidad());
                detalles.add(detalle);
            }
            boletaGuardada.setListaDetalleBol(detalles);
            // Guardar la boleta con sus detalles
            boletaRepository.save(boletaGuardada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BoletaListDto> findAll() {
        var lista = boletaRepository.findAll();
        return  boletaMapper.toBoletaListDto(lista);
    }
}
