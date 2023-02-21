package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
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
import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
public class ServicioMoldeImpl implements ServicioMolde {
	
	private static final Logger logger =  Logger.getLogger(ServicioMolde.class.getName());

	@Autowired
	ServiceUtil serviceUtil;

	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Override
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado) throws IllegalAccessException {
		List<Molde> moldesTemp = manejadorMolde.moldesFiltro( tipoPrenda, tipoModa, objetivo, tipoAcabado);
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (Molde molde : moldesTemp) {
			MoldeDTO moldeDTO = new MoldeDTO();
			serviceUtil.copiarAtributos(molde, moldeDTO);
			moldes.add(moldeDTO);			
		}
	return moldes;
	}


//COMPLETAR
	@Override
	public Molde crear(MoldeDTO moldeDTO) throws  Exception{
		try {
		Molde molde = new Molde();
		serviceUtil.copiarAtributos(moldeDTO, molde);
		molde.setFechaCreacion(new Date());
		molde.setActivo(true);
		manejadorMolde.save(molde);
		return molde;
		}
		catch(InvalidParameterException e){
			logger.info(e.getCause() + e.getMessage());
			throw new InvalidParameterException("No se puede crear el molde, revise parametros");
		}
	}


	@Override
	public List<MoldeDTO> consultarMoldesParametros(MoldeDTO molder) {
		List<Molde> moldesTemp = manejadorMolde.moldesFiltro(molder.getTipoPrenda(),
				molder.getTipoModa(), molder.getObjetivo(), molder.getTipoAcabado());
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (Molde moldeTemp : moldesTemp) {
			MoldeDTO molde = new MoldeDTO();
			molde.setIdMolde(moldeTemp.getIdMolde());
			molde.setNombre(moldeTemp.getNombre());
			molde.setFechaCreacion(moldeTemp.getFechaCreacion());
			molde.setPrecio(moldeTemp.getPrecio());
			molde.setTipoMolde(moldeTemp.getTipoMolde());
			molde.setTipoPrenda(moldeTemp.getTipoPrenda());
			molde.setTipoModa(moldeTemp.getTipoModa());
			molde.setObjetivo(moldeTemp.getObjetivo());
			molde.setTipoAcabado(moldeTemp.getTipoAcabado());
			molde.setAnchoTela(moldeTemp.getAnchoTela());
			molde.setConsumoTotal(moldeTemp.getConsumoTotal());
			molde.setTipoProduccion(moldeTemp.getTipoProduccion());
			molde.setTipoCascada(moldeTemp.getTipoCascada());
			molde.setCaracteristicas(moldeTemp.getCaracteristicas());
			molde.setRutaArchivo(moldeTemp.getRutaArchivo());
			molde.setActivo(moldeTemp.getActivo());
			moldes.add(molde);
			
		}
		return moldes;
	}


	@Override
	public MoldeDTO crearDisenoConMolde(MoldeDTO moldeTemp) throws Exception {
		Molde molde = this.crear(moldeTemp);
		moldeTemp.setIdMolde(molde.getIdMolde());
		return moldeTemp;
		
	}
	
	
	

}
