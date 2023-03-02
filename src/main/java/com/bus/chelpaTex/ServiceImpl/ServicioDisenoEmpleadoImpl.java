package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoEmpleadoDTO;
import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.Entity.DisenoEmpleado;
import com.bus.chelpaTex.Entity.DisenoEmpleadoPK;
import com.bus.chelpaTex.Entity.Empleado;
import com.bus.chelpaTex.Repo.ManejadorDisenoEmpleado;
import com.bus.chelpaTex.Repo.ManejadorEmpleado;
import com.bus.chelpaTex.Service.ServicioDisenoEmpleado;

@Service
public class ServicioDisenoEmpleadoImpl implements ServicioDisenoEmpleado{

	private static final Logger logger =  Logger.getLogger(ServicioDisenoEmpleado.class.getName());
	
	@Autowired
	ManejadorDisenoEmpleado manejadorDisenoEmpleado;
	
	@Autowired
	ManejadorEmpleado manejadorEmpleado;
	
	
	
	@Override
	public DisenoEmpleadoDTO crear(DisenoEmpleadoDTO disenoEmpleadoDTO) {
		try {
			DisenoEmpleado disenoEmpleado = new DisenoEmpleado();
			disenoEmpleado.setDisenoEmpleadoPK(disenoEmpleadoDTO.getDisenoEmpleadoPK());	
			disenoEmpleado.setActivo(true);
			manejadorDisenoEmpleado.save(disenoEmpleado);
			return disenoEmpleadoDTO;
		}catch(InvalidParameterException e){
			logger.info(e.getMessage() + e.getCause());
			throw new InvalidParameterException("no se puede crear disenoEmpleado, revisar parametros");
		}
	}


	@Override
	public BigDecimal calcularValorEmpleados(List<EmpleadoDTO> empleados, ActualizarDisenoDTO actualizarDisenoDTO) {
		BigDecimal valorEmpleados = BigDecimal.valueOf(0);
		for(EmpleadoDTO empleado: empleados) {
			BigDecimal salario = empleado.getSalario();
			BigDecimal productividad = empleado.getProductividad();
			valorEmpleados = valorEmpleados.add(salario.divide(productividad,0, RoundingMode.HALF_UP));
			
			Empleado empleadoTemp = new  Empleado();
			empleadoTemp.setNumeroIdentificacion(empleado.getNumeroIdentificacion());
			empleadoTemp.setNombre(empleado.getNombre());
			empleadoTemp.setSalario(salario);
			empleadoTemp.setCargo(empleado.getCargo());
			empleadoTemp.setTarea(empleado.getTarea());
			empleadoTemp.setProductividad(productividad);
			empleadoTemp.setActivo(true);
			manejadorEmpleado.save(empleadoTemp);
			
			DisenoEmpleado disenoEmpleado = new DisenoEmpleado();
			DisenoEmpleadoPK disenoEmpleadoPK = new DisenoEmpleadoPK();
			disenoEmpleadoPK.setIdDiseno(actualizarDisenoDTO.getIdDiseno());
			disenoEmpleadoPK.setNumeroIdentificacion(empleado.getNumeroIdentificacion());
			disenoEmpleado.setDisenoEmpleadoPK(disenoEmpleadoPK);
			disenoEmpleado.setActivo(true);
			manejadorDisenoEmpleado.save(disenoEmpleado);
			}
		return valorEmpleados;
	}

}
