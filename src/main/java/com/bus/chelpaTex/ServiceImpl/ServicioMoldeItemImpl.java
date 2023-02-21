package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CantidadItemDTO;
import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.Entity.MoldeItem;
import com.bus.chelpaTex.Entity.MoldeItemPK;
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



	@Override
	public List<CantidadItemDTO> crearItemsMolde(List<CantidadItemDTO> itemsMolde) {
		for (CantidadItemDTO itemMolde: itemsMolde) {
			MoldeItem moldeItem = new MoldeItem();
			MoldeItemPK moldeItemPK = new MoldeItemPK();
			moldeItemPK.setIdMolde(itemMolde.getIdMolde());
			moldeItemPK.setIdItem(itemMolde.getIdItem());
			moldeItem.setMoldeItemPK(moldeItemPK);
			moldeItem.setCantidad(itemMolde.getCantidad());
			moldeItem.setActivo(true);
			manejadorMoldeItem.save(moldeItem);
		
		}
		return itemsMolde;
	}
	

}
