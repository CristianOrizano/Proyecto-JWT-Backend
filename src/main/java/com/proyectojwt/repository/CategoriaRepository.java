package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>  {
    List<Categoria> findByState(boolean estado);
}
