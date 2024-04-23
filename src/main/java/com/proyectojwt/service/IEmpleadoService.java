package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.empleado.EmpleadoSaveDto;

public interface IEmpleadoService {
	List<EmpleadoDTO> listaremplado();
	EmpleadoDTO create(EmpleadoSaveDto em);
	EmpleadoDTO edit(Long id, EmpleadoSaveDto empleadoSaveDto);
	EmpleadoDTO disabled(Long id);
	EmpleadoDTO findById(Long cod);

}
