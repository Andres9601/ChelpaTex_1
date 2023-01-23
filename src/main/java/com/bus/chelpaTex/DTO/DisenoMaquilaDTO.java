package com.bus.chelpaTex.DTO;

import java.io.Serializable;

import com.bus.chelpaTex.Entity.DisenoMaquilaPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DisenoMaquilaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DisenoMaquilaPK disenoMaquilaPK;
	private Boolean activo;

}
