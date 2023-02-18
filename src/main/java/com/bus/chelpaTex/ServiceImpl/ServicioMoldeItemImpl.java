package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Repo.ManejadorMoldeItem;
import com.bus.chelpaTex.Service.ServicioMoldeItem;

@Service
public class ServicioMoldeItemImpl implements ServicioMoldeItem{
	
	//private static final Logger logger =  Logger.getLogger(ServicioMoldeItem.class.getName());



	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Autowired
	ManejadorMoldeItem manejadorMoldeItem;



	@Override
	public List<ItemDTO> consultarItemsMolde (Long idMolde) {
		if(!idMolde.equals(null)) {
		List<ItemDTO>  itemsDTO = manejadorMoldeItem.ItemsMolde(idMolde);
		return itemsDTO;
		}
		else {
			throw new InvalidParameterException("idMolde incorrecto");
		}
	}
	

}
