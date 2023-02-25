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
@Table(name = "DISENO")
public class Diseno {
	
	@Id
	@GeneratedValue(generator = "SEQ_DISENO")
    @GenericGenerator(name = "SEQ_DISENO", strategy = "increment")
	@Column(name = "id_diseno")
	private Long idDiseno;
	
	@Column(name = "id_usuario")
	private String idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "id_molde")
	private Long idMolde;
	
	@Column(name = "id_trazabilidad")
	private String idTrazabilidad;
	
	@Column(name = "unidades")
	private BigDecimal unidades;
	
	@Column(name = "valor_total_unidades")
	private BigDecimal valorTotalUnidades;
	
	@Column(name = "valor_total_empleados")
	private BigDecimal valorTotalEmpleados;
	
	@Column(name = "valor_total_maquila")
	private BigDecimal valorTotalMaquila;
	
	@Column(name = "valor_total_gastos")
	private BigDecimal valorTotalGastos;
	
	@Column(name = "valor_total_cif")
	private BigDecimal valorTotalCif;
	
	@Column(name = "margen_ganancia")
	private BigDecimal margenGanancia;
	
	@Column(name = "total_estimado")
	private BigDecimal totalEstimado;
	
	@Column(name = "precio_sugerido_venta")
	private BigDecimal precioSugeridoVenta;
	
	@Column(name = "activo")
	private Boolean activo;
	
	

}
