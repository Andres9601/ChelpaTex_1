package com.bus.chelpaTex.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "EMPLEADO")
public class Empleado {
	
	@Id
	@Column(name = "numero_identificacion")
	private Long numeroIdentificacion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "salario")
	private Long salario;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "productividad")
	private Long productividad;
	
	@Column(name = "activo")
	private Boolean activo;
	
	

}

