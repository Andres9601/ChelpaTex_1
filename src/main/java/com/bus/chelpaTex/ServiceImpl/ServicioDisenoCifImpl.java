package com.bus.chelpaTex.ServiceImpl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoCifDTO;
import com.bus.chelpaTex.Entity.DisenoCif;
import com.bus.chelpaTex.Repo.ManejadorDisenoCif;
import com.bus.chelpaTex.Service.ServicioDisenoCif;

@Service
public class ServicioDisenoCifImpl implements ServicioDisenoCif{
	
	private static final Logger logger =  Logger.getLogger(ServicioDisenoCif.class.getName());

	
	@Autowired
	ManejadorDisenoCif manejadorDisenoCif;
	
	@Override
	public DisenoCifDTO crear(DisenoCifDTO disenoCifDTO) {
		try {
			DisenoCif disenoCif = new DisenoCif();
			disenoCif.setDisenoCifPK(disenoCifDTO.getDisenoCifPK());	
			disenoCif.setActivo(true);
			manejadorDisenoCif.save(disenoCif);
			return disenoCifDTO;
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	}

}
