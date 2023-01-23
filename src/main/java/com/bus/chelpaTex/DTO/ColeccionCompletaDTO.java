package com.bus.chelpaTex.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColeccionCompletaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private BigDecimal costoColeccion;
	
	private List<DisenosColeccionDTO> disenos;
	

}
