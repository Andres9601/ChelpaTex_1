package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Service.ServicioMolde;
import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
@Transactional
public class ServicioMoldeImpl implements ServicioMolde {
	
	private static final Logger logger =  Logger.getLogger(ServicioMolde.class.getName());

	@Autowired
	ServiceUtil serviceUtil;

	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Override
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado) throws IllegalAccessException {
		List<MoldeDTO> moldesTemp = manejadorMolde.moldesFiltro( tipoPrenda, tipoModa, objetivo, tipoAcabado);
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (MoldeDTO molde : moldesTemp) {
			moldes.add(molde);			
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
		List<MoldeDTO> moldesTemp = manejadorMolde.moldesFiltro(molder.getTipoPrenda(),
				molder.getTipoModa(), molder.getObjetivo(), molder.getTipoAcabado());
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (MoldeDTO moldeTemp : moldesTemp) {
			moldes.add(moldeTemp);
			
		}
		return moldes;
	}


	@Override
	public MoldeDTO crearDisenoConMolde(MoldeDTO moldeTemp) throws Exception {
		Molde molde = this.crear(moldeTemp);
		moldeTemp.setIdMolde(molde.getIdMolde());
		return moldeTemp;
		
	}


	@Override
	public List<MoldeDTO> consultarMoldesUsuario(String idUsuario) {
		try {
			List<MoldeDTO> moldes = manejadorMolde.consultarMoldesUsuario(idUsuario); 
			return moldes;
		}catch(InvalidParameterException e) {
		logger.info(e.getCause() + e.getMessage());
		throw new InvalidParameterException("No se pueden consultar los moldes , revise parametros");
		}
	}


	@Override
	public MoldeDTO consultarDetallesMolde(Long idMolde) {
		try {
			MoldeDTO molde = manejadorMolde.consultarDetallesMolde(idMolde); 
			return molde;
		}catch(InvalidParameterException e) {
		logger.info(e.getCause() + e.getMessage());
		throw new InvalidParameterException("No se pueden consultar el molde , revise parametros");
		}
	}
		

}
