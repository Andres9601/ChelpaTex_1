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
	
	

}
