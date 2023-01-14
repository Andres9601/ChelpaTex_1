package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.Entity.Diseno;
import com.bus.chelpaTex.Repo.ManejadorDiseno;
import com.bus.chelpaTex.Service.ServicioDiseno;

@Service
public class ServicioDisenoImpl implements ServicioDiseno{

	private static final Logger logger =  Logger.getLogger(ServicioDiseno.class.getName());

	
	@Autowired
	ManejadorDiseno manejadorDiseno;
	
	@Override
	public List<DisenoDTO> consultar(String idUsuario) {
		List<Diseno> disenosTemp = manejadorDiseno.disenosUsuario(idUsuario);
		List<DisenoDTO> disenos = new ArrayList<DisenoDTO>();
		for (Diseno diseno : disenosTemp) {
			DisenoDTO disenoDTO = new DisenoDTO();
			disenoDTO.setIdDiseno(diseno.getIdDiseno());
			disenoDTO.setIdUsuario(diseno.getIdUsuario());
			disenoDTO.setNombre(diseno.getNombre());
			disenoDTO.setFechaCreacion(diseno.getFechaCreacion());
			disenoDTO.setIdMolde(diseno.getIdMolde());
			disenoDTO.setIdTrazabilidad(diseno.getIdTrazabilidad());
			disenoDTO.setUnidades(diseno.getUnidades());
			disenoDTO.setValorTotalUnidades(diseno.getValorTotalUnidades());
			disenoDTO.setValorTotalEmpleados(diseno.getValorTotalEmpleados());
			disenoDTO.setValorTotalMaquila(diseno.getValorTotalMaquila());
			disenoDTO.setValorTotalCif(diseno.getValorTotalCif());
			disenoDTO.setMargenGanancia(diseno.getMargenGanancia());
			disenoDTO.setTotalEstimado(diseno.getTotalEstimado());
			disenoDTO.setPrecioSugeridoVenta(diseno.getPrecioSugeridoVenta());
			disenoDTO.setActivo(diseno.getActivo());
			disenos.add(disenoDTO);
		}
	return disenos;
	}

	@Override
	public DisenoDTO crear(DisenoDTO disenoDTO) {
		try {
			Diseno diseno = new Diseno();
			diseno.setIdUsuario(disenoDTO.getIdUsuario());
			diseno.setNombre(disenoDTO.getNombre());
			diseno.setFechaCreacion(new Date());
			diseno.setIdMolde(disenoDTO.getIdMolde());
			diseno.setIdTrazabilidad(disenoDTO.getIdTrazabilidad());
			diseno.setUnidades(disenoDTO.getUnidades());
			diseno.setValorTotalUnidades(disenoDTO.getValorTotalUnidades());
			diseno.setValorTotalEmpleados(disenoDTO.getValorTotalEmpleados());
			diseno.setValorTotalMaquila(disenoDTO.getValorTotalMaquila());
			diseno.setValorTotalCif(disenoDTO.getValorTotalCif());
			diseno.setMargenGanancia(disenoDTO.getMargenGanancia());
			diseno.setTotalEstimado(disenoDTO.getTotalEstimado());
			diseno.setPrecioSugeridoVenta(disenoDTO.getPrecioSugeridoVenta());
			diseno.setActivo(true);
			manejadorDiseno.save(diseno);
			return disenoDTO;
			}
			catch(Exception e){
				logger.info(e.getMessage() + e.getCause());
				return null;
			}
		}

}
