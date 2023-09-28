package com.proyectojwt.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectojwt.entity.Rol;
import com.proyectojwt.entity.Usuario;
import com.proyectojwt.repository.UsuarioRepository;
import com.proyectojwt.security.UsuarioDetails;
import com.proyectojwt.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	IUsuarioService  ususervice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	  @Autowired
	 private  UsuarioDetails userDetailsService;
	//registrar usuario
	/*@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario usu) {

		Set<Rol> roles = new HashSet<>();

		for (Rol role : usu.getRoles()) {

			roles.add(role);
			System.out.println("codigo==>" + role.getId_rol() + "Nombre rol" + role.getNombre());
		}

			usu.setPassword(passwordEncoder.encode(usu.getPassword()));
			usu.setRoles(roles);
		
		Usuario empl = ususervice.guardar(usu);
		
		return new ResponseEntity<>(empl,HttpStatus.CREATED);
	}  */
	  @GetMapping("/actual-usuario")
	    public Usuario obtenerUsuarioActual(Principal principal){
		  return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
	        
	    }
	  
	  @PutMapping("/actualiza")
	    public ResponseEntity<Usuario> actualizarUsuario(@Valid @RequestBody Usuario usu){
		  Usuario user = ususervice.guardar(usu);
		  
		  return new ResponseEntity<>(user,HttpStatus.OK);
	    }
	  
      @PreAuthorize("hasAnyAuthority('ADMIN')")
	  @GetMapping("/lista")
	    public ResponseEntity<List<Usuario>> listarUsuarioo(){
		  List<Usuario> lista =  ususervice.listaUsuario();
		  return new ResponseEntity<>(lista,HttpStatus.OK);     
	    }
	  
	  
	@PostMapping("/registrar")
	public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody Usuario usu) {
		Map<String, Object> salida = new HashMap<>();
		Usuario user= ususervice.buscarnameuser(usu.getUsername());
		//System.out.println("nom==> "+user.getNombre());
		if(user != null) {
			salida.put("mensaje", "El nombre usuario ya existe en BD");
			return new ResponseEntity<>(salida,HttpStatus.OK);
		}

		//resgitro de usuario con el rol definido
		Set<Rol> roles = new HashSet<>();
		Rol role = new Rol();
		role.setId_rol(1);

		roles.add(role);

		usu.setId_usuario(0);
		usu.setPassword(passwordEncoder.encode(usu.getPassword()));
		usu.setRoles(roles);

		Usuario empl = ususervice.guardar(usu);
		salida.put("mensaje","Usuario registrado exitosamente" );

		return new ResponseEntity<>(salida,HttpStatus.OK);
	} 
	
}
