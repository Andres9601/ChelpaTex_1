package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoCifDTO;

@Service
public interface ServicioDisenoCif {
	
	@Qualifier("ServicioDisenoCifImpl")
	public DisenoCifDTO crear(DisenoCifDTO disenoCifDTO);

}
