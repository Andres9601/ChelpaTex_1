package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.Entity.DisenoMaquila;
import com.bus.chelpaTex.Entity.DisenoMaquilaPK;
import com.bus.chelpaTex.Entity.Maquila;
import com.bus.chelpaTex.Repo.ManejadorDisenoMaquila;
import com.bus.chelpaTex.Repo.ManejadorMaquila;
import com.bus.chelpaTex.Service.ServicioDisenoMaquila;

@Service
@Transactional
public class ServicioDisenoMaquilaImpl implements ServicioDisenoMaquila {
	
	//private static final Logger logger =  Logger.getLogger(ServicioDisenoMaquila.class.getName());

	@Autowired
	ManejadorMaquila manejadorMaquila;
	
	@Autowired
	ManejadorDisenoMaquila manejadorDisenoMaquila;
	
	@Override
	public BigDecimal calcularValorMaquilas(List<Long> idMaquilas, ActualizarDisenoDTO actualizarDisenoDTO) {

		BigDecimal valorMaquilas = BigDecimal.valueOf(0);
		for(Long idMaquila : idMaquilas) {
			Maquila maquila = manejadorMaquila.getReferenceById(idMaquila);
			BigDecimal precioUnidad = maquila.getPrecioUnidad();
			valorMaquilas = valorMaquilas.add(precioUnidad);
			
			DisenoMaquila disenoMaquila = new DisenoMaquila();
			DisenoMaquilaPK disenoMaquilaPK = new DisenoMaquilaPK();
			disenoMaquilaPK.setIdDiseno(actualizarDisenoDTO.getIdDiseno());
			disenoMaquilaPK.setIdMaquila(idMaquila);
			disenoMaquila.setDisenoMaquilaPK(disenoMaquilaPK);
			disenoMaquila.setActivo(true);
			manejadorDisenoMaquila.save(disenoMaquila);
		}
		return valorMaquilas;
	}

}
