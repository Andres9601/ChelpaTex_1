package com.bus.chelpaTex.Entity;

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
public class Maquila {
	

	@Id
	@GeneratedValue(generator = "SEQ_MAQUILA")
    @GenericGenerator(name = "SEQ_MAQUILA", strategy = "increment")
	@Column(name = "id_maquila")
	private Long idMaquila;
	
	@Column(name = "tipo_maquila")
	private String tipoMaquila;
			
	@Column(name = "precioUnidad")
	private Long precioUnidad;
	
	@Column(name = "activo")
	private Boolean activo;

}
