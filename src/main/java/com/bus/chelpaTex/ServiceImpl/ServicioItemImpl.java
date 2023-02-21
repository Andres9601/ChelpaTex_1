package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.DTO.MoldeItemDTO;
import com.bus.chelpaTex.Entity.Item;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorItem;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Repo.ManejadorMoldeItem;
import com.bus.chelpaTex.Service.ServicioItem;
import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
public class ServicioItemImpl implements ServicioItem{
	
	private static final Logger logger =  Logger.getLogger(ServicioItem.class.getName());

	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Autowired
	ManejadorMoldeItem manejadorMoldeItem;
	
	@Autowired
	ManejadorItem manejadorItem;
	
	@Autowired
	ServiceUtil serviceUtil;
	
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

	@Override
	public List<ItemDTO> consultarItemsTipo(String tipoItem) {
		try {
			List<ItemDTO> items = manejadorItem.consultarItemsTipo(tipoItem);
			return items;
		}
		catch(InvalidParameterException e){
			logger.info(e.getCause() + e.getMessage());
			throw new InvalidParameterException("No se pueden consultar los items, revisar parametro");
		}
	}

	@Override
	public ItemDTO crear(ItemDTO itemDTO) throws Exception {
		Item item = new Item();
		try {
		serviceUtil.copiarAtributos(itemDTO, item);
		
		item = manejadorItem.save(item);
		item.setIdTrazabilidad("i-" + item.getIdItem());
		manejadorItem.save(item);
		return itemDTO;
		}
		catch(Exception e) {
		logger.info(e.getMessage());
		throw new Exception("No se puede guardar el item, revise parametros");
		}
		}

	@Override
	public List<ItemDTO> consultarItemsUsuario(String idUsuario) {
		try {
			List<ItemDTO> items = manejadorItem.consultarItemsUsuario(idUsuario);
			return items;
		}
		catch(InvalidParameterException e){
			logger.info(e.getCause() + e.getMessage());
			throw new InvalidParameterException("No se pueden consultar los items, revisar parametro");
		}
	}
		
	


}
