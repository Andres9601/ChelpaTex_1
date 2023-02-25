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
	
	private String diseño;
	
	private String ubicacion;
	
	private String tamaño;
	
	private String tipoMaterial;
	
	private String estadoPieza;
	
	private Long cantidadColores;
	
	private BigDecimal metrosImpresion;
	
	private String tallaje;
	
	private Long numeroImpresiones;
	
	private String tipoPrenda;
	
	private String maquinasEspeciales;
	
	private BigDecimal cantidadPorPrenda;	
	
	private String idUsuario;	
	
	private Boolean activo;
	
	public MaquilaDTO(Long idMaquila, String tipoMaquila, BigDecimal precioUnidad, Boolean activo) {
		super();
		this.idMaquila = idMaquila;
		this.tipoMaquila = tipoMaquila;
		this.precioUnidad = precioUnidad;
		this.activo = activo;
	}
	
}
