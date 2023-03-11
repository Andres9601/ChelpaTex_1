package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Coleccion;

@Repository
public interface ManejadorColeccion extends JpaRepository<Coleccion, Long> {

	@Query("Select NEW com.bus.chelpaTex.Entity.Coleccion( "
			+ "c.idColeccion, "
			+ "c.idUsuario, "
			+ "c.nombre, "
			+ "c.fechaCreacion, "
			+ "c.activo,"
			+ "c.iniciales, "
			+ "c.color) "+
		   "FROM Coleccion c Where c.idUsuario = :idUsuario AND c.activo = 1 "
			)
	public List<Coleccion> coleccionesUsuario (@Param("idUsuario") String idUsuario);
	
}
