package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoEmpleadoDTO;

@Service
public interface ServicioDisenoEmpleado {
	
	@Qualifier("ServicioDisenoEmpleadoImpl")
	public DisenoEmpleadoDTO crear(DisenoEmpleadoDTO disenoEmpleadoDTO);

}
