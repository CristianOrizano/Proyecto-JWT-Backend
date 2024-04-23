package com.proyectojwt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "tb_usuario")
@Entity
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Email(message = "El valor debe ser una dirección de correo electrónico valida")
	@NotBlank(message = "El email obligatorio")
	private String email;
	
	@NotBlank(message = "El nombre obligatorio")
	@Size(min = 3,max=20,message = "el nombre min:3 max:20 caracteres")
	private String nombre;
	
	@NotBlank(message = "El apellido obligatorio")
	@Size(min = 3,max=20,message = "la apellido min:3 max:20 caracteres")
	private String apellido;
	
	private boolean enabled=true;
	
	@NotBlank(message = "El username obligatorio")
	@Size(min = 3,max=50,message = "El username min:3 max:50 caracteres")
	private String username;
	
	@NotBlank(message = "El password es obligatorio")
	@Size(min = 3, message = "El password debe tener 3 caracteres")
	private String password;
	
	private String nimagen;
	
		@ManyToMany( fetch = FetchType.EAGER)
		@JoinTable(name = "tb_usuario_role", // nombre tb intemedia
				joinColumns = @JoinColumn(name = "id_usuario"), //nombre fk de usuario
				inverseJoinColumns = @JoinColumn(name = "id_rol") // nombre fk de rol
		)
		private Set<Rol> roles= new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> autoridades = new HashSet<>();
		this.roles.forEach(usuarioRol -> {
			autoridades.add(new Authority(usuarioRol.getNombre()));
		});
		return autoridades;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}


}
