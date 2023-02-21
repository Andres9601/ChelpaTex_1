package com.bus.chelpaTex.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "DISENO_MAQUILA")
public class DisenoMaquila {
	
	
	@EmbeddedId
	private DisenoMaquilaPK disenoMaquilaPK;
	
	
	@Column(name = "activo")
	private Boolean activo;
}