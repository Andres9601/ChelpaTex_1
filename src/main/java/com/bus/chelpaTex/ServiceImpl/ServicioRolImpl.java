package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.RolDTO;
import com.bus.chelpaTex.Entity.Rol;
import com.bus.chelpaTex.Repo.ManejadorRol;
import com.bus.chelpaTex.Service.ServicioRol;

@Service
public class ServicioRolImpl implements ServicioRol{

	ManejadorRol manejadorRol;
	
	@Override
	public List<RolDTO> consultar() {
		List<Rol> rolesTemp = manejadorRol.findAll();
		RolDTO rolDto = new RolDTO();
		List<RolDTO> roles = new ArrayList<RolDTO>();
		for (Rol rol : rolesTemp) {
			rolDto.setIdRol(rol.getIdRol());
			rolDto.setRol(rol.getRol());
			rolDto.setActivo(rol.getActivo());
			roles.add(rolDto);
		}
	return roles;
	}

}
