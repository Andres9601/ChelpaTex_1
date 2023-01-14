package com.bus.chelpaTex.Entity;

import java.io.Serializable;

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
@Table(name = "DISENO_CIF")
public class DisenoCif implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private DisenoCifPK disenoCifPK;
	
	
	@Column(name = "activo")
	private Boolean activo;
}
	