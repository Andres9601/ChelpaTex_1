package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;


@Service
public interface ServicioColeccionDiseno {
	
	@Qualifier("ServicioColeccionDisenoImpl")
	public ColeccionDisenoDTO crear(ColeccionDisenoDTO coleccionDisenoDTO);

	@Qualifier("ServicioColeccionDisenoImpl")
	public ColeccionDisenoDTO crearColeccionDiseno(NuevoDisenoDTO nuevoDisenoDTO, DisenoDTO disenor);

}
