package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.ColeccionDiseno;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;

@Repository
public interface ManejadorColeccionDiseno extends JpaRepository<ColeccionDiseno, ColeccionDisenoPK> {

}
