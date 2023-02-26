package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CampoAdicionalDTO;
import com.bus.chelpaTex.Entity.CampoAdicional;
import com.bus.chelpaTex.Repo.ManejadorCampoAdicional;
import com.bus.chelpaTex.Service.ServicioCampoAdicional;
import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
public class ServicioCampoAdicionalImpl  implements ServicioCampoAdicional{
	
	private static final Logger logger =  Logger.getLogger(ServicioCampoAdicional.class.getName());

	
	@Autowired
	ManejadorCampoAdicional manejadorCampoAdicional;
	
	@Autowired 
	ServiceUtil serviceUtil;

	@Override
	public CampoAdicionalDTO crear(CampoAdicionalDTO campoAdicionalDTO) throws Exception {
		try {
		CampoAdicional campoAdicional = new CampoAdicional();
		campoAdicionalDTO.setActivo(true);
		serviceUtil.copiarAtributos(campoAdicionalDTO, campoAdicional);
		manejadorCampoAdicional.save(campoAdicional);
		return campoAdicionalDTO;
		}
		catch(InvalidParameterException e){
			logger.info(e.getCause() +e.getMessage());
			throw new InvalidParameterException("No se pudo crear el campo, Revise los parametros");
		}
	}

	@Override
	public List<CampoAdicionalDTO> consultarCamposAdicionalesItem(Long idItem) throws InvalidParameterException {
		List<CampoAdicionalDTO> camposAdicionalesDTO=  manejadorCampoAdicional.consultarCamposAdicionalesIdItem(idItem);
		return camposAdicionalesDTO;
	}
	

}
