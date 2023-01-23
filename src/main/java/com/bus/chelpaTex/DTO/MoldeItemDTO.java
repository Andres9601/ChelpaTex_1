package com.bus.chelpaTex.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bus.chelpaTex.Entity.MoldeItemPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MoldeItemDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MoldeItemPK moldeItemPK;
	
	private BigDecimal  cantidad;
	
	private Boolean activo;

	public MoldeItemDTO(BigDecimal cantidad) {
		super();
		this.cantidad = cantidad;
	}

	
}
