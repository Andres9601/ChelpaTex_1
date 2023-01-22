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
public class DisenosColeccionDTO implements  Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDiseno;
	private String nombre;
	private String nombreMolde;
	private Long costoDiseno;
	private Long unidades;

}
