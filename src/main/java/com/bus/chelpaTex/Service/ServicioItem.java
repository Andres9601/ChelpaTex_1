package com.bus.chelpaTex.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;

@Service
public interface ServicioItem {

	@Qualifier("ServicioItemImpl")
	BigDecimal calcularValorTotalUnidades(ActualizarDisenoDTO actualizarDisenoDTO);

}
