package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.Entity.Empleado;
import com.bus.chelpaTex.Repo.ManejadorEmpleado;
import com.bus.chelpaTex.Service.ServicioEmpleado;

@Service
@Transactional
public class ServicioEmpleadoImpl implements ServicioEmpleado{
	
	private static final Logger logger =  Logger.getLogger(ServicioEmpleado.class.getName());

	
	@Autowired
	ManejadorEmpleado manejadorEmpleado;
	
	@Override
	public EmpleadoDTO crear (EmpleadoDTO empleadoDTO) throws InvalidParameterException{
		try {
		Empleado empleado = new Empleado();
		empleado.setNumeroIdentificacion(empleadoDTO.getNumeroIdentificacion());
		empleado.setNombre(empleadoDTO.getNombre());
		empleado.setSalario(empleadoDTO.getSalario());
		empleado.setCargo(empleadoDTO.getCargo());
		empleado.setTarea(empleadoDTO.getTarea());
		empleado.setProductividad(empleadoDTO.getProductividad());
		empleado.setActivo(true);
		manejadorEmpleado.save(empleado);
		return empleadoDTO;
		}
		catch(InvalidParameterException e){
			logger.info(e.getMessage() + e.getCause());
			throw new InvalidParameterException("No se puede crear el Empleado, revise parametros");
		}
	}

}
