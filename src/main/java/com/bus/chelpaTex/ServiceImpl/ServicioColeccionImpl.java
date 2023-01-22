package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ColeccionCompletaDTO;
import com.bus.chelpaTex.DTO.ColeccionDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.DisenosColeccionDTO;
import com.bus.chelpaTex.DTO.MisColeccionesDTO;
import com.bus.chelpaTex.Entity.Coleccion;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorColeccion;
import com.bus.chelpaTex.Repo.ManejadorColeccionDiseno;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Service.ServicioColeccion;

@Service
public class ServicioColeccionImpl implements ServicioColeccion {
	
	private static final Logger logger =  Logger.getLogger(ServicioColeccion.class.getName());



	@Autowired
	ManejadorColeccion manejadorColeccion;
	
	@Autowired
	ManejadorColeccionDiseno manejadorColeccionDiseno;
	
	@Autowired
	ManejadorMolde manejadorMolde;
	
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
		Coleccion coleccion = new Coleccion();
		coleccion.setIdUsuario(coleccionDTO.getIdUsuario());
		coleccion.setNombre(coleccionDTO.getNombre());
		coleccion.setFechaCreacion(new Date());
		coleccion.setActivo(true);
		manejadorColeccion.save(coleccion);
		return coleccionDTO;
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


	@Override
	public List<MisColeccionesDTO> consultarColeccionesUsuario(String idUsuario) {
		List<MisColeccionesDTO> colecciones = new ArrayList<MisColeccionesDTO>();
		List<ColeccionDTO> coleccionesTemp = this.consultar(idUsuario);
		for (ColeccionDTO coleccion : coleccionesTemp) {
			MisColeccionesDTO coleccionTemp = new MisColeccionesDTO(); 
			coleccionTemp.setIdColeccion(coleccion.getIdColeccion());
			coleccionTemp.setIdUsuario(coleccion.getIdUsuario());
			coleccionTemp.setNombre(coleccion.getNombre());
			coleccionTemp.setFechaCreacion(coleccion.getFechaCreacion());
			coleccionTemp.setActivo(coleccion.getActivo());
			Long numeroDisenos = manejadorColeccionDiseno.count();
			coleccionTemp.setNumeroDisenos(numeroDisenos);
			colecciones.add(coleccionTemp);
		}
		
		return colecciones;
	}


	@Override
	public ColeccionDTO nuevaColeccion(ColeccionDTO coleccionDTO) throws Exception {
		if(!coleccionDTO.getNombre().isEmpty()) {
		this.crear(coleccionDTO);}
		else {
			new Exception("Falta el nombre");
		}
		return coleccionDTO;
	}


	@Override
	public ColeccionCompletaDTO consultarColeccionCompleta(ColeccionDTO coleccionDTO) {
		Coleccion coleccion = manejadorColeccion.getReferenceById(coleccionDTO.getIdColeccion());
		ColeccionCompletaDTO coleccionCompleta = new ColeccionCompletaDTO();
		coleccionCompleta.setNombre(coleccion.getNombre());
		ColeccionDisenoPK coleccionDisenoPK = new ColeccionDisenoPK();
		coleccionDisenoPK.setIdColeccion(coleccionDTO.getIdColeccion());
		Long CostoColeccion = 0L;
		List<DisenosColeccionDTO> disenosColeccion = new ArrayList<DisenosColeccionDTO>();
		List<DisenoDTO> disenos = manejadorColeccionDiseno.disenosColeccion(coleccionDTO.getIdColeccion());
		for (DisenoDTO disenoDTO : disenos) {
			DisenosColeccionDTO disenosColeccionTemp = new DisenosColeccionDTO();
			CostoColeccion += disenoDTO.getTotalEstimado();
			disenosColeccionTemp.setIdDiseno(disenoDTO.getIdDiseno());
			disenosColeccionTemp.setNombre(disenoDTO.getNombre());
			Molde molde = manejadorMolde.getReferenceById(disenoDTO.getIdMolde());
			disenosColeccionTemp.setNombreMolde(molde.getNombre());			
			disenosColeccionTemp.setCostoDiseno(disenoDTO.getTotalEstimado());
			disenosColeccionTemp.setUnidades(disenoDTO.getUnidades());
			
			disenosColeccion.add(disenosColeccionTemp);
			
		}
		coleccionCompleta.setDisenos(disenosColeccion);
		return coleccionCompleta;
	}
}
