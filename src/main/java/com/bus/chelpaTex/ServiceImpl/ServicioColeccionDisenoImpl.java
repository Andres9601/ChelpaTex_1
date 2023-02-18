package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.Entity.ColeccionDiseno;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;
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
			coleccionDisenoDTO.setActivo(coleccionDiseno.getActivo());
			return coleccionDisenoDTO;
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			throw new InvalidParameterException("Parametros invalidos");
		}
	
	}

	@Override
	public ColeccionDisenoDTO crearColeccionDiseno(NuevoDisenoDTO nuevoDisenoDTO, DisenoDTO disenor) {
		ColeccionDisenoDTO coleccionDisenoDTO = new ColeccionDisenoDTO();
		ColeccionDisenoPK coleccionDisenoPK = new ColeccionDisenoPK();
		coleccionDisenoPK.setIdColeccion(nuevoDisenoDTO.getIdColeccion());
		coleccionDisenoPK.setIdDiseno(disenor.getIdDiseno());
		coleccionDisenoDTO.setColeccionDisenoPK(coleccionDisenoPK);
		this.crear(coleccionDisenoDTO);
		return coleccionDisenoDTO;
	}
	
	

	
}
