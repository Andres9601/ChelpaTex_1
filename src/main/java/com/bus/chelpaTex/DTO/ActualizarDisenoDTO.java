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
public class ActualizarDisenoDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDiseno;
	
	private String idUsuario;
	
	private String nombre;
		
	private Long idMolde;
		
	private BigDecimal unidades;
	
	private List<EmpleadoDTO> empleados;
		
	private List<Long> idsMaquilas;
	
	private List<CifDTO> cifs;
	
	private BigDecimal margenGanancia;
			
	private Boolean activo;

}
