package com.bus.chelpaTex.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CifDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idCif;
	
	private String tipoCif;
	
	private BigDecimal valor;
	
	private Long periodo;
	
	private BigDecimal productividadPeriodo;
		
	private Boolean activo;

}
