package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.CifDTO;
import com.bus.chelpaTex.DTO.DisenoCifDTO;
import com.bus.chelpaTex.DTO.GastoCifDTO;

@Service
public interface ServicioDisenoCif {
	
	@Qualifier("ServicioDisenoCifImpl")
	public DisenoCifDTO crear(DisenoCifDTO disenoCifDTO);

	@Qualifier("ServicioDisenoCifImpl")
	public GastoCifDTO calcularValorCifs(List<CifDTO> cifs, ActualizarDisenoDTO actualizarDisenoDTO);

}
