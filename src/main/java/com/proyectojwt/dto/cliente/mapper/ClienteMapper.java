package com.proyectojwt.dto.cliente.mapper;

import com.proyectojwt.dto.cliente.ClienteDTO;
import com.proyectojwt.dto.cliente.ClienteSaveDto;
import com.proyectojwt.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {
    //mapper-para save-update
    Cliente toCliente(ClienteSaveDto clienteSaveDtoDTO);
    // findById
    ClienteDTO toClienteDto(Cliente cliente);
    //list
    List<ClienteDTO> toClientesDtos(List<Cliente> clientes);

}
