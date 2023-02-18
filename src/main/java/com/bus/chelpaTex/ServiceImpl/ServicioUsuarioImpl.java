package com.bus.chelpaTex.ServiceImpl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.RegistroDTO;
import com.bus.chelpaTex.DTO.RolDTO;
import com.bus.chelpaTex.DTO.UsuarioDTO;
import com.bus.chelpaTex.DTO.UsuarioRolDTO;
import com.bus.chelpaTex.Entity.Usuario;
import com.bus.chelpaTex.Entity.UsuarioRolPK;
import com.bus.chelpaTex.Repo.ManejadorUsuario;
import com.bus.chelpaTex.Repo.ManejadorUsuarioRol;
import com.bus.chelpaTex.Service.ServicioUsuario;
import com.bus.chelpaTex.Service.ServicioUsuarioRol;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	private static final Logger logger =  Logger.getLogger(ServicioUsuario.class.getName());
	
	@Autowired
	ManejadorUsuario manejadorUsuario;
	
	@Autowired
	ServicioUsuarioRol servicioUsuarioRol;
	
	@Autowired
	ManejadorUsuarioRol manejadorUsuarioRol;

	@Override
	public List<UsuarioDTO> consultar() {
		List<Usuario> usuariosTemp = manejadorUsuario.findAll();
		List<UsuarioDTO> usuarios= new ArrayList<UsuarioDTO>();
		for (Usuario usuarioTemp:usuariosTemp) {
			UsuarioDTO usuarioDto = new UsuarioDTO();
			usuarioDto.setIdUsuario(usuarioTemp.getIdUsuario());
			usuarioDto.setEmail(usuarioTemp.getEmail());
			usuarioDto.setNombre(usuarioTemp.getNombre());
			usuarioDto.setTelefono(usuarioTemp.getTelefono());
			usuarioDto.setActivo(usuarioTemp.getActivo());
			usuarios.add(usuarioDto);
		}
		return usuarios;
	}

	@Override
	public UsuarioDTO crear(UsuarioDTO usuarioDTO) throws InvalidParameterException{
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDTO.getEmail());
			if(!usuarioExiste.isPresent()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(usuarioDTO.getIdUsuario());	
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setTelefono(usuarioDTO.getTelefono());
			usuario.setActivo(usuarioDTO.getActivo());
			manejadorUsuario.save(usuario);
			return usuarioDTO;
		}
			else {
				logger.info("Parametros invalidos para crear un Usuario");
				throw new InvalidParameterException("Parametros invalidos para crear un Usuario");
			}
	}
			

	@Override
	public RegistroDTO registrarUsuario(RegistroDTO registroDTO) throws Exception {
		UsuarioDTO usuarioDto = registroDTO.getUsuarioDTO();
		RolDTO rolDto = registroDTO.getRolDTO();
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDto.getEmail());
		if(!usuarioExiste.isPresent()) {
				this.crear(usuarioDto);
				UsuarioRolPK usuRolPk = new UsuarioRolPK();
				usuRolPk.setIdUsuario(usuarioDto.getIdUsuario());
				usuRolPk.setIdRol(rolDto.getIdRol());
				UsuarioRolDTO usuRolDto = new UsuarioRolDTO();
				usuRolDto.setUsuarioRolPK(usuRolPk);
				usuRolDto.setActivo(rolDto.getActivo());
				servicioUsuarioRol.crear(usuRolDto);
				return registroDTO;

			}
				
		else {
			
			logger.info("No se puede registrar el Usuario, el email ya esta registrado en base de datos");
			throw new Exception("No se puede registrar el Usuario, el email ya esta registrado en base de datos");
			}
		
	}

	@Override
	public RegistroDTO consultarDatosUsuario(String idUsuario) {
		RegistroDTO respuesta =new RegistroDTO();
		Usuario usuarioTemp = manejadorUsuario.getReferenceById(idUsuario);
		RolDTO rol = manejadorUsuarioRol.rolUsuario(idUsuario);
		respuesta.setRolDTO(rol);
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setIdUsuario(idUsuario);
		usuario.setEmail(usuarioTemp.getEmail());
		usuario.setNombre(usuarioTemp.getNombre());
		usuario.setTelefono(usuarioTemp.getTelefono());
		usuario.setActivo(usuarioTemp.getActivo());
		respuesta.setUsuarioDTO(usuario);
		return respuesta;
	}
	
	
	

}
