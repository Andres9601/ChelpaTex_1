package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.Entity.Maquila;
import com.bus.chelpaTex.Repo.ManejadorMaquila;
import com.bus.chelpaTex.Service.ServicioMaquila;
import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
@Transactional
public class ServicioMaquilaImpl implements ServicioMaquila{
	
	private static final Logger logger =  Logger.getLogger(ServicioMaquila.class.getName());

	@Autowired
	ManejadorMaquila manejadorMaquila;
	
	@Autowired
	ServiceUtil serviceUtil;

	@Override
	public List<MaquilaDTO> consultar() {
		List<Maquila> maquilas = manejadorMaquila.findAll();
		List<MaquilaDTO> maquilasDTO = new ArrayList<MaquilaDTO>();
		for(Maquila maquila : maquilas) {
		MaquilaDTO maquilaDTO = new MaquilaDTO();
		maquilaDTO.setIdMaquila(maquila.getIdMaquila());
		maquilaDTO.setTipoMaquila(maquila.getTipoMaquila());
		maquilaDTO.setPrecioUnidad(maquila.getPrecioUnidad());
		maquilaDTO.setActivo(maquila.getActivo());
		maquilasDTO.add(maquilaDTO);
		}
		return maquilasDTO;
	}

	
	@Override
	public List<MaquilaDTO> consultarMaquilasTipo(String tipoMaquila) {
		try {
			List<MaquilaDTO> maquilas = manejadorMaquila.consultarMaquilasTipo(tipoMaquila);
			return maquilas;
		}
		catch(InvalidParameterException e){
			logger.info(e.getCause() + e.getMessage());
			throw new InvalidParameterException("No se pueden consultar las maquilas, revisar parametro");
		}
	}
	
	
	@Override
	public MaquilaDTO crear(MaquilaDTO maquilaDTO) throws Exception {
		Maquila maquila = new Maquila();
		try {
			serviceUtil.copiarAtributos(maquilaDTO, maquila);
			manejadorMaquila.save(maquila);
			return maquilaDTO;
		}catch(Exception e) {
			logger.info(e.getMessage());
		throw new Exception("No se puede guardar la maquila, revise parametros");
		}
	}

}
