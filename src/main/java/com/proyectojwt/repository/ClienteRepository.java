package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
