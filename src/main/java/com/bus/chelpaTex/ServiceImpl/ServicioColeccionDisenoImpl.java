package com.bus.chelpaTex.ServiceImpl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDisenoDTO;
import com.bus.chelpaTex.Entity.ColeccionDiseno;
import com.bus.chelpaTex.Repo.ManejadorColeccionDiseno;
import com.bus.chelpaTex.Service.ServicioColeccionDiseno;

@Service
public class ServicioColeccionDisenoImpl implements ServicioColeccionDiseno{

	private static final Logger logger =  Logger.getLogger(ServicioColeccionDiseno.class.getName());
	
	@Autowired
	ManejadorColeccionDiseno manejadorColeccionDiseno;

	@Override
	public ColeccionDisenoDTO crear(ColeccionDisenoDTO coleccionDisenoDTO) {
		try {
			ColeccionDiseno coleccionDiseno = new ColeccionDiseno();
			coleccionDiseno.setColeccionDisenoPK(coleccionDisenoDTO.getColeccionDisenoPK());	
			coleccionDiseno.setActivo(true);
			manejadorColeccionDiseno.save(coleccionDiseno);
			return coleccionDisenoDTO;
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	
	}
	
	

	
}
