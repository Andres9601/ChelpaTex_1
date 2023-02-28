package com.bus.chelpaTex.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.Entity.Item;

@Repository
public interface ManejadorItem extends JpaRepository<Item, Long> {

	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.nombre, "
			+  "d.imagen, "
			+  "d.origen, "
			+  "d.fabricante, "
			+  "d.referencia, "
			+  "d.uso, "
			+  "d.segmentoCategoria, "
			+  "d.base, "
			+  "d.ligamento, "
			+  "d.codigoAcabado, "
			+  "d.anchoTotal, "
			+  "d.pesoGramaje, "
			+  "d.peso, "
			+  "d.color, "
			+  "d.composicion, "
			+  "d.tipoTejido, "
			+  "d.diseno, "
			+  "d.ubicacion, "
			+  "d.tamano, "
			+  "d.tipoMaterial, "
			+  "d.tipoPrenda, "
			+  "d.maquinasEspeciales, "
			+  "d.cantidadPrenda, "
			+  "d.objetivo, "
			+  "d.usoSugerido, "
			+  "d.tipoTintura, "
			+  "d.ecologico, "
			+  "d.impactoSocial, "
			+  "d.normaCertificacion, "
			+  "d.anchoUtil, "
			+  "d.longitud, "
			+  "d.calibreGrosor, "
			+  "d.aseguramiento, "
			+  "d.forma, "
			+  "d.numeroLigas, "
			+  "d.textura, "
			+  "d.encogimiento, "
			+  "d.elongacion, "
			+  "d.unidad, "
			+  "d.idUsuario, "
			+  "d.activo) "
			+ "FROM Item d WHERE d.tipoItem = :tipoItem and d.activo=1 " )
	public List<ItemDTO> consultarItemsTipo(String tipoItem);

	
	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.nombre, "
			+  "d.referencia, "
			+  "d.segmentoCategoria, "
			+  "d.activo) "
			+ "FROM Item d WHERE d.idUsuario = :idUsuario AND d.tipoItem = :tipoItem and d.activo=1" )
	public List<ItemDTO> consultarItemsUsuarioTipo(@Param("idUsuario") String idUsuario, @Param("tipoItem") String tipoItem);


	
	@Query("Select NEW com.bus.chelpaTex.DTO.ItemDTO( "
			+  "d.idItem, "
			+  "d.tipoItem, "
			+  "d.idTrazabilidad, "
			+  "d.precioUnidad, "
			+  "d.cantidadMinima, "
			+  "d.nombre, "
			+  "d.imagen, "
			+  "d.origen, "
			+  "d.fabricante, "
			+  "d.referencia, "
			+  "d.uso, "
			+  "d.segmentoCategoria, "
			+  "d.base, "
			+  "d.ligamento, "
			+  "d.codigoAcabado, "
			+  "d.anchoTotal, "
			+  "d.pesoGramaje, "
			+  "d.peso, "
			+  "d.color, "
			+  "d.composicion, "
			+  "d.tipoTejido, "
			+  "d.diseno, "
			+  "d.ubicacion, "
			+  "d.tamano, "
			+  "d.tipoMaterial, "
			+  "d.tipoPrenda, "
			+  "d.maquinasEspeciales, "
			+  "d.cantidadPrenda, "
			+  "d.objetivo, "
			+  "d.usoSugerido, "
			+  "d.tipoTintura, "
			+  "d.ecologico, "
			+  "d.impactoSocial, "
			+  "d.normaCertificacion, "
			+  "d.anchoUtil, "
			+  "d.longitud, "
			+  "d.calibreGrosor, "
			+  "d.aseguramiento, "
			+  "d.forma, "
			+  "d.numeroLigas, "
			+  "d.textura, "
			+  "d.encogimiento, "
			+  "d.elongacion, "
			+  "d.unidad, "
			+  "d.idUsuario, "
			+  "d.activo) "
			+  " From Item d where d.idItem = :idItem and d.activo =1 " )
	public ItemDTO consultarDetallesItem(@Param("idItem") Long idItem);
	
}
