package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.Entity.ColeccionDiseno;
import com.bus.chelpaTex.Entity.ColeccionDisenoPK;

@Repository
public interface ManejadorColeccionDiseno extends JpaRepository<ColeccionDiseno, ColeccionDisenoPK> {
	
	@Query("Select NEW com.bus.chelpaTex.DTO.DisenoDTO( "
			+  "d.idDiseno, "
			+  "d.nombre, "
			+  "d.idMolde, "
			+  "d.unidades, "
			+  "d.totalEstimado ) "
			+ "FROM Diseno d JOIN ColeccionDiseno cd ON d.idDiseno = cd.coleccionDisenoPK.idDiseno "
			+ "WHERE cd.coleccionDisenoPK.idColeccion = :idColeccion" )
	public List<DisenoDTO> disenosColeccion (@Param ("idColeccion") Long idColeccion);
			

}
