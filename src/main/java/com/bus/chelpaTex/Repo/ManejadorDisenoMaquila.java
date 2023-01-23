package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.DisenoMaquila;
import com.bus.chelpaTex.Entity.DisenoMaquilaPK;

@Repository
public interface ManejadorDisenoMaquila extends JpaRepository<DisenoMaquila, DisenoMaquilaPK> {

}
