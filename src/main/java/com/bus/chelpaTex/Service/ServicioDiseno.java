package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoRespuesta;


@Service
public interface ServicioDiseno {
	
	@Qualifier("ServicioDisenoImpl")
	public List<DisenoDTO> consultar (String idUsuario);
	
	@Qualifier("ServicioDisenoImpl")
	public DisenoDTO crear (DisenoDTO disenoDTO);

	@Qualifier("ServicioDisenoImpl")
	public NuevoDisenoRespuesta nuevoDiseno (NuevoDisenoDTO nuevoDisenoDTO);

	@Qualifier("ServicioDisenoImpl")
	public DisenoDTO actualizarDiseno (ActualizarDisenoDTO actualizarDisenoDTO);
	
	@Qualifier("ServicioDisenoImpl")
	public DisenoDTO actualizarDisenoMg (DisenoDTO disenoDTO);
	
	@Qualifier("ServicioDisenoImpl")
	public String eliminar (Long idDiseno);
	
}
