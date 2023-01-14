package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.DisenoEmpleado;
import com.bus.chelpaTex.Entity.DisenoEmpleadoPK;

@Repository
public interface ManejadorDisenoEmpleado extends JpaRepository<DisenoEmpleado, DisenoEmpleadoPK> {

}
