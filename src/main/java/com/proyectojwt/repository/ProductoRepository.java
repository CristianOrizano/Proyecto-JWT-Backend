package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
