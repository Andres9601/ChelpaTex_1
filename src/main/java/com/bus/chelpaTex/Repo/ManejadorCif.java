package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Cif;

@Repository
public interface ManejadorCif extends JpaRepository<Cif, Long> {

}
