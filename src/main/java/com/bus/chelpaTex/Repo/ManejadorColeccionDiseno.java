package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.ColeccionDTO;
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
			+ "WHERE cd.coleccionDisenoPK.idColeccion = :idColeccion and d.activo=1 and cd.activo=1 " )
	public List<DisenoDTO> disenosColeccion (@Param ("idColeccion") Long idColeccion);
			
	@Query("Select NEW com.bus.chelpaTex.DTO.ColeccionDTO( "
			+  "d.idColeccion, "
			+  "d.idUsuario, "
			+  "d.nombre, "
			+  "d.fechaCreacion, "
			+  "d.activo ) "
			+ "FROM Coleccion d JOIN ColeccionDiseno cd ON d.idColeccion = cd.coleccionDisenoPK.idColeccion "
			+ "WHERE cd.coleccionDisenoPK.idDiseno = :idDiseno and d.activo=1 and cd.activo=1 " )
	public List<ColeccionDTO> coleccionesDiseno (@Param ("idDiseno") Long idDiseno);

}
