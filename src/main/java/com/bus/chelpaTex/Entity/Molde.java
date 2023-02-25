package com.bus.chelpaTex.Entity;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "MOLDE")
public class Molde {
	
	@Id
	@GeneratedValue(generator = "SEQ_MOLDE")
    @GenericGenerator(name = "SEQ_MOLDE", strategy = "increment")
	@Column(name = "id_molde")
	private Long idMolde;
	
	@Column(name = "id_usuario")
	private String idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "precio")
	private BigDecimal precio;
	
	@Column(name = "tipo_molde")
	private String tipoMolde;
	
	@Column(name = "tipo_prenda")
	private String tipoPrenda;
	
	@Column(name = "tipo_moda")
	private String tipoModa;
	
	@Column(name = "objetivo")
	private String objetivo;
	
	@Column(name = "tipo_acabado")
	private String tipoAcabado;
	
	@Column(name = "ancho_tela")
	private Long anchoTela;
	
	@Column(name = "consumo_total")
	private String consumoTotal;
	
	@Column(name = "tipo_produccion")
	private String tipoProduccion;
	
	@Column(name = "tipo_cascada")
	private String tipoCascada;
	
	@Column(name = "caracteristicas")
	private String caracteristicas;
	
	@Column(name = "ruta_archivo")
	private String rutaArchivo;
	
	@Column(name = "activo")
	private Boolean activo;

	public Molde(Long idMolde, String nombre, BigDecimal precio, String tipoPrenda, String tipoModa, String objetivo,
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
	
	public Molde(String nombre, Date fechaCreacion, BigDecimal precio, String tipoPrenda, String tipoModa,
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
