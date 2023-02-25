package com.bus.chelpaTex.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "USUARIO_ROL")
public class UsuarioRol {
	
	public static final String ENTIDAD_USUARIO_ROL_ID_ROL = "usuarioRolPK.idRol";
	public static final String ENTIDAD_USUARIO_ROL_ID_USUARIO = "usuarioRolPK.idUsuario";
	public static final String ENTIDAD_USUARIO_ROL_ACTIVO= "activo";
	private static final String[] ATRIBUTOS_ENTIDAD_USUARIO_ROL = { ENTIDAD_USUARIO_ROL_ID_ROL, ENTIDAD_USUARIO_ROL_ID_USUARIO,
			ENTIDAD_USUARIO_ROL_ACTIVO };

	
	@EmbeddedId
	private UsuarioRolPK usuarioRolPK;
	
	@Column(name = "activo")
	private Boolean activo;
	
	
	public static boolean contieneAtributo(String atributo) {
	boolean contiene = false;
	for (final String atr : ATRIBUTOS_ENTIDAD_USUARIO_ROL) {
		if (atr.equals(atributo)) {
			contiene = true;
		}
	}

	return contiene;
	}

	public static String[] getAtributosEntidadUsuarioRol() {
	return ATRIBUTOS_ENTIDAD_USUARIO_ROL;
	}
	

}
