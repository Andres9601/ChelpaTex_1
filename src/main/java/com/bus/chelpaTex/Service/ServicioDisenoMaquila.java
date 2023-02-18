package com.bus.chelpaTex.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;

@Service
public interface ServicioDisenoMaquila {

	@Qualifier("ServicioDisenoMaquilaImpl")
	BigDecimal calcularValorMaquilas(List<Long> idMaquilas, ActualizarDisenoDTO actualizarDisenoDTO);

}
