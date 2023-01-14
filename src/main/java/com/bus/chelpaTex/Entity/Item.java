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
	@Table(name = "ITEM")
	public class Item {
		
		@Id
		@GeneratedValue(generator = "SEQ_ITEM")
	    @GenericGenerator(name = "SEQ_ITEM", strategy = "increment")
		@Column(name = "id_item")
		private Long idItem;
		
		@Column(name = "tipo_item")
		private String tipoItem;
		
		@Column(name = "id_trazabilidad")
		private String idTrazabilidad;
				
		@Column(name = "activo")
		private Boolean activo;
		
		

	}



