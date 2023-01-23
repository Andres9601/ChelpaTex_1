package com.bus.chelpaTex.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
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
	
	private BigDecimal unidades;
	
	private BigDecimal valorTotalUnidades;
	
	private BigDecimal valorTotalEmpleados;
	
	private BigDecimal valorTotalMaquila;
	
	private BigDecimal valorTotalCif;
	
	private BigDecimal margenGanancia;
	
	private BigDecimal totalEstimado;
	
	private BigDecimal precioSugeridoVenta;
	
	private Boolean activo;

	public DisenoDTO(Long idDiseno, String nombre, Long idMolde, BigDecimal unidades, BigDecimal totalEstimado) {
		super();
		this.idDiseno = idDiseno;
		this.nombre = nombre;
		this.idMolde = idMolde;
		this.unidades = unidades;
		this.totalEstimado = totalEstimado;
	}
	
	
	
}
