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
public class EmpleadoDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long numeroIdentificacion;
	
	private String nombre;
	
	private Long salario;
	
	private String cargo;
	
	private Long productividad;
	
	private Boolean activo;
	
	
}
