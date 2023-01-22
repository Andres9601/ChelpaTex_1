package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoRespuesta;
import com.bus.chelpaTex.Entity.Diseno;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorDiseno;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Service.ServicioDiseno;

@Service
public class ServicioDisenoImpl implements ServicioDiseno{

	private static final Logger logger =  Logger.getLogger(ServicioDiseno.class.getName());

	
	@Autowired
	ManejadorDiseno manejadorDiseno;
	
	@Autowired
	ManejadorMolde manejadorMolde;
	
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
			diseno = manejadorDiseno.save(diseno);
			disenoDTO.setIdDiseno(diseno.getIdDiseno());
			return disenoDTO;
			}
			catch(Exception e){
				logger.info(e.getMessage() + e.getCause());
				return null;
			}
		}

	@Override
	public NuevoDisenoRespuesta nuevoDiseno(NuevoDisenoDTO nuevoDisenoDTO) {
		DisenoDTO diseno = new DisenoDTO();
		diseno.setNombre(nuevoDisenoDTO.getNombre());
		diseno.setIdUsuario(nuevoDisenoDTO.getIdUsuario());
		DisenoDTO disenor = new DisenoDTO();
		disenor = this.crear(diseno);
		NuevoDisenoRespuesta respuesta = new NuevoDisenoRespuesta();
		respuesta.setIdDiseno(disenor.getIdDiseno());
		respuesta.setNombre(disenor.getNombre());
		List<Molde> moldesTemp = manejadorMolde.moldesFiltro(nuevoDisenoDTO.getTipoPrenda(),
				nuevoDisenoDTO.getTipoModa(), nuevoDisenoDTO.getObjetivo(), nuevoDisenoDTO.getTipoAcabado());
		List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
		for (Molde moldeTemp : moldesTemp) {
			MoldeDTO molde = new MoldeDTO();
			molde.setIdMolde(moldeTemp.getIdMolde());
			molde.setNombre(moldeTemp.getNombre());
			molde.setFechaCreacion(moldeTemp.getFechaCreacion());
			molde.setPrecio(moldeTemp.getPrecio());
			molde.setTipoMolde(moldeTemp.getTipoMolde());
			molde.setTipoPrenda(moldeTemp.getTipoPrenda());
			molde.setTipoModa(moldeTemp.getTipoModa());
			molde.setObjetivo(moldeTemp.getObjetivo());
			molde.setTipoAcabado(moldeTemp.getTipoAcabado());
			molde.setAnchoTela(moldeTemp.getAnchoTela());
			molde.setConsumoTotal(moldeTemp.getConsumoTotal());
			molde.setTipoProduccion(moldeTemp.getTipoProduccion());
			molde.setTipoCascada(moldeTemp.getTipoCascada());
			molde.setCaracteristicas(moldeTemp.getCaracteristicas());
			molde.setRutaArchivo(moldeTemp.getRutaArchivo());
			molde.setActivo(moldeTemp.getActivo());
			moldes.add(molde);
			
		}
		respuesta.setMoldes(moldes);
		
		return respuesta;
	}

}
