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
public class MaquilaDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idMaquila;
	
	private String tipoMaquila;
	
	private BigDecimal precioUnidad;
				
	private Boolean activo;
}
