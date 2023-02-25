package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MaquilaDTO;

@Service
public interface ServicioMaquila {
	
	@Qualifier("ServicioMaquilaImpl")
	public List<MaquilaDTO> consultar();
	
	@Qualifier("ServicioMaquilaImpl")
	MaquilaDTO crear(MaquilaDTO maquilaDTO) throws  Exception;

	@Qualifier("ServicioMaquilaImpl")
	List<MaquilaDTO> consultarMaquilasTipo(String tipoMaquila);

}
