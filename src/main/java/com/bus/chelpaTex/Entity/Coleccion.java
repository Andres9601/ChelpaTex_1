package com.bus.chelpaTex.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "COLECCION")
public class Coleccion {
	
	
	@Id
	@GeneratedValue(generator = "SEQ_COLECCION")
    @GenericGenerator(name = "SEQ_COLECCION", strategy = "increment")
	@Column(name = "id_coleccion")
	private Long idColeccion;
	
	@Column(name = "id_usuario")
	private String idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "iniciales")
	private String iniciales;
	
	@Column(name = "color")
	private String color;

}
