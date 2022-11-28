package com.bus.chelpaTex.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Usuario;

@Repository
public interface ManejadorUsuario extends JpaRepository<Usuario, String> {
	
	Optional<Usuario> findOneByEmail(String email);
}
