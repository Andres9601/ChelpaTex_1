package com.bus.chelpaTex.DTO;

import java.io.Serializable;

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
	
	private Long  cantidad;
	
	private Boolean activo;

	public MoldeItemDTO(Long cantidad) {
		super();
		this.cantidad = cantidad;
	}

	
}
