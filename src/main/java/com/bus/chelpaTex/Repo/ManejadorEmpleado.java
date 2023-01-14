package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Empleado;

@Repository
public interface ManejadorEmpleado extends JpaRepository<Empleado, Long> {

}
