package com.proyectojwt.repository;

import com.proyectojwt.entity.Boleta;
import com.proyectojwt.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta,Integer> {
}
