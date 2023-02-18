package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.DTO.MoldeItemDTO;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Repo.ManejadorMoldeItem;
import com.bus.chelpaTex.Service.ServicioItem;

@Service
public class ServicioItemImpl implements ServicioItem{
	
	//private static final Logger logger =  Logger.getLogger(ServicioItem.class.getName());

	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Autowired
	ManejadorMoldeItem manejadorMoldeItem;
	
	@Override
	public BigDecimal calcularValorTotalUnidades(ActualizarDisenoDTO actualizarDisenoDTO) {
		Molde molde = manejadorMolde.getReferenceById(actualizarDisenoDTO.getIdMolde());
		List<ItemDTO> items = manejadorMoldeItem.ItemsMolde(actualizarDisenoDTO.getIdMolde());
		BigDecimal valorItems = BigDecimal.valueOf(0);
		for(ItemDTO item:items)
		{
			MoldeItemDTO moldeItem = manejadorMoldeItem.cantidadItemMolde(item.getIdItem(), actualizarDisenoDTO.getIdMolde());
			BigDecimal cantidad = moldeItem.getCantidad();
			valorItems= valorItems.add(item.getPrecioUnidad().multiply(cantidad));
		}
		BigDecimal valorTotalUnidades = molde.getPrecio().add(valorItems.multiply(actualizarDisenoDTO.getUnidades()));
		
		return valorTotalUnidades;
	}


}
