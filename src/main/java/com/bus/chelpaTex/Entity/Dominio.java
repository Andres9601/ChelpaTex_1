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
@Table(name = "DOMINIO")
public class Dominio {
	
	@Id
	@GeneratedValue(generator = "SEQ_DOMINIO")
    @GenericGenerator(name = "SEQ_DOMINIO", strategy = "increment")
	@Column(name = "id_dominio")
	private Long idDominio;
	
	@Column(name = "tipo_dominio")
	private String tipoDominio;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "activo")
	private Boolean activo;

	

}
