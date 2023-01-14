package com.bus.chelpaTex.ServiceImpl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoEmpleadoDTO;
import com.bus.chelpaTex.Entity.DisenoEmpleado;
import com.bus.chelpaTex.Repo.ManejadorDisenoEmpleado;
import com.bus.chelpaTex.Service.ServicioDisenoEmpleado;

@Service
public class ServicioDisenoEmpleadoImpl implements ServicioDisenoEmpleado{

	private static final Logger logger =  Logger.getLogger(ServicioDisenoEmpleado.class.getName());
	
	@Autowired
	ManejadorDisenoEmpleado manejadorDisenoEmpleado;
	
	
	@Override
	public DisenoEmpleadoDTO crear(DisenoEmpleadoDTO disenoEmpleadoDTO) {
		try {
			DisenoEmpleado disenoEmpleado = new DisenoEmpleado();
			disenoEmpleado.setDisenoEmpleadoPK(disenoEmpleadoDTO.getDisenoEmpleadoPK());	
			disenoEmpleado.setActivo(true);
			manejadorDisenoEmpleado.save(disenoEmpleado);
			return disenoEmpleadoDTO;
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	}

}
