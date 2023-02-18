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
	public MoldeDTO crear(MoldeDTO moldeDTO) throws InvalidParameterException{
		try {
		Molde molde = new Molde();
		molde.setIdUsuario(moldeDTO.getIdUsuario());
		molde.setNombre(moldeDTO.getNombre());
		molde.setFechaCreacion(new Date());
		molde.setActivo(true);
		manejadorMolde.save(molde);
		return moldeDTO;
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
	public MoldeDTO crearDisenoConMolde(MoldeDTO moldeTemp) {
		Molde molde = new Molde();
		molde.setTipoMolde(moldeTemp.getTipoMolde());
		molde.setTipoPrenda(moldeTemp.getTipoPrenda());
		molde.setTipoModa(moldeTemp.getTipoModa());
		molde.setObjetivo(moldeTemp.getObjetivo());
		molde.setTipoAcabado(moldeTemp.getTipoAcabado());
		molde.setNombre(moldeTemp.getNombre());
		molde = manejadorMolde.save(molde);
		moldeTemp.setIdMolde(molde.getIdMolde());
		return moldeTemp;
		
	}
	
	
	

}
