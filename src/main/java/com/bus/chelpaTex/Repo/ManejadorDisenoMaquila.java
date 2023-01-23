package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.Entity.DisenoMaquila;
import com.bus.chelpaTex.Entity.DisenoMaquilaPK;

@Repository
public interface ManejadorDisenoMaquila extends JpaRepository<DisenoMaquila, DisenoMaquilaPK> {

	@Query("Select NEW com.bus.chelpaTex.DTO.MaquilaDTO( "
			+  "d.idMaquila, "
			+  "d.tipoMaquila, "
			+  "d.precioUnidad, "
			+  "d.activo ) "
			+ "FROM Maquila d JOIN DisenoMaquila cd ON d.idMaquila = cd.disenoMaquilaPK.idMaquila "
			+ "WHERE cd.disenoMaquilaPK.idDiseno = :idDiseno" )
	public List<MaquilaDTO> maquilasDiseno (@Param ("idDiseno") Long idDiseno);
}
