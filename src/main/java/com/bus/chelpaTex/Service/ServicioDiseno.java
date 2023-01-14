package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoDTO;


@Service
public interface ServicioDiseno {
	
	@Qualifier("ServicioDisenoImpl")
	public List<DisenoDTO> consultar (String idUsuario);
	
	@Qualifier("ServicioDisenoImpl")
	public DisenoDTO crear (DisenoDTO disenoDTO);

	
	
}
