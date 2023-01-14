package com.bus.chelpaTex.DTO;

import java.io.Serializable;

import com.bus.chelpaTex.Entity.ColeccionDisenoPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColeccionDisenoDTO  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ColeccionDisenoPK coleccionDisenoPK;
	private Boolean activo;
}
