package com.proyectojwt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.empleado.EmpleadoSaveDto;
import com.proyectojwt.dto.empleado.mapper.EmpleadoMapper;
import com.proyectojwt.entity.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.entity.Empleado;
import com.proyectojwt.exepciones.ResourceNotFoundException;
import com.proyectojwt.repository.EmpleadoRepository;
import com.proyectojwt.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    EmpleadoRepository empleadoRepository;
	@Autowired
	EmpleadoMapper empleadoMapper;

	@Override
	public List<EmpleadoDTO> listaremplado() {
		var lista = empleadoRepository.findAll();
		return empleadoMapper.toEmpleadosDtos(lista);
	}
	@Override
	public EmpleadoDTO create(EmpleadoSaveDto em) {
		Empleado empleadosave = empleadoMapper.toEmpleado(em);
		System.out.println("COD EMPLE==>"+ empleadosave.getCodigo());
        empleadosave.setState(true);
		Empleado save = empleadoRepository.save(empleadosave);
		return empleadoMapper.toEmpleadoDto(save);
	}
	@Override
	public EmpleadoDTO edit(Long id, EmpleadoSaveDto empleadoSaveDto) {
		Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("empleado", "id", id));
		Empleado empleadoSave = empleadoMapper.toEmpleado(empleadoSaveDto);
		empleadoSave.setCodigo(empleado.getCodigo());
		empleadoSave.setState(empleado.isState());
		Empleado save = empleadoRepository.save(empleadoSave);
		return empleadoMapper.toEmpleadoDto(save);
	}

	@Override
	public EmpleadoDTO disabled(Long id) {
		Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("empleado", "id", id));
		empleado.setState(!empleado.isState());
		Empleado save = empleadoRepository.save(empleado);
		return empleadoMapper.toEmpleadoDto(save);
	}

	@Override
	public EmpleadoDTO findById(Long cod) {
		Empleado empleado = empleadoRepository.findById(cod).orElseThrow(()-> new ResourceNotFoundException("empleado", "id", cod));
		EmpleadoDTO empleadoDTO = empleadoMapper.toEmpleadoDto(empleado);
		return empleadoDTO;
	}
}
