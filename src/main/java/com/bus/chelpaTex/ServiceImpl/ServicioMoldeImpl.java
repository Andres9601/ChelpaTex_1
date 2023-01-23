package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Service.ServicioMolde;

@Service
public class ServicioMoldeImpl implements ServicioMolde {
	
	private static final Logger logger =  Logger.getLogger(ServicioMolde.class.getName());



	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Override
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado) {
		List<Molde> moldesTemp = manejadorMolde.moldesFiltro( tipoPrenda, tipoModa, objetivo, tipoAcabado);
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (Molde molde : moldesTemp) {
			MoldeDTO moldeDTO = new MoldeDTO();
			moldeDTO.setIdMolde(molde.getIdMolde());
			moldeDTO.setIdUsuario(molde.getIdUsuario());
			moldeDTO.setNombre(molde.getNombre());
			moldeDTO.setFechaCreacion(molde.getFechaCreacion());
			moldeDTO.setPrecio(molde.getPrecio());
			moldeDTO.setTipoMolde(molde.getTipoMolde());
			moldeDTO.setTipoPrenda(molde.getTipoPrenda());
			moldeDTO.setTipoModa(molde.getTipoModa());
			moldeDTO.setObjetivo(molde.getObjetivo());
			moldeDTO.setTipoAcabado(molde.getTipoAcabado());
			moldeDTO.setAnchoTela(molde.getAnchoTela());
			moldeDTO.setConsumoTotal(molde.getConsumoTotal());
			moldeDTO.setTipoProduccion(molde.getTipoProduccion());
			moldeDTO.setTipoCascada(molde.getTipoCascada());
			moldeDTO.setCaracteristicas(molde.getCaracteristicas());
			moldeDTO.setRutaArchivo(molde.getRutaArchivo());
			moldeDTO.setActivo(molde.getActivo());
			moldes.add(moldeDTO);			
		}
	return moldes;
	}


//COMPLETAR
	@Override
	public MoldeDTO crear(MoldeDTO moldeDTO) {
		try {
		Molde molde = new Molde();
		molde.setIdUsuario(moldeDTO.getIdUsuario());
		molde.setNombre(moldeDTO.getNombre());
		molde.setFechaCreacion(new Date());
		molde.setActivo(true);
		manejadorMolde.save(molde);
		return moldeDTO;
		}
		catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	}

}
