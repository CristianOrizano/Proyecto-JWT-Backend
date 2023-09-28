package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Ciudad;
import java.util.List;


public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
	
	//buscar ciudad
	Ciudad findByCodigo(int codigo);

}
