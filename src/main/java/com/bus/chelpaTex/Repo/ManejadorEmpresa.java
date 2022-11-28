package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Empresa;

@Repository
public interface ManejadorEmpresa extends JpaRepository<Empresa, Long> {

}
