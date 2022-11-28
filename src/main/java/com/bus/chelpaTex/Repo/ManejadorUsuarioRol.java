package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.UsuarioRol;
import com.bus.chelpaTex.Entity.UsuarioRolPK;

@Repository
public interface ManejadorUsuarioRol extends JpaRepository<UsuarioRol, UsuarioRolPK> {

}
