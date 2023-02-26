package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.CampoAdicionalDTO;
import com.bus.chelpaTex.Entity.CampoAdicional;

@Repository
public interface ManejadorCampoAdicional extends JpaRepository<CampoAdicional, Long> {

	@Query("Select NEW com.bus.chelpaTex.DTO.CampoAdicionalDTO( "
			+  "d.idCampo, "
			+  "d.idItem, "
			+  "d.nombre, "
			+  "d.valor, "
			+  "d.activo) "
			+ "FROM CampoAdicional d Where d.idItem = :idItem ")
	public List<CampoAdicionalDTO> consultarCamposAdicionalesIdItem(Long idItem);
	
	

}
