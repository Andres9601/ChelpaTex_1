package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionDTO;
import com.bus.chelpaTex.Entity.Coleccion;
import com.bus.chelpaTex.Repo.ManejadorColeccion;
import com.bus.chelpaTex.Service.ServicioColeccion;
import com.bus.chelpaTex.Service.ServicioUsuario;

@Service
public class ServicioColeccionImpl implements ServicioColeccion {
	
	private static final Logger logger =  Logger.getLogger(ServicioUsuario.class.getName());



	@Autowired
	ManejadorColeccion manejadorColeccion;
	
	@Override
	public List<ColeccionDTO> consultar(String idUsuario) {
		List<Coleccion> coleccionesTemp = manejadorColeccion.coleccionesUsuario(idUsuario);
		List<ColeccionDTO> colecciones = new ArrayList<ColeccionDTO>();
		for (Coleccion coleccion : coleccionesTemp) {
			ColeccionDTO coleccionDto = new ColeccionDTO();
			coleccionDto.setIdColeccion(coleccion.getIdColeccion());
			coleccionDto.setIdUsuario(coleccion.getIdUsuario());
			coleccionDto.setNombre(coleccion.getNombre());
			coleccionDto.setFechaCreacion(coleccion.getFechaCreacion());
			coleccionDto.setActivo(coleccion.getActivo());
			colecciones.add(coleccionDto);
		}
	return colecciones;
	}


	@Override
	public ColeccionDTO crear(ColeccionDTO coleccionDTO) {
		try {
		Coleccion coleccion = new Coleccion();
		coleccion.setIdUsuario(coleccionDTO.getIdUsuario());
		coleccion.setNombre(coleccionDTO.getNombre());
		coleccion.setFechaCreacion(new Date());
		coleccion.setActivo(true);
		manejadorColeccion.save(coleccion);
		return coleccionDTO;
		}
		catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
	}


	@Override
	public String eliminar(Long idColeccion) {
	
		Optional<Coleccion> coleccionesTemp = manejadorColeccion.findById(idColeccion);
	try {
		 manejadorColeccion.deleteById(coleccionesTemp.get().getIdColeccion());
		 return "Coleccion eliminada correctamente";
	}
	catch(Exception e){
		logger.info(e.getMessage() + e.getCause());
		return "No se elimino correctamente la Coleccion";
	}
	
}
}
