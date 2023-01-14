package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.DisenoCif;
import com.bus.chelpaTex.Entity.DisenoCifPK;

@Repository
public interface ManejadorDisenoCif extends JpaRepository<DisenoCif ,DisenoCifPK> {

}
