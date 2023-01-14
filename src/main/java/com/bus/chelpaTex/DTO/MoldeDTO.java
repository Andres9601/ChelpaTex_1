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
public class MoldeDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private Long idMolde;
	
	private String idUsuario;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private Long precio;
	
	private String tipoMolde;
	
	private String tipoPrenda;
	
	private String tipoModa;
	
	private String objetivo;
	
	private String tipoAcabado;
	
	private Long anchoTela;
	
	private String consumoTotal;
	
	private String tipoProduccion;
	
	private String tipoCascada;
	
	private String caracteristicas;
	
	private String rutaArchivo;
	
	private Boolean activo;
	
}
