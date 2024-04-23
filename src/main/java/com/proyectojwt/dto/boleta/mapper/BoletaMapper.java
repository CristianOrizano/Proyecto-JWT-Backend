package com.proyectojwt.dto.boleta.mapper;


import com.proyectojwt.dto.boleta.BoletaListDto;
import com.proyectojwt.entity.Boleta;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BoletaMapper {

   List <BoletaListDto> toBoletaListDto(List<Boleta> boleta);

}
