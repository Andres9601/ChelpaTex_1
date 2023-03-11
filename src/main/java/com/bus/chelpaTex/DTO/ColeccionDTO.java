package com.bus.chelpaTex.DTO;

import java.io.Serializable;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColeccionDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idColeccion;
	
	private String idUsuario;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private Boolean activo;
	
	private String iniciales;

	private String color;
	

}
