package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MoldeDTO;


@Service
public interface ServicioMolde {
	
	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado);
	
	@Qualifier("ServicioMoldeImpl")
	public MoldeDTO crear (MoldeDTO moldeDTO);
	
}
