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
@Table(name = "CAMPO_ADICIONAL")
public class CampoAdicional {
	
	@Id
	@GeneratedValue(generator = "SEQ_CAMPO_ADICIONAL")
    @GenericGenerator(name = "SEQ_CAMPO_ADICIONAL", strategy = "increment")
	@Column(name = "id_campo")
	private Long idCampo;
	
	@Column(name = "id_item")
	private Long idItem;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "valor")
	private String valor;
	
	@Column(name = "activo")
	private Boolean activo;

	

}


