package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);

}
