package com.bus.chelpaTex.Entity;

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
@Table(name = "CIF")
public class Cif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cif")
	private Long idColeccion;
	
	@Column(name = "tipo_cif")
	private String tipoCif;
	
	@Column(name = "valor")
	private Long valor;
	
	@Column(name = "periodo")
	private Long periodo;
	
	@Column(name = "productividad_periodo")
	private Long productividadPeriodo;
		
	@Column(name = "activo")
	private Boolean activo;
	
	

}

