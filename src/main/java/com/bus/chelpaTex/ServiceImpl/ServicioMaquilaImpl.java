package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.Entity.Maquila;
import com.bus.chelpaTex.Repo.ManejadorMaquila;
import com.bus.chelpaTex.Service.ServicioMaquila;

@Service
public class ServicioMaquilaImpl implements ServicioMaquila{
	
	//private static final Logger logger =  Logger.getLogger(ServicioMaquila.class.getName());

	@Autowired
	ManejadorMaquila manejadorMaquila;

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

}
