package com.bus.chelpaTex.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Long unidades;
	
	@Column(name = "valor_total_unidades")
	private Long valorTotalUnidades;
	
	@Column(name = "valor_total_empleados")
	private Long valorTotalEmpleados;
	
	@Column(name = "valor_total_maquila")
	private Long valorTotalMaquila;
	
	@Column(name = "valor_total_cif")
	private Long valorTotalCif;
	
	@Column(name = "margen_ganancia")
	private Long margenGanancia;
	
	@Column(name = "total_estimado")
	private Long totalEstimado;
	
	@Column(name = "precio_sugerido_venta")
	private Long precioSugeridoVenta;
	
	@Column(name = "activo")
	private Boolean activo;
	
	

}
