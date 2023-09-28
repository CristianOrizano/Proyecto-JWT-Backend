package com.proyectojwt.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "tb_usuario")
@Entity
public class Usuario implements UserDetails{
	
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

		

	public String getNimagen() {
			return nimagen;
		}

		public void setNimagen(String nimagen) {
			this.nimagen = nimagen;
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}


	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
