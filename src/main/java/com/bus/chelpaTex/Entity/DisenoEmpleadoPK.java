package com.bus.chelpaTex.Entity;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DisenoEmpleadoPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "numero_identificacion")
    private Long numeroIdentificacion;

    @Basic(optional = false)
    @Column(name = "id_diseno")
    private Long idDiseno;
}