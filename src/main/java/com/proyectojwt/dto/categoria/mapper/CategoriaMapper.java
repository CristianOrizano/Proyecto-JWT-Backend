package com.proyectojwt.dto.categoria.mapper;
import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.categoria.CategoriaSimpleDto;
import com.proyectojwt.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoriaMapper {

    CategoriaDto toCategoriaDto(Categoria categoria);
    List<CategoriaDto> toCategoriasDtos(List<Categoria> categories);

  //  CategoriaSimpleDto toCategoriaSimpleDto(Categoria category);
    List<CategoriaSimpleDto> toCategoriaSimpleDtos(List<Categoria> categories);

    Categoria toCategoria(CategoriaSaveDto categorySaveDto);

}
