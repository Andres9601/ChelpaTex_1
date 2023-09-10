package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.RolDTO;
import com.bus.chelpaTex.Entity.Rol;
import com.bus.chelpaTex.Repo.ManejadorRol;
import com.bus.chelpaTex.Service.ServicioRol;

@Service
@Transactional
public class ServicioRolImpl implements ServicioRol{

	@Autowired
	ManejadorRol manejadorRol;
	
	@Override
	public List<RolDTO> consultar() {
		List<Rol> rolesTemp = manejadorRol.findAll();
		List<RolDTO> roles = new ArrayList<RolDTO>();
		for (Rol rol : rolesTemp) {
			RolDTO rolDto = new RolDTO();
			rolDto.setIdRol(rol.getIdRol());
			rolDto.setRol(rol.getRol());
			rolDto.setActivo(rol.getActivo());
			roles.add(rolDto);
		}
	return roles;
	}

}
