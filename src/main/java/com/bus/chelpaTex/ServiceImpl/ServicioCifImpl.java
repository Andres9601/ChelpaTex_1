package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CifDTO;
import com.bus.chelpaTex.Entity.Cif;
import com.bus.chelpaTex.Repo.ManejadorCif;
import com.bus.chelpaTex.Service.ServicioCif;

@Service
public class ServicioCifImpl implements ServicioCif{
	
	private static final Logger logger =  Logger.getLogger(ServicioCif.class.getName());


	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	ManejadorCif manejadorCif;
	
	@Override
	public CifDTO crear(CifDTO cifDTO) {
		try {
			Cif cif = modelMapper.map(cifDTO, Cif.class);
			cif.setActivo(true);
			manejadorCif.save(cif);
			return cifDTO;
			}
			catch(Exception e){
				logger.info(e.getMessage() + e.getCause());
				throw new InvalidParameterException("No se pudo crear el cif, revise parametros");
			}
		}
	

}
