package com.bus.chelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.chelpaTex.DTO.EmpresaDTO;
import com.bus.chelpaTex.DTO.RegistroDTO;
import com.bus.chelpaTex.DTO.RolDTO;
import com.bus.chelpaTex.DTO.UsuarioDTO;
import com.bus.chelpaTex.DTO.UsuarioRolDTO;
import com.bus.chelpaTex.Entity.Usuario;
import com.bus.chelpaTex.Entity.UsuarioRolPK;
import com.bus.chelpaTex.Repo.ManejadorUsuario;
import com.bus.chelpaTex.Service.ServicioEmpresa;
import com.bus.chelpaTex.Service.ServicioUsuario;
import com.bus.chelpaTex.Service.ServicioUsuarioRol;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	private static final Logger logger =  Logger.getLogger(ServicioUsuario.class.getName());
	
	@Autowired
	ManejadorUsuario manejadorUsuario;
		
	@Autowired
	ServicioEmpresa servicioEmpresa;
	
	@Autowired
	ServicioUsuarioRol servicioUsuarioRol;
	

	@Override
	public List<UsuarioDTO> consultar() {
		List<Usuario> usuariosTemp = manejadorUsuario.findAll();
		UsuarioDTO usuarioDto = new UsuarioDTO();
		List<UsuarioDTO> usuarios= new ArrayList<UsuarioDTO>();
		for (Usuario usuarioTemp:usuariosTemp) {
			usuarioDto.setIdUsuario(usuarioTemp.getIdUsuario());
			usuarioDto.setEmail(usuarioTemp.getEmail());
			usuarioDto.setActivo(usuarioTemp.getActivo());
			usuarios.add(usuarioDto);
		}
		return usuarios;
	}

	@Override
	public UsuarioDTO crear(UsuarioDTO usuarioDTO) {
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDTO.getEmail());
		try {
			if(usuarioExiste.isPresent()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(usuarioDTO.getIdUsuario());	
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setActivo(usuarioDTO.getActivo());
			manejadorUsuario.save(usuario);
		}
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
			
		return usuarioDTO;
	}

	@Override
	public RegistroDTO registrarUsuario(RegistroDTO registroDTO) {
		UsuarioDTO usuarioDto = registroDTO.getUsuarioDTO();
		EmpresaDTO empresaDto = registroDTO.getEmpresaDTO();
		empresaDto.setIdUsuario(usuarioDto.getIdUsuario());
		RolDTO rolDto = registroDTO.getRolDTO();
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDto.getEmail());
		try {
			if(usuarioExiste.isPresent()) {
				this.crear(usuarioDto);
				servicioEmpresa.crear(empresaDto);
				UsuarioRolPK usuRolPk = new UsuarioRolPK();
				usuRolPk.setIdUsuario(usuarioDto.getIdUsuario());
				usuRolPk.setIdRol(rolDto.getIdRol());
				UsuarioRolDTO usuRolDto = new UsuarioRolDTO();
				usuRolDto.setUsuarioRolPK(usuRolPk);
				usuRolDto.setActivo(rolDto.getActivo());
				servicioUsuarioRol.crear(usuRolDto);
				return registroDTO;

			}
		}
			catch(Exception e){
				logger.info(e.getMessage() + e.getCause());
				return null;
			}
				
		return registroDTO;
	}
	
	
	

}
