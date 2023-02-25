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
public class MoldeDTO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private Long idMolde;
	
	private String idUsuario;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private BigDecimal precio;
	
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

	public MoldeDTO(Long idMolde, String nombre, BigDecimal precio, String tipoPrenda, String tipoModa, String objetivo,
			String tipoAcabado, String rutaArchivo, Boolean activo) {
		super();
		this.idMolde = idMolde;
		this.nombre = nombre;
		this.precio = precio;
		this.tipoPrenda = tipoPrenda;
		this.tipoModa = tipoModa;
		this.objetivo = objetivo;
		this.tipoAcabado = tipoAcabado;
		this.rutaArchivo = rutaArchivo;
		this.activo = activo;
	}

	public MoldeDTO(String nombre, Date fechaCreacion, BigDecimal precio, String tipoPrenda, String tipoModa,
			String objetivo, String tipoAcabado, Long anchoTela, String consumoTotal, String tipoProduccion,
			String tipoCascada, String caracteristicas, String rutaArchivo, Boolean activo) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.precio = precio;
		this.tipoPrenda = tipoPrenda;
		this.tipoModa = tipoModa;
		this.objetivo = objetivo;
		this.tipoAcabado = tipoAcabado;
		this.anchoTela = anchoTela;
		this.consumoTotal = consumoTotal;
		this.tipoProduccion = tipoProduccion;
		this.tipoCascada = tipoCascada;
		this.caracteristicas = caracteristicas;
		this.rutaArchivo = rutaArchivo;
		this.activo = activo;
	}
	
	
	
	
}
