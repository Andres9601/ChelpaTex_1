package com.bus.chelpaTex.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String ENTIDAD_USUARIO_ID_USUARIO = "idUsuario";
	public static final String ENTIDAD_USUARIO_EMAIL = "email";
	public static final String ENTIDAD_USUARIO_ACTIVO= "activo";
	private static final String[] ATRIBUTOS_ENTIDAD_USUARIO = { ENTIDAD_USUARIO_ID_USUARIO, ENTIDAD_USUARIO_EMAIL,
			ENTIDAD_USUARIO_ACTIVO };
	
	

	@Id
	@Column(name = "id_usuario")
	private String idUsuario;

	@Column(name = "email")
	private String email;

	@Column(name = "activo")
	private Boolean activo;
	
	/*@ManyToOne(optional = false)
	@JoinColumn(name= "id_rol")
	private UsuarioRol idRol;
	*/


	public static boolean contieneAtributo(String atributo) {
	boolean contiene = false;
	for (final String atr : ATRIBUTOS_ENTIDAD_USUARIO) {
		if (atr.equals(atributo)) {
			contiene = true;
		}
	}

	return contiene;
	}

	public static String[] getAtributosEntidadUsuario() {
	return ATRIBUTOS_ENTIDAD_USUARIO;
	}
	

}
