package com.bus.chelpaTex.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.CifDTO;
import com.bus.chelpaTex.DTO.DisenoCifDTO;
import com.bus.chelpaTex.DTO.GastoCifDTO;
import com.bus.chelpaTex.Entity.Cif;
import com.bus.chelpaTex.Entity.DisenoCif;
import com.bus.chelpaTex.Entity.DisenoCifPK;
import com.bus.chelpaTex.Repo.ManejadorCif;
import com.bus.chelpaTex.Repo.ManejadorDisenoCif;
import com.bus.chelpaTex.Service.ServicioDisenoCif;

@Service
@Transactional
public class ServicioDisenoCifImpl implements ServicioDisenoCif{
	
	private static final Logger logger =  Logger.getLogger(ServicioDisenoCif.class.getName());

	
	@Autowired
	ManejadorDisenoCif manejadorDisenoCif;
	
	@Autowired
	ManejadorCif manejadorCif;
	
	@Override
	public DisenoCifDTO crear(DisenoCifDTO disenoCifDTO) {
		try {
			DisenoCif disenoCif = new DisenoCif();
			disenoCif.setDisenoCifPK(disenoCifDTO.getDisenoCifPK());	
			disenoCif.setActivo(true);
			manejadorDisenoCif.save(disenoCif);
			return disenoCifDTO;
		}catch(InvalidParameterException e){
			logger.info(e.getMessage() + e.getCause());
			throw new InvalidParameterException("no se puede crear DisenoCif, revisar parametros");
		}
	}

	@Override
	public GastoCifDTO calcularValorCifs(List<CifDTO> cifs, ActualizarDisenoDTO actualizarDisenoDTO) {

		GastoCifDTO gastosCifDTO = new GastoCifDTO();
		BigDecimal valorGastos = BigDecimal.valueOf(0);
		BigDecimal valorCifs = BigDecimal.valueOf(0);

		for(CifDTO cif : cifs) {
			BigDecimal valor = cif.getValor();
			BigDecimal productividadPeriodo =cif.getProductividadPeriodo();
			valorGastos = valorGastos.add(valor.divide(productividadPeriodo,0, RoundingMode.HALF_UP));
			
			BigDecimal porcentajeCif = cif.getPorcentajeCif();
			BigDecimal valorCif = valor.multiply(porcentajeCif.divide(BigDecimal.valueOf(100)));
			valorCifs = valorCifs.add(valorCif.divide(productividadPeriodo,0, RoundingMode.HALF_UP));
			
			Cif cifTemp = new Cif();
			cifTemp.setIdCif(cif.getIdCif());
			cifTemp.setNombre(cif.getNombre());
			cifTemp.setTipoCif(cif.getTipoCif());
			cifTemp.setValor(valor);
			cifTemp.setPeriodo(cif.getPeriodo());
			cifTemp.setProductividadPeriodo(productividadPeriodo);
			cifTemp.setPorcentajeCif(cif.getPorcentajeCif());
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
		gastosCifDTO.setValorCifs(valorCifs);
		valorGastos = valorGastos.subtract(valorCifs);
		gastosCifDTO.setValorGastos(valorGastos);
		return gastosCifDTO;
	}

}
