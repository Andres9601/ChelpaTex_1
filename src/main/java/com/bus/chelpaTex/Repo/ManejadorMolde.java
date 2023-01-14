package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Molde;

@Repository
public interface ManejadorMolde extends JpaRepository<Molde, Long> {

}
