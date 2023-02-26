package com.bus.chelpaTex.Service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CampoAdicionalDTO;

@Service
public interface ServicioCampoAdicional {
	
	@Qualifier("ServicioCampoAdicionalImpl")
	public CampoAdicionalDTO crear (CampoAdicionalDTO campoAdicionalDTO)throws  Exception;
	
	@Qualifier("ServicioCampoAdicionalImpl")
	public List<CampoAdicionalDTO> consultarCamposAdicionalesItem (Long idItem)throws InvalidParameterException;

}
