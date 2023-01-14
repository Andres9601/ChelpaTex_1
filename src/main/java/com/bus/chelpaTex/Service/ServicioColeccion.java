package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDTO;


@Service
public interface ServicioColeccion {
	
	@Qualifier("ServicioColeccionImpl")
	public List<ColeccionDTO> consultar (String idUsuario);
	
	@Qualifier("ServicioColeccionImpl")
	public ColeccionDTO crear (ColeccionDTO coleccionDTO);
	
	@Qualifier("ServicioColeccionImpl")
	public String eliminar (Long idColeccion);
	

}
