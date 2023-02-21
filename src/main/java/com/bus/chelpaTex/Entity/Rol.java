package com.bus.chelpaTex.Entity;

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
@Table(name = "ROL")
public class Rol {
	
	public static final String ENTIDAD_ROL_ID_ROL = "idUsuario";
	public static final String ENTIDAD_ROL_ROL = "rol";
	public static final String ENTIDAD_ROL_ACTIVO= "activo";
	private static final String[] ATRIBUTOS_ENTIDAD_ROL = { ENTIDAD_ROL_ID_ROL, ENTIDAD_ROL_ROL,
			ENTIDAD_ROL_ACTIVO };
	
	

	@Id
	@Column(name = "id_rol")
	private Long idRol;

	@Column(name = "rol")
	private String rol;

	@Column(name = "activo")
	private Boolean activo;
	
/*	@ManyToOne(optional = false)
	@JoinColumn(name= "id_Usuario")
	private UsuarioRol idUsuario;
	*/


	public static boolean contieneAtributo(String atributo) {
	boolean contiene = false;
	for (final String atr : ATRIBUTOS_ENTIDAD_ROL) {
		if (atr.equals(atributo)) {
			contiene = true;
		}
	}

	return contiene;
	}

	public static String[] getAtributosEntidadRol() {
	return ATRIBUTOS_ENTIDAD_ROL;
	}
	

}
