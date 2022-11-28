package com.bus.chelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.RolDTO;

@Service
public interface ServicioRol {
	
	@Qualifier("ServicioRolImpl")
	public List<RolDTO> consultar();

}
