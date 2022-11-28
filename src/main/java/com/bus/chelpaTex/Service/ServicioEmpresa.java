package com.bus.chelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.EmpresaDTO;

@Service
public interface ServicioEmpresa {
	
	@Qualifier("ServicioEmpresaImpl")
	public EmpresaDTO crear(EmpresaDTO empresaDTO);

}
