package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Diseno;

@Repository
public interface ManejadorDiseno extends JpaRepository<Diseno, Long> {
	
	@Query("Select NEW com.bus.chelpaTex.Entity.Diseno( "
			+ "d.idDiseno, "
			+ "d.idUsuario, "
			+ "d.nombre, "
			+ "d.fechaCreacion,"
			+ "d.idMolde, "
			+ "d.idTrazabilidad, "
			+ "d.unidades, "
			+ "d.valorTotalUnidades, "
			+ "d.valorTotalEmpleados, "
			+ "d.valorTotalMaquila, "
			+ "d.valorTotalGastos, "
			+ "d.valorTotalCif, "
			+ "d.margenGanancia, "
			+ "d.totalEstimado, "
			+ "d.precioSugeridoVenta, "
			+ "d.activo ) "+
		   "FROM Diseno d Where d.idUsuario = :idUsuario "
			)
	public List<Diseno> disenosUsuario (@Param("idUsuario") String idUsuario);

}
