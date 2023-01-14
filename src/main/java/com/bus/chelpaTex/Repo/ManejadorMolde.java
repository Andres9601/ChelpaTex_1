package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Molde;

@Repository
public interface ManejadorMolde extends JpaRepository<Molde, Long> {
	
	@Query("Select NEW com.bus.chelpaTex.Entity.Molde( "
			+ "m.idMolde, "
			+ "m.idUsuario , "
			+ "m.nombre , "
			+ "m.fechaCreacion , "
			+ "m.precio , "
			+ "m.tipoMolde , "
			+ "m.tipoPrenda , "
			+ "m.tipoModa , "
			+ "m.objetivo , "
			+ "m.tipoAcabado , "
			+ "m.anchoTela , "
			+ "m.consumoTotal , "
			+ "m.tipoProduccion , "
			+ "m.tipoCascada , "
			+ "m.caracteristicas , "
			+ "m.rutaArchivo , "
			+ "m.activo ) "+
		   "FROM Molde m Where m.tipoPrenda = :tipoPrenda"
		   + " AND m.tipoModa = :tipoModa  "
		   + " AND m.objetivo = :objetivo "
		   + " AND m.tipoAcabado = :tipoAcabado "
			)
	public List<Molde> moldesFiltro (@Param("tipoPrenda") String tipoPrenda, @Param("tipoModa") String tipoModa,
			@Param("objetivo") String objetivo,@Param("tipoAcabado") String tipoAcabado);

}
