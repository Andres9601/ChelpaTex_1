package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.EmpleadoDTO;
import com.bus.chelpaTex.Entity.DisenoEmpleado;
import com.bus.chelpaTex.Entity.DisenoEmpleadoPK;

@Repository
public interface ManejadorDisenoEmpleado extends JpaRepository<DisenoEmpleado, DisenoEmpleadoPK> {

	@Query("Select NEW com.bus.chelpaTex.DTO.EmpleadoDTO( "
			+  "d.numeroIdentificacion, "
			+  "d.nombre, "
			+  "d.salario, "
			+  "d.cargo, "
			+  "d.tarea, "
			+  "d.productividad, "
			+  "d.activo ) "
			+ "FROM Empleado d JOIN DisenoEmpleado cd ON d.numeroIdentificacion = cd.disenoEmpleadoPK.numeroIdentificacion "
			+ "WHERE cd.disenoEmpleadoPK.idDiseno = :idDiseno" )
	public List<EmpleadoDTO> empleadosDiseno (@Param ("idDiseno") Long idDiseno);
	
}
