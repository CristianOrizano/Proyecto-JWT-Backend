package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.dto.cliente.ClienteDTO;
import com.proyectojwt.dto.cliente.ClienteSaveDto;
import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.dto.empleado.EmpleadoSaveDto;
import com.proyectojwt.entity.Cliente;

public interface IClienteService {
	List<ClienteDTO> listarcliente();
	ClienteDTO create(ClienteSaveDto em);
	ClienteDTO edit(Long id, ClienteSaveDto clienteSaveDto);
	ClienteDTO disabled(Long id);
	ClienteDTO findById(Long cod);

}
