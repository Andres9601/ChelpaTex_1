package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.Entity.Molde;


@Service
public interface ServicioMolde {
	
	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultar(String tipoPrenda, String tipoModa, String objetivo, String tipoAcabado) throws IllegalAccessException;
	
	@Qualifier("ServicioMoldeImpl")
	public Molde crear (MoldeDTO moldeDTO) throws Exception;

	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultarMoldesParametros(MoldeDTO molde);

	@Qualifier("ServicioMoldeImpl")
	public MoldeDTO crearDisenoConMolde(MoldeDTO molde) throws Exception;
	
	@Qualifier("ServicioMoldeImpl")
	public List<MoldeDTO> consultarMoldesUsuario(String idUsuario);

	@Qualifier("ServicioMoldeImpl")
	public MoldeDTO consultarDetallesMolde(Long idMolde);

}
