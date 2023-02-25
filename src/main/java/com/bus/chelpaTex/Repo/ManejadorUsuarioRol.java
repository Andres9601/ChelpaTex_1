package com.bus.chelpaTex.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.RolDTO;
import com.bus.chelpaTex.Entity.UsuarioRol;
import com.bus.chelpaTex.Entity.UsuarioRolPK;

@Repository
public interface ManejadorUsuarioRol extends JpaRepository<UsuarioRol, UsuarioRolPK> {

	@Query("Select NEW com.bus.chelpaTex.DTO.RolDTO( "
			+  "d.idRol, "
			+  "d.rol, "
			+  "d.activo ) "
			+ "FROM Rol d JOIN UsuarioRol cd ON d.idRol = cd.usuarioRolPK.idRol "
			+ "WHERE cd.usuarioRolPK.idUsuario = :idUsuario and d.activo=1 and cd.activo=1 ")
	public RolDTO rolUsuario (@Param ("idUsuario") String idUsuario);
}
