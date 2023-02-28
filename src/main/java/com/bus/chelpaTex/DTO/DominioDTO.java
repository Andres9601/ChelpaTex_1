package com.bus.chelpaTex.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DominioDTO  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDominio;
	
	private String tipoDominio;
	
	private String nombre;
	
	private Boolean activo;
	
	private String tipoDato;

	public DominioDTO(Long idDominio, String tipoDominio, String nombre, Boolean activo) {
		super();
		this.idDominio = idDominio;
		this.tipoDominio = tipoDominio;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	
	
}
