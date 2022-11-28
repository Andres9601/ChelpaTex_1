package com.bus.chelpaTex.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ENTIDAD_EMPRESA_ID_EMPRESA = "idEmpresa";
	public static final String ENTIDAD_EMPRESA_NOMBRE = "nombre";
	public static final String ENTIDAD_EMPRESA_TELEFONO = "telefono";
	public static final String ENTIDAD_EMPRESA_ACTIVO= "activo";
	public static final String ENTIDAD_EMPRESA_ID_USUARIO= "idUsuario";
	private static final String[] ATRIBUTOS_ENTIDAD_EMPRESA = { ENTIDAD_EMPRESA_ID_EMPRESA, ENTIDAD_EMPRESA_NOMBRE, ENTIDAD_EMPRESA_TELEFONO,
			ENTIDAD_EMPRESA_ACTIVO,ENTIDAD_EMPRESA_ID_USUARIO };
	
	@Id
	@GeneratedValue(generator = "SEQ_EMPRESA")
	@GenericGenerator(name = "SEQ_EMPRESA", strategy = "increment" )
	@Column(name = "id_empresa")
	private Long idEmpresa;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private Long telefono;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "id_usuario")
	private String idUsuario;
	
	
	
	public static boolean contieneAtributo(String atributo) {
		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_EMPRESA) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
		}

		public static String[] getAtributosEntidadEmpresa() {
		return ATRIBUTOS_ENTIDAD_EMPRESA;
		}


	
}
