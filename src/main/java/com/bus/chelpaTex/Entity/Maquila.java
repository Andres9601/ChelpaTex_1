package com.bus.chelpaTex.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "MAQUILA")
public class Maquila implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(generator = "SEQ_MAQUILA")
    @GenericGenerator(name = "SEQ_MAQUILA", strategy = "increment")
	@Column(name = "id_maquila")
	private Long idMaquila;
	
	@Column(name = "tipo_maquila")
	private String tipoMaquila;
			
	@Column(name = "precio_unidad")
	private BigDecimal precioUnidad;
	
	@Column(name = "diseño")
	private String diseño;
	
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@Column(name = "tamaño")
	private String tamaño;
	
	@Column(name = "tipo_material")
	private String tipoMaterial;
	
	@Column(name = "estado_pieza")
	private String estadoPieza;
	
	@Column(name = "cantidad_colores")
	private Long cantidadColores;
	
	@Column(name = "metros_impresion")
	private BigDecimal metrosImpresion;
	
	@Column(name = "tallaje")
	private String tallaje;
	
	@Column(name = "numero_impresiones")
	private Long numeroImpresiones;
	
	@Column(name = "tipo_prenda")
	private String tipoPrenda;
	
	@Column(name = "maquinas_especiales")
	private String maquinasEspeciales;
	
	@Column(name = "cantidad_por_prenda")
	private BigDecimal cantidadPorPrenda;	
	
	@Column(name = "id_usuario")
	private String idUsuario;	
	
	@Column(name = "activo")
	private Boolean activo;

	public Maquila(Long idMaquila, String tipoMaquila, BigDecimal precioUnidad, Boolean activo) {
		super();
		this.idMaquila = idMaquila;
		this.tipoMaquila = tipoMaquila;
		this.precioUnidad = precioUnidad;
		this.activo = activo;
	}

	
	
}
