package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DominioDTO;


@Service
public interface ServicioDominio {
	
	@Qualifier("ServicioDominioImpl")
	public List<DominioDTO> consultarTiposItem() throws Exception;
	
	@Qualifier("ServicioDominioImpl")
	public List<DominioDTO> consultarTiposMaquila() throws Exception;

	@Qualifier("ServicioDominioImpl")
	public List<DominioDTO>  consultarDominiosTipo(String tipoDominio) throws Exception;

	@Qualifier("ServicioDominioImpl")
	public List<DominioDTO> consultarCamposTipoItem(String tipoItem) throws Exception;

}
