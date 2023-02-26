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
public class CampoAdicionalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idCampo;
	
	private Long idItem;
	
	private String nombre;
	
	private String valor;
	
	private Boolean activo;

	

}