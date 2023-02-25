package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.Entity.Item;

@Repository
public interface ManejadorItem extends JpaRepository<Item, Long> {

	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.activo) "
			+ "FROM Item d WHERE d.tipoItem = :tipoItem and d.activo=1 " )
	public List<ItemDTO> consultarItemsTipo(String tipoItem);

	
	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.activo) "
			+ "FROM Item d WHERE d.idUsuario = :idUsuario AND d.tipoItem = :tipoItem and d.activo=1" )
	public List<ItemDTO> consultarItemsUsuarioTipo(String idUsuario, String tipoItem);
	
	

}
