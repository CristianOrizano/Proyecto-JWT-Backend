package com.proyectojwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectojwt.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer> {

}
