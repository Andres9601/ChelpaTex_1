package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.CantidadItemDTO;
import com.bus.chelpaTex.DTO.ItemDTO;

@Service
public interface ServicioMoldeItem {

	@Qualifier("ServicioMoldeItemImpl")
	public List<ItemDTO> consultarItemsMolde(Long idMolde);
	
	@Qualifier("ServicioMoldeItemImpl")
	public List<CantidadItemDTO> crearItemsMolde(List<CantidadItemDTO> itemsMolde);
	
	
}
