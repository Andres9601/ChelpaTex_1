package com.bus.chelpaTex.ServiceImpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DominioDTO;
import com.bus.chelpaTex.Repo.ManejadorDominio;
import com.bus.chelpaTex.Service.ServicioDominio;



@Service
public class ServicioDominioImpl implements ServicioDominio{
	
	private static final Logger logger =  Logger.getLogger(ServicioDominio.class.getName());

	@Autowired
	ManejadorDominio manejadorDominio;

	@Override
	public List<DominioDTO> consultarTiposItem() throws Exception{
		try {
			List<DominioDTO> tiposItem = manejadorDominio.tiposItem();
			return tiposItem;
		}
		catch(Exception e) {
			logger.info(e.getCause() + e.getMessage());
			throw new Exception("No se puede consultar la tabla Dominio");

		}
	}

	@Override
	public List<DominioDTO> consultarTiposMaquila() throws Exception{
		try {
			List<DominioDTO> tiposMaquila = manejadorDominio.tiposMaquila();
			return tiposMaquila;
		}
		catch(Exception e) {
			logger.info(e.getCause() + e.getMessage());
			throw new Exception("No se puede consultar la tabla Dominio");

		}
	}

	@Override
	public List<DominioDTO> consultarDominiosTipo(String tipoDominio) throws Exception {
		try {
			List<DominioDTO> dominiosDTO = manejadorDominio.consultarDominiosTipo(tipoDominio);
			return dominiosDTO;
		}
		catch(Exception e) {
			logger.info(e.getCause() + e.getMessage());
			throw new Exception("No se puede consultar la tabla Dominio");
		}
	}

}
