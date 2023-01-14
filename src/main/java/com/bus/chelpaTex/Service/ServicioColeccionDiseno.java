package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDisenoDTO;


@Service
public interface ServicioColeccionDiseno {
	
	@Qualifier("ServicioColeccionDisenoImpl")
	public ColeccionDisenoDTO crear(ColeccionDisenoDTO coleccionDisenoDTO);

}
