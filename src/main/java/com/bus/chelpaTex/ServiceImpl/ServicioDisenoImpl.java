package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.CifDTO;
import com.bus.chelpaTex.DTO.ColeccionDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.DTO.GastoCifDTO;
import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoRespuesta;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;
import com.bus.chelpaTex.Entity.Diseno;
import com.bus.chelpaTex.Entity.DisenoCifPK;
import com.bus.chelpaTex.Entity.DisenoEmpleadoPK;
import com.bus.chelpaTex.Entity.DisenoMaquilaPK;
import com.bus.chelpaTex.Repo.ManejadorCif;
import com.bus.chelpaTex.Repo.ManejadorColeccionDiseno;
import com.bus.chelpaTex.Repo.ManejadorDiseno;
import com.bus.chelpaTex.Repo.ManejadorDisenoCif;
import com.bus.chelpaTex.Repo.ManejadorDisenoEmpleado;
import com.bus.chelpaTex.Repo.ManejadorDisenoMaquila;
import com.bus.chelpaTex.Repo.ManejadorEmpleado;
import com.bus.chelpaTex.Repo.ManejadorMaquila;
import com.bus.chelpaTex.Service.ServicioColeccionDiseno;
import com.bus.chelpaTex.Service.ServicioDiseno;
import com.bus.chelpaTex.Service.ServicioDisenoCif;
import com.bus.chelpaTex.Service.ServicioDisenoEmpleado;
import com.bus.chelpaTex.Service.ServicioDisenoMaquila;
import com.bus.chelpaTex.Service.ServicioItem;
import com.bus.chelpaTex.Service.ServicioMolde;

@Service
public class ServicioDisenoImpl implements ServicioDiseno{

	private static final Logger logger =  Logger.getLogger(ServicioDiseno.class.getName());

	
	@Autowired
	ManejadorDiseno manejadorDiseno;
	
	@Autowired
	ServicioMolde servicioMolde;
	
	@Autowired
	ServicioColeccionDiseno servicioColeccionDiseno;
	
	@Autowired
	ManejadorEmpleado manejadorEmpleado;
	
	@Autowired
	ManejadorDisenoEmpleado manejadorDisenoEmpleado;
	
	@Autowired
	ManejadorMaquila manejadorMaquila;
	
	@Autowired
	ManejadorDisenoMaquila manejadorDisenoMaquila;
	
	@Autowired
	ManejadorCif manejadorCif;
	
	@Autowired
	ManejadorDisenoCif manejadorDisenoCif;
	
	@Autowired 
	ManejadorColeccionDiseno manejadorColeccionDiseno;
	
	@Autowired
	ServicioItem servicioItem;
	
	@Autowired
	ServicioDisenoEmpleado servicioDisenoEmpleado;
	
	@Autowired
	ServicioDisenoMaquila servicioDisenoMaquila;
	
	@Autowired
	ServicioDisenoCif servicioDisenoCif;
	
	
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
	public DisenoDTO crear(DisenoDTO disenoDTO) throws InvalidParameterException{
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
			catch(InvalidParameterException e){
				logger.info(e.getMessage() + e.getCause());
				throw new InvalidParameterException("No se pudo crear el diseño, revise parametros");
			}
		}

	@Override
	public NuevoDisenoRespuesta nuevoDiseno(NuevoDisenoDTO nuevoDisenoDTO) throws Exception{
		try {
		DisenoDTO diseno = new DisenoDTO();
		diseno.setNombre(nuevoDisenoDTO.getNombre());
		diseno.setIdUsuario(nuevoDisenoDTO.getIdUsuario());
		diseno.setTotalEstimado(BigDecimal.valueOf(0));
		diseno.setIdMolde(1L);
		DisenoDTO disenor = new DisenoDTO();
		disenor = this.crear(diseno);
		NuevoDisenoRespuesta respuesta = new NuevoDisenoRespuesta();
		respuesta.setIdDiseno(disenor.getIdDiseno());
		respuesta.setNombre(disenor.getNombre());
		MoldeDTO molde = nuevoDisenoDTO.getMolde();
		
		if(!molde.getTipoMolde().equals("PROPIO")) {
		List<MoldeDTO> moldes = servicioMolde.consultarMoldesParametros(molde);
	
		respuesta.setMoldes(moldes);
		}
		else
		{
			List<MoldeDTO> moldes = new ArrayList<MoldeDTO>();
			molde.setIdUsuario(nuevoDisenoDTO.getIdUsuario());
			MoldeDTO moldeDTO = servicioMolde.crearDisenoConMolde(molde);
			moldes.add(moldeDTO);
			List<MoldeDTO> moldesItems = servicioMolde.consultarMoldesParametros(molde);
			moldes.addAll(moldesItems);
			respuesta.setMoldes(moldes);
		}
		servicioColeccionDiseno.crearColeccionDiseno(nuevoDisenoDTO, disenor);
		
		return respuesta;
		}
		catch(Exception e) {
			logger.info(e.getMessage() +e.getCause());
			throw new Exception("No se pudo crear el Diseno");
		}
	}

	
	
	@Override
	public DisenoDTO actualizarDiseno (ActualizarDisenoDTO actualizarDisenoDTO) {
		DisenoDTO disenoDTO = new DisenoDTO();
		disenoDTO.setIdDiseno(actualizarDisenoDTO.getIdDiseno());
		disenoDTO.setIdUsuario(actualizarDisenoDTO.getIdUsuario());
		disenoDTO.setNombre(actualizarDisenoDTO.getNombre());
		disenoDTO.setIdMolde(actualizarDisenoDTO.getIdMolde());
		disenoDTO.setIdTrazabilidad("d-" + actualizarDisenoDTO.getIdDiseno());
		disenoDTO.setUnidades(actualizarDisenoDTO.getUnidades());
		
		BigDecimal valorTotalUnidades = servicioItem.calcularValorTotalUnidades(actualizarDisenoDTO);
		
		disenoDTO.setValorTotalUnidades(valorTotalUnidades);

		List<EmpleadoDTO> empleados = actualizarDisenoDTO.getEmpleados();
		
		BigDecimal valorEmpleados = servicioDisenoEmpleado.calcularValorEmpleados(empleados, actualizarDisenoDTO);
		BigDecimal valorTolalEmpleados= valorEmpleados.multiply(actualizarDisenoDTO.getUnidades());
		disenoDTO.setValorTotalEmpleados(valorTolalEmpleados);
		
		List<Long> idMaquilas = actualizarDisenoDTO.getIdsMaquilas();
		BigDecimal valorMaquilas = servicioDisenoMaquila.calcularValorMaquilas(idMaquilas,actualizarDisenoDTO);
		
		BigDecimal valorTotalMaquilas = valorMaquilas.multiply(actualizarDisenoDTO.getUnidades());
		disenoDTO.setValorTotalMaquila(valorTotalMaquilas);
		
		List<CifDTO> cifs = actualizarDisenoDTO.getCifs();
		GastoCifDTO gastosCifDTO = servicioDisenoCif.calcularValorCifs(cifs,actualizarDisenoDTO);
		BigDecimal valorGastos = gastosCifDTO.getValorGastos();
		BigDecimal valorCifs = gastosCifDTO.getValorCifs();		
		
		BigDecimal valorTotalGastos = valorGastos.multiply(actualizarDisenoDTO.getUnidades());
		disenoDTO.setValorTotalGastos(valorTotalGastos);
		
		BigDecimal valorTotalCifs = valorCifs.multiply(actualizarDisenoDTO.getUnidades());
		disenoDTO.setValorTotalCif(valorTotalCifs);
		
		
		BigDecimal totalEstimado = valorTotalUnidades.add(valorTolalEmpleados).add(valorTotalMaquilas).add(valorTotalGastos);
		disenoDTO.setTotalEstimado(totalEstimado);
		disenoDTO.setActivo(actualizarDisenoDTO.getActivo());
		
		Diseno diseno = manejadorDiseno.getReferenceById(actualizarDisenoDTO.getIdDiseno());
		disenoDTO.setFechaCreacion(diseno.getFechaCreacion());
		
		diseno.setNombre(disenoDTO.getNombre());
		diseno.setIdMolde(disenoDTO.getIdMolde());
		diseno.setIdTrazabilidad(disenoDTO.getIdTrazabilidad());
		diseno.setUnidades(disenoDTO.getUnidades());
		diseno.setValorTotalUnidades(disenoDTO.getValorTotalUnidades());
		diseno.setValorTotalEmpleados(disenoDTO.getValorTotalUnidades());
		diseno.setValorTotalMaquila(disenoDTO.getValorTotalMaquila());
		diseno.setValorTotalCif(disenoDTO.getValorTotalCif());
		diseno.setTotalEstimado(disenoDTO.getTotalEstimado());
		diseno.setActivo(disenoDTO.getActivo());

		manejadorDiseno.save(diseno);
		return disenoDTO;
	}

	@Override
	public DisenoDTO actualizarDisenoMg(DisenoDTO disenoDTO) throws InvalidParameterException {
		Diseno diseno = manejadorDiseno.getReferenceById(disenoDTO.getIdDiseno());
		BigDecimal margenGanancia = disenoDTO.getMargenGanancia();
		BigDecimal totalEstimado = diseno.getTotalEstimado();
		BigDecimal unidades = diseno.getUnidades();
		if(!disenoDTO.getMargenGanancia().equals(BigDecimal.valueOf(100))) {
		BigDecimal uno = BigDecimal.valueOf(1);
		BigDecimal precioSugeridoVentaTemp1 = (totalEstimado.divide(unidades,0, RoundingMode.HALF_UP));
		BigDecimal precioSugeridoVentaTemp3	= margenGanancia.divide(BigDecimal.valueOf(100),4, RoundingMode.HALF_UP);
		BigDecimal precioSugeridoVentaTemp4	= uno.subtract(precioSugeridoVentaTemp3);
		BigDecimal precioSugeridoVentaTemp2 = precioSugeridoVentaTemp1.divide(precioSugeridoVentaTemp4,0, RoundingMode.HALF_UP);
		disenoDTO.setPrecioSugeridoVenta(precioSugeridoVentaTemp2);
		diseno.setMargenGanancia(margenGanancia);
		diseno.setPrecioSugeridoVenta(precioSugeridoVentaTemp2);
		manejadorDiseno.save(diseno);
		return disenoDTO;
		}
		else {
			throw new InvalidParameterException("El margen de ganancia debe ser diferente a 100");
		}
	}

	@Override
	public String eliminar(Long idDiseno) {
		Diseno  diseno = manejadorDiseno.getReferenceById(idDiseno);
		
		List<EmpleadoDTO> empleados = manejadorDisenoEmpleado.empleadosDiseno(idDiseno);
		for(EmpleadoDTO empleado: empleados) {
			DisenoEmpleadoPK disenoEmpleadoPK = new DisenoEmpleadoPK();
			disenoEmpleadoPK.setIdDiseno(idDiseno);
			disenoEmpleadoPK.setNumeroIdentificacion(empleado.getNumeroIdentificacion());
			manejadorDisenoEmpleado.deleteById(disenoEmpleadoPK);
			manejadorEmpleado.deleteById(empleado.getNumeroIdentificacion());
		}
		
		List<MaquilaDTO> maquilas = manejadorDisenoMaquila.maquilasDiseno(idDiseno);
		for(MaquilaDTO maquila: maquilas) {
			DisenoMaquilaPK disenoMaquilaPK = new DisenoMaquilaPK();
			disenoMaquilaPK.setIdDiseno(idDiseno);
			disenoMaquilaPK.setIdMaquila(maquila.getIdMaquila());
			manejadorDisenoMaquila.deleteById(disenoMaquilaPK);
		}
		
		List<CifDTO> cifs = manejadorDisenoCif.cifsDiseno(idDiseno);
		for(CifDTO cif : cifs) {
			DisenoCifPK disenoCifPK = new DisenoCifPK();
			disenoCifPK.setIdDiseno(idDiseno);
			disenoCifPK.setIdCif(cif.getIdCif());
			manejadorDisenoCif.deleteById(disenoCifPK);
			manejadorCif.deleteById(cif.getIdCif());
		}
		List<ColeccionDTO> colecciones = manejadorColeccionDiseno.coleccionesDiseno(idDiseno);
		for(ColeccionDTO coleccion: colecciones) {
			ColeccionDisenoPK coleccionDisenoPK = new ColeccionDisenoPK();
			coleccionDisenoPK.setIdDiseno(idDiseno);
			coleccionDisenoPK.setIdColeccion(coleccion.getIdColeccion());
			manejadorColeccionDiseno.deleteById(coleccionDisenoPK);
		}
		manejadorDiseno.deleteById(diseno.getIdDiseno());
		return "Diseno eliminado correctamente";
	}

}
