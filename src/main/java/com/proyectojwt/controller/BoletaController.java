package com.proyectojwt.controller;

import com.proyectojwt.dto.boleta.BoletaDto;
import com.proyectojwt.dto.boleta.BoletaListDto;
import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.service.impl.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boleta")
@CrossOrigin("*")
public class BoletaController {
    @Autowired
    BoletaService boletaService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> GenerarVenta(@RequestBody BoletaDto boleta){
        System.out.println("=>>>>>>>>>>> total:  "+ boleta.getTotal());
        System.out.println("=>>>>>>>>>>> valor:  "+ boleta.getIdusuario());
        System.out.println("=>>>>>>>>>>> valorcliente :  "+ boleta.getIdcliente());
        Map<String, Object> salida = new HashMap<>();
        boletaService.registrarBoleta(boleta);
        String men = "Venta generado";
        salida.put("mensaje", men);
        return new ResponseEntity<>(salida, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<BoletaListDto>> listaboletas() {
        List<BoletaListDto>lista= boletaService.findAll();
        return ResponseEntity.ok(lista);
    }



}
