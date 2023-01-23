package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.CifDTO;
import com.bus.chelpaTex.DTO.ColeccionDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.DTO.MoldeItemDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoRespuesta;
import com.bus.chelpaTex.Entity.Cif;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;
import com.bus.chelpaTex.Entity.Diseno;
import com.bus.chelpaTex.Entity.DisenoCif;
import com.bus.chelpaTex.Entity.DisenoCifPK;
import com.bus.chelpaTex.Entity.DisenoEmpleado;
import com.bus.chelpaTex.Entity.DisenoEmpleadoPK;
import com.bus.chelpaTex.Entity.DisenoMaquila;
import com.bus.chelpaTex.Entity.DisenoMaquilaPK;
import com.bus.chelpaTex.Entity.Empleado;
import com.bus.chelpaTex.Entity.Maquila;
import com.bus.chelpaTex.Entity.Molde;
import com.bus.chelpaTex.Repo.ManejadorCif;
import com.bus.chelpaTex.Repo.ManejadorDiseno;
import com.bus.chelpaTex.Repo.ManejadorDisenoCif;
import com.bus.chelpaTex.Repo.ManejadorDisenoEmpleado;
import com.bus.chelpaTex.Repo.ManejadorDisenoMaquila;
import com.bus.chelpaTex.Repo.ManejadorEmpleado;
import com.bus.chelpaTex.Repo.ManejadorMaquila;
import com.bus.chelpaTex.Repo.ManejadorMolde;
import com.bus.chelpaTex.Repo.ManejadorMoldeItem;
import com.bus.chelpaTex.Service.ServicioColeccionDiseno;
import com.bus.chelpaTex.Service.ServicioDiseno;

@Service
public class ServicioDisenoImpl implements ServicioDiseno{

	private static final Logger logger =  Logger.getLogger(ServicioDiseno.class.getName());

	
	@Autowired
	ManejadorDiseno manejadorDiseno;
	
	@Autowired
	ManejadorMolde manejadorMolde;
	
	@Autowired
	ServicioColeccionDiseno servicioColeccionDiseno;
	
	@Autowired
	ManejadorMoldeItem manejadorMoldeItem;
	
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
		diseno.setTotalEstimado(0L);
		diseno.setIdMolde(1L);
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
		ColeccionDisenoDTO coleccionDisenoDTO = new ColeccionDisenoDTO();
		ColeccionDisenoPK coleccionDisenoPK = new ColeccionDisenoPK();
		coleccionDisenoPK.setIdColeccion(nuevoDisenoDTO.getIdColeccion());
		coleccionDisenoPK.setIdDiseno(disenor.getIdDiseno());
		coleccionDisenoDTO.setColeccionDisenoPK(coleccionDisenoPK);
		servicioColeccionDiseno.crear(coleccionDisenoDTO);
		
		return respuesta;
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
		
		
		Molde molde = manejadorMolde.getReferenceById(actualizarDisenoDTO.getIdMolde());
		List<ItemDTO> items = manejadorMoldeItem.ItemsMolde(actualizarDisenoDTO.getIdMolde());
		Long valorItems = 0L;
		for(ItemDTO item:items)
		{
			MoldeItemDTO moldeItem = manejadorMoldeItem.cantidadItemMolde(item.getIdItem(), actualizarDisenoDTO.getIdMolde());
			Long cantidad = moldeItem.getCantidad();
			valorItems+= (item.getPrecioUnidad() * cantidad);
		}
		Long valorTotalUnidades = molde.getPrecio() + (valorItems * actualizarDisenoDTO.getUnidades());
		disenoDTO.setValorTotalUnidades(valorTotalUnidades);
		
		List<EmpleadoDTO> empleados = actualizarDisenoDTO.getEmpleados();
		Long valorEmpleados = 0L;
		for(EmpleadoDTO empleado: empleados) {
			Long salario = empleado.getSalario();
			Long productividad = empleado.getProductividad();
			valorEmpleados += salario/productividad;
			
			Empleado empleadoTemp = new  Empleado();
			empleadoTemp.setNumeroIdentificacion(empleado.getNumeroIdentificacion());
			empleadoTemp.setNombre(empleado.getNombre());
			empleadoTemp.setSalario(salario);
			empleadoTemp.setCargo(empleado.getCargo());
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
		Long valorTolalEmpleados = valorEmpleados * actualizarDisenoDTO.getUnidades();
		disenoDTO.setValorTotalEmpleados(valorTolalEmpleados);
		
		
		List<Long> idMaquilas = actualizarDisenoDTO.getIdsMaquilas();
		Long valorMaquilas = 0L;
		for(Long idMaquila : idMaquilas) {
			Maquila maquila = manejadorMaquila.getReferenceById(idMaquila);
			Long precioUnidad = maquila.getPrecioUnidad();
			valorMaquilas += precioUnidad;
			
			DisenoMaquila disenoMaquila = new DisenoMaquila();
			DisenoMaquilaPK disenoMaquilaPK = new DisenoMaquilaPK();
			disenoMaquilaPK.setIdDiseno(actualizarDisenoDTO.getIdDiseno());
			disenoMaquilaPK.setIdMaquila(idMaquila);
			disenoMaquila.setDisenoMaquilaPK(disenoMaquilaPK);
			disenoMaquila.setActivo(true);
			manejadorDisenoMaquila.save(disenoMaquila);
		}
		
		Long valorTotalMaquilas = valorMaquilas * actualizarDisenoDTO.getUnidades();
		disenoDTO.setValorTotalMaquila(valorTotalMaquilas);
		
		List<CifDTO> cifs = actualizarDisenoDTO.getCifs();
		Long valorCifs = 0L;
		for(CifDTO cif : cifs) {
			Long valor = cif.getValor();
			Long productividadPeriodo =cif.getProductividadPeriodo();
			valorCifs += valor/productividadPeriodo;
			
			Cif cifTemp = new Cif();
			cifTemp.setIdCif(cif.getIdCif());
			cifTemp.setTipoCif(cif.getTipoCif());
			cifTemp.setValor(valor);
			cifTemp.setPeriodo(cif.getPeriodo());
			cifTemp.setProductividadPeriodo(productividadPeriodo);
			cifTemp.setActivo(true);
			cifTemp = manejadorCif.save(cifTemp);
			
			DisenoCif disenoCif= new DisenoCif();
			DisenoCifPK disenoCifPK = new DisenoCifPK();
			disenoCifPK.setIdDiseno(actualizarDisenoDTO.getIdDiseno());
			disenoCifPK.setIdCif(cifTemp.getIdCif());
			disenoCif.setDisenoCifPK(disenoCifPK);
			disenoCif.setActivo(true);
			manejadorDisenoCif.save(disenoCif);
		}
		Long valorTotalCifs = valorCifs * actualizarDisenoDTO.getUnidades();
		disenoDTO.setValorTotalCif(valorTotalCifs);
		
		Long totalEstimado = valorTotalUnidades + valorTolalEmpleados + valorTotalMaquilas + valorTotalCifs;
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
	public DisenoDTO actualizarDisenoMg(DisenoDTO disenoDTO) {
		Diseno diseno = manejadorDiseno.getReferenceById(disenoDTO.getIdDiseno());
		Long margenGanancia = disenoDTO.getMargenGanancia();
		Long totalEstimado = diseno.getTotalEstimado();
		Long unidades = diseno.getUnidades();
		Long precioSugeridoVenta = (totalEstimado/unidades) * (1 + (margenGanancia/100));
		disenoDTO.setPrecioSugeridoVenta(precioSugeridoVenta);
		
		diseno.setMargenGanancia(margenGanancia);
		diseno.setPrecioSugeridoVenta(precioSugeridoVenta);
		manejadorDiseno.save(diseno);
		return disenoDTO;
	}

}
