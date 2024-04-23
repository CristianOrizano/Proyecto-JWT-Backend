package com.proyectojwt.dto.empleado.mapper;

import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.dto.empleado.EmpleadoSaveDto;
import com.proyectojwt.entity.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmpleadoMapper {
    //mapper-para save-update
    // @Mapping(target = "ciudad", source = "idCiudad")
    Empleado toEmpleado(EmpleadoSaveDto empleadoDTO);
    // findById
    EmpleadoDTO toEmpleadoDto(Empleado empleado);
    //list
    List<EmpleadoDTO> toEmpleadosDtos(List<Empleado> empleados);

}
