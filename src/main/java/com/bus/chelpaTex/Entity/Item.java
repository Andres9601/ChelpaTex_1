package com.bus.chelpaTex.Entity;

import java.math.BigDecimal;

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
	@Table(name = "ITEM")
	public class Item {
		
		
		@Id
		@GeneratedValue(generator = "SEQ_ITEM")
	    @GenericGenerator(name = "SEQ_ITEM", strategy = "increment")
		@Column(name = "id_item")
		private Long idItem;
		
		@Column(name = "tipo_item")
		private String tipoItem;
		
		@Column(name = "id_trazabilidad")
		private String idTrazabilidad;
		
		@Column(name = "precio_unidad")
		private BigDecimal precioUnidad;
		
		@Column(name = "cantidad_minima")
		private BigDecimal cantidadMinima;
		
		
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "imagen")
		private String imagen;
		
		@Column(name = "origen")
		private String origen;
		
		@Column(name = "fabricante")
		private String fabricante;
		
		@Column(name = "referencia")
		private String referencia;
		
		@Column(name = "uso")
		private String uso;
		
		@Column(name = "segmento_categoria")
		private String segmentoCategoria;
		
		@Column(name = "base")
		private String base;
		
		@Column(name = "ligamento")
		private String ligamento;
		
		@Column(name = "codigo_acabado")
		private String codigoAcabado;
		
		@Column(name = "ancho_total")
		private BigDecimal anchoTotal;
		
		@Column(name = "peso_gramaje")
		private BigDecimal pesoGramaje;
		
		@Column(name = "peso")
		private BigDecimal peso;
		
		@Column(name = "color")
		private String color;
		
		@Column(name = "composicion")
		private String composicion;
		
		@Column(name = "tipo_tejido")
		private String tipoTejido;
		
		@Column(name = "diseno")
		private String diseno;
		
		@Column(name = "ubicacion")
		private String ubicacion;
		
		@Column(name = "tamano")
		private String tamano;
		
		@Column(name = "tipo_material")
		private String tipoMaterial;
		
		@Column(name = "tipo_prenda")
		private String tipoPrenda;
		
		@Column(name = "maquinas_especiales")
		private String maquinasEspeciales;
		
		@Column(name = "cantidad_prenda")
		private BigDecimal cantidadPrenda;
		
		@Column(name = "objetivo")
		private String objetivo;
		
		@Column(name = "uso_sugerido")
		private String usoSugerido;
		
		@Column(name = "tipo_tintura")
		private String tipoTintura;
		
		@Column(name = "ecologico")
		private String ecologico;
		
		@Column(name = "impacto_social")
		private String impactoSocial;
		
		@Column(name = "norma_certificacion")
		private String normaCertificacion;
		
		@Column(name = "ancho_util")
		private BigDecimal anchoUtil;
		
		@Column(name = "longitud")
		private BigDecimal longitud;
		
		@Column(name = "calibreGrosor")
		private BigDecimal calibreGrosor;
		
		@Column(name = "aseguramiento")
		private String aseguramiento;
		
		@Column(name = "forma")
		private String forma;
		
		@Column(name = "numero_ligas")
		private BigDecimal numeroLigas;
		
		@Column(name = "textura")
		private String textura;
		
		@Column(name = "encogimiento")
		private String encogimiento;
		
		@Column(name = "elongacion")
		private String elongacion;
		
		@Column(name = "unidad")
		private String unidad;
		
		@Column(name = "id_usuario")
		private String idUsuario;
		
		@Column(name = "activo")
		private Boolean activo;
		
		

		public Item(Long idItem, String tipoItem, String idTrazabilidad, BigDecimal precioUnidad,
				BigDecimal cantidadMinima, String nombre, String referencia, String segmentoCategoria, Boolean activo) {
			super();
			this.idItem = idItem;
			this.tipoItem = tipoItem;
			this.idTrazabilidad = idTrazabilidad;
			this.precioUnidad = precioUnidad;
			this.cantidadMinima = cantidadMinima;
			this.nombre = nombre;
			this.referencia = referencia;
			this.segmentoCategoria = segmentoCategoria;
			this.activo = activo;
		}

		

	}



