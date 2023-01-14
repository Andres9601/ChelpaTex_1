package com.bus.chelpaTex.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegistroDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UsuarioDTO usuarioDTO;
	
	RolDTO rolDTO;
	
}
