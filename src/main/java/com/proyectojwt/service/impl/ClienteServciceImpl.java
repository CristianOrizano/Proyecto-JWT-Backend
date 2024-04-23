package com.proyectojwt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.cliente.ClienteSaveDto;
import com.proyectojwt.dto.cliente.mapper.ClienteMapper;
import com.proyectojwt.dto.empleado.mapper.EmpleadoMapper;
import com.proyectojwt.entity.Categoria;
import com.proyectojwt.entity.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.dto.cliente.ClienteDTO;
import com.proyectojwt.entity.Cliente;
import com.proyectojwt.exepciones.ResourceNotFoundException;
import com.proyectojwt.repository.ClienteRepository;
import com.proyectojwt.repository.CiudadRepository;
import com.proyectojwt.service.IClienteService;

@Service
public class ClienteServciceImpl implements IClienteService {
	//NOta: findByCodigo no devuelve optional asi que no usar orElseThrow
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteMapper clienteMapper;

	@Override
	public List<ClienteDTO> listarcliente() {
		var lista = clienteRepository.findAll();
		return clienteMapper.toClientesDtos(lista);
	}

	@Override
	public ClienteDTO create(ClienteSaveDto em) {
		Cliente clientesave = clienteMapper.toCliente(em);
		clientesave.setState(true);
		Cliente save = clienteRepository.save(clientesave);
		return clienteMapper.toClienteDto(save);
	}

	@Override
	public ClienteDTO edit(Long id, ClienteSaveDto clienteSaveDto) {
		Cliente empleado = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente", "id", id));
		Cliente empleadoSave = clienteMapper.toCliente(clienteSaveDto);
		empleadoSave.setCodigo(empleado.getCodigo());
		empleadoSave.setState(empleado.isState());
		Cliente save = clienteRepository.save(empleadoSave);
		return clienteMapper.toClienteDto(save);
	}

	@Override
	public ClienteDTO disabled(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cliente", "id", id));
		cliente.setState(!cliente.isState());
		Cliente save = clienteRepository.save(cliente);
		return clienteMapper.toClienteDto(save);
	}

	@Override
	public ClienteDTO findById(Long cod) {
		Cliente cliente = clienteRepository.findById(cod).orElseThrow(()-> new ResourceNotFoundException("categoria", "id", cod));
		ClienteDTO clienteDTO = clienteMapper.toClienteDto(cliente);
		return clienteDTO;
	}
}
