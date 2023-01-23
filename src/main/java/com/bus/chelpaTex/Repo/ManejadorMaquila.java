package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Maquila;

@Repository
public interface ManejadorMaquila extends JpaRepository<Maquila, Long> {

}
