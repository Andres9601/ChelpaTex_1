package com.bus.chelpaTex.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "DISENO_EMPLEADO")
public class DisenoEmpleado {
	
	@EmbeddedId
	private DisenoEmpleadoPK disenoEmpleadoPK;
	
	
	@Column(name = "activo")
	private Boolean activo;
	
    @ManyToOne
    @JoinColumn(name = "id_diseno", referencedColumnName = "id_diseno", insertable = false, updatable = false)
    private Diseno diseno;
    
    @ManyToOne
    @JoinColumn(name = "numero_identificacion", referencedColumnName = "numero_identificacion", insertable = false, updatable = false)
    private Empleado empleado;
}
