package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.Entity.Maquila;

@Repository
public interface ManejadorMaquila extends JpaRepository<Maquila, Long> {

	
	@Query("Select NEW com.bus.chelpaTex.DTO.MaquilaDTO( "
			+  "d.idMaquila, "
			+  "d.tipoMaquila, "
			+  "d.precioUnidad, "
			+  "d.activo ) "
			+ "FROM Maquila d WHERE d.tipoMaquila = :tipoMaquila and d.activo=1 " )
	public List<MaquilaDTO> consultarMaquilasTipo(String tipoMaquila);

}
