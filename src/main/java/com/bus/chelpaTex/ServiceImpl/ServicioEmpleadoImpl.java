package com.bus.chelpaTex.ServiceImpl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.Entity.Empleado;
import com.bus.chelpaTex.Repo.ManejadorEmpleado;
import com.bus.chelpaTex.Service.ServicioEmpleado;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado{
	
	private static final Logger logger =  Logger.getLogger(ServicioEmpleado.class.getName());

	
	@Autowired
	ManejadorEmpleado manejadorEmpleado;
	
	@Override
	public EmpleadoDTO crear (EmpleadoDTO empleadoDTO) {
		try {
		Empleado empleado = new Empleado();
		empleado.setNumeroIdentificacion(empleadoDTO.getNumeroIdentificacion());
		empleado.setNombre(empleadoDTO.getNombre());
		empleado.setSalario(empleadoDTO.getSalario());
		empleado.setCargo(empleadoDTO.getCargo());
		empleado.setProductividad(empleadoDTO.getProductividad());
		empleado.setActivo(true);
		manejadorEmpleado.save(empleado);
		return empleadoDTO;
		}
		catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	}

}
