package com.proyectojwt.service.impl;

import java.util.List;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.categoria.CategoriaSimpleDto;
import com.proyectojwt.dto.categoria.mapper.CategoriaMapper;
import com.proyectojwt.exepciones.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojwt.entity.Categoria;
import com.proyectojwt.repository.CategoriaRepository;
import com.proyectojwt.service.ICategoria;

@Service
public class CategoriaService implements ICategoria{
	@Autowired
	CategoriaRepository categoryRepository;
	@Autowired
	CategoriaMapper categoriaMapper;

	@Override
	public List<CategoriaDto> findAll() {
		List<Categoria> lista =  categoryRepository.findAll();
		var categoriaDto= categoriaMapper.toCategoriasDtos(lista);
		return categoriaDto;
	}

	@Override
	public CategoriaDto findById(Long id) {
		Categoria category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("categoria", "id", id));
		CategoriaDto categoriaDto = categoriaMapper.toCategoriaDto(category);
		return categoriaDto;
	}

	@Override
	public CategoriaDto create(CategoriaSaveDto categoryBody) {
		Categoria categoria = categoriaMapper.toCategoria(categoryBody);
		categoria.setState(true);


		Categoria save = categoryRepository.save(categoria);
		return categoriaMapper.toCategoriaDto(save);
	}

	@Override
	public CategoriaDto edit(Long id, CategoriaSaveDto categoryBody) {
		Categoria categoria = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("categoria", "id", id));
		Categoria categoriaSave = categoriaMapper.toCategoria(categoryBody);
		categoriaSave.setCodigocate(categoria.getCodigocate());
		categoriaSave.setState(categoria.isState());

		Categoria save = categoryRepository.save(categoriaSave);
		return categoriaMapper.toCategoriaDto(save);
	}

	@Override
	public CategoriaDto disabled(Long id) {
		Categoria categoria = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("categoria", "id", id));
		categoria.setState(!categoria.isState());
		Categoria save = categoryRepository.save(categoria);
		return categoriaMapper.toCategoriaDto(save);
	}

	@Override
	public List<CategoriaSimpleDto> ListSimple() {
		var lista = categoryRepository.findByState(true);
		return  categoriaMapper.toCategoriaSimpleDtos(lista);
	}


}
