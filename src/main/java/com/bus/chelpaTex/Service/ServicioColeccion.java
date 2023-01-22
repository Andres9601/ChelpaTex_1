package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionCompletaDTO;
import com.bus.chelpaTex.DTO.ColeccionDTO;
import com.bus.chelpaTex.DTO.MisColeccionesDTO;


@Service
public interface ServicioColeccion {
	
	@Qualifier("ServicioColeccionImpl")
	public List<ColeccionDTO> consultar (String idUsuario);
	
	@Qualifier("ServicioColeccionImpl")
	public List<MisColeccionesDTO> consultarColeccionesUsuario (String idUsuario);
	
	@Qualifier("ServicioColeccionImpl")
	public ColeccionCompletaDTO consultarColeccionCompleta (Long idColeccion);
	
	@Qualifier("ServicioColeccionImpl")
	public ColeccionDTO crear (ColeccionDTO coleccionDTO);
	
	@Qualifier("ServicioColeccionImpl")
	public ColeccionDTO nuevaColeccion (ColeccionDTO coleccionDTO) throws Exception;
	
	@Qualifier("ServicioColeccionImpl")
	public String eliminar (Long idColeccion);
	

}
