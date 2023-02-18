package com.bus.chelpaTex.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoEmpleadoDTO;
import com.bus.chelpaTex.DTO.EmpleadoDTO;

@Service
public interface ServicioDisenoEmpleado {
	
	@Qualifier("ServicioDisenoEmpleadoImpl")
	public DisenoEmpleadoDTO crear(DisenoEmpleadoDTO disenoEmpleadoDTO);

	@Qualifier("ServicioDisenoEmpleadoImpl")
	public BigDecimal calcularValorEmpleados(List<EmpleadoDTO> empleados, ActualizarDisenoDTO actualizarDisenoDTO);

}
