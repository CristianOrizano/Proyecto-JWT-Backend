package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Empleado;
import java.util.List;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
         List<Empleado> findByCiudadCodigo(int ciu);
}
