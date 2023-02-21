package com.bus.chelpaTex.Service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.Entity.Molde;


@Service
public interface ServicioMolde {
	
	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado);
	
	@Qualifier("ServicioMoldeImpl")
	public Molde crear (MoldeDTO moldeDTO) throws InvalidParameterException;

	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultarMoldesParametros(MoldeDTO molde);

	@Qualifier("ServicioMoldeImpl")
	public MoldeDTO crearDisenoConMolde(MoldeDTO molde);
	
}
