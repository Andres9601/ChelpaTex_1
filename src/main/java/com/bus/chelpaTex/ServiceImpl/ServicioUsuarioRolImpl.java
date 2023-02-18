package com.bus.chelpaTex.ServiceImpl;


import java.security.InvalidParameterException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.UsuarioRolDTO;
import com.bus.chelpaTex.Entity.UsuarioRol;
import com.bus.chelpaTex.Repo.ManejadorUsuarioRol;
import com.bus.chelpaTex.Service.ServicioUsuarioRol;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol {
	
	private static final Logger logger =  Logger.getLogger(ServicioUsuarioRol.class.getName());


	@Autowired
	ManejadorUsuarioRol manejadorUsuarioRol;
	
	@Override
	public UsuarioRolDTO crear(UsuarioRolDTO usuarioRolDTO) throws InvalidParameterException{

		try {
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuarioRolPK(usuarioRolDTO.getUsuarioRolPK());	
			usuarioRol.setActivo(usuarioRolDTO.getActivo());
			manejadorUsuarioRol.save(usuarioRol);
			return usuarioRolDTO;
		}catch(InvalidParameterException e){
			logger.info(e.getMessage() + e.getCause());
			throw new InvalidParameterException("Parametros invalidos");
		}
	}
}
