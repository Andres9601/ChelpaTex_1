package com.bus.chelpaTex.Service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.EmpleadoDTO;


@Service
public interface ServicioEmpleado {
	
	@Qualifier("ServicioEmpleadoImpl")
	public EmpleadoDTO crear (EmpleadoDTO empleadoDTO) throws InvalidParameterException;

}
