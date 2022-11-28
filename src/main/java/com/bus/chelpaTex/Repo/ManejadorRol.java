package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Rol;

@Repository
public interface ManejadorRol extends JpaRepository<Rol, Long> {

}
