package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Diseno;

@Repository
public interface ManejadorDiseno extends JpaRepository<Diseno, Long> {

}
