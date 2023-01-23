package com.bus.chelpaTex.DTO;

import java.io.Serializable;
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
		
	private Long unidades;
	
	private List<EmpleadoDTO> empleados;
		
	private List<Long> idsMaquilas;
	
	private List<CifDTO> cifs;
	
	private Long margenGanancia;
			
	private Boolean activo;

}
