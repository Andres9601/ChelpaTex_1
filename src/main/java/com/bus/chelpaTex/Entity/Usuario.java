package com.bus.chelpaTex.Entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@Column(name = "id_usuario")
	private String idUsuario;

	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private Long telefono;

	@Column(name = "activo")
	private Boolean activo;
	
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioRol> usuarioRols;
}