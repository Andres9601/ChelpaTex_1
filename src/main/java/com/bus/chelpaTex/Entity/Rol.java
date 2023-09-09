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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ROL")
public class Rol {
	
	@Id
	@Column(name = "id_rol")
	private Long idRol;

	@Column(name = "rol")
	private String rol;

	@Column(name = "activo")
	private Boolean activo;
	
	@OneToMany(mappedBy = "rol")
	private List<UsuarioRol> usuarioRols;

}