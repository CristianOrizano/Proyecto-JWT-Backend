package com.proyectojwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyectojwt.entity.Usuario;
import com.proyectojwt.service.IUsuarioService;

@SpringBootTest
class ProyectoJwtApplicationTests {

	@Autowired
	IUsuarioService  ususervice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	void contextLoads() {
		
		Usuario usu= new Usuario();
		usu.setId_usuario(19);
		usu.setNombre("lucas");
		usu.setApellido("lopez");
		usu.setUsername("lucas123");
		usu.setPassword(passwordEncoder.encode("123"));
		usu.setEmail("lucas@gma");
		usu.setEnabled(true);
		ususervice.guardar(usu);
		
		
	}

}
