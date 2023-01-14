package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CifDTO;

@Service
public interface ServicioCif {
	
	@Qualifier("ServicioCifImpl")
	public CifDTO crear (CifDTO cifDTO);

}
