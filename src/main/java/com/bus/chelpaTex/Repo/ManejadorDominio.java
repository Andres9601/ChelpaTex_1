package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.DominioDTO;
import com.bus.chelpaTex.Entity.Dominio;

@Repository
public interface ManejadorDominio extends JpaRepository<Dominio, Long> {
	
	
	@Query("Select NEW com.bus.chelpaTex.DTO.DominioDTO( "
			+  "d.idDominio, "
			+  "d.tipoDominio, "
			+  "d.nombre, "
			+  "d.activo) "
			+ "FROM Dominio d "
			+ "WHERE d.tipoDominio = 'DOM_TIPO_ITEM' and d.activo=1 " )
	public List<DominioDTO> tiposItem();
	
	@Query("Select NEW com.bus.chelpaTex.DTO.DominioDTO( "
			+  "d.idDominio, "
			+  "d.tipoDominio, "
			+  "d.nombre, "
			+  "d.activo) "
			+ "FROM Dominio d "
			+ "WHERE d.tipoDominio = 'DOM_TIPO_MAQUILA' and d.activo=1 " )
	public List<DominioDTO> tiposMaquila();

	
	@Query("Select NEW com.bus.chelpaTex.DTO.DominioDTO( "
			+  "d.idDominio, "
			+  "d.tipoDominio, "
			+  "d.nombre, "
			+  "d.activo, "
			+  "d.tipoDato ) "
			+ "FROM Dominio d "
			+ "WHERE d.tipoDominio =:tipoDominio and d.activo=1 " )
	public List<DominioDTO> consultarDominiosTipo(String tipoDominio);

}
