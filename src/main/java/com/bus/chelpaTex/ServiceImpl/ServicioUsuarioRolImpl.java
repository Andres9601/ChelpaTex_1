package com.bus.chelpaTex.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.UsuarioRolDTO;
import com.bus.chelpaTex.Entity.UsuarioRol;
import com.bus.chelpaTex.Repo.ManejadorUsuarioRol;
import com.bus.chelpaTex.Service.ServicioUsuarioRol;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol {

	@Autowired
	ManejadorUsuarioRol manejadorUsuarioRol;
	
	@Override
	public UsuarioRolDTO crear(UsuarioRolDTO usuarioRolDTO) {

		try {
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuarioRolPK(usuarioRolDTO.getUsuarioRolPK());	
			usuarioRol.setActivo(usuarioRolDTO.getActivo());
			manejadorUsuarioRol.save(usuarioRol);
			return usuarioRolDTO;
		}catch(Exception e){
			return null;
		}
	}
}
