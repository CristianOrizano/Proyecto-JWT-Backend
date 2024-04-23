package com.proyectojwt.service;

import java.util.List;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.categoria.CategoriaSimpleDto;
import com.proyectojwt.entity.Categoria;

public interface ICategoria {
	public List<CategoriaDto> findAll();
	CategoriaDto findById(Long id);

	CategoriaDto create(CategoriaSaveDto categoryBody);

	CategoriaDto edit(Long id, CategoriaSaveDto categoryBody);

	CategoriaDto disabled(Long id);

	public List<CategoriaSimpleDto> ListSimple();

}
