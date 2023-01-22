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
public class DisenoDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDiseno;
	
	private String idUsuario;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private Long idMolde;
	
	private String idTrazabilidad;
	
	private Long unidades;
	
	private Long valorTotalUnidades;
	
	private Long valorTotalEmpleados;
	
	private Long valorTotalMaquila;
	
	private Long valorTotalCif;
	
	private Long margenGanancia;
	
	private Long totalEstimado;
	
	private Long precioSugeridoVenta;
	
	private Boolean activo;

	public DisenoDTO(Long idDiseno, String nombre, Long idMolde, Long unidades, Long totalEstimado) {
		super();
		this.idDiseno = idDiseno;
		this.nombre = nombre;
		this.idMolde = idMolde;
		this.unidades = unidades;
		this.totalEstimado = totalEstimado;
	}
	
	
	
}
