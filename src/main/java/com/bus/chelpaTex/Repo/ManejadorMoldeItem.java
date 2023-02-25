package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.DTO.MoldeItemDTO;
import com.bus.chelpaTex.Entity.MoldeItem;
import com.bus.chelpaTex.Entity.MoldeItemPK;

@Repository
public interface ManejadorMoldeItem extends JpaRepository<MoldeItem, MoldeItemPK> {
	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.activo) "
			+ "FROM Item d JOIN MoldeItem mi ON d.idItem = mi.moldeItemPK.idItem "
			+ "WHERE mi.moldeItemPK.idMolde = :idMolde and d.activo=1 and mi.activo=1 ")
	public List<ItemDTO> ItemsMolde (@Param("idMolde") Long idMolde);
	
	@Query("Select NEW com.bus.chelpaTex.DTO.MoldeItemDTO( "
			+ "mi.cantidad) "
			+ " FROM MoldeItem mi "
			+ "Where mi.moldeItemPK.idItem = :idItem "
			+ "AND mi.moldeItemPK.idMolde = :idMolde ")
	public MoldeItemDTO cantidadItemMolde (@Param("idItem") Long idItem, 
			@Param("idMolde") Long idMolde);
			

}
