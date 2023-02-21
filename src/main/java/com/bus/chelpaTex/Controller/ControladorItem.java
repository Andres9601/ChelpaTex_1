package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.chelpaTex.DTO.CantidadItemDTO;
import com.bus.chelpaTex.DTO.ItemDTO;
import com.bus.chelpaTex.Service.ServicioItem;
import com.bus.chelpaTex.Service.ServicioMoldeItem;

@RestController
@RequestMapping("/webresources/controller/controladorItem")
public class ControladorItem {
	
	@Autowired
	ServicioMoldeItem servicioMoldeItem;
	
	@Autowired
	ServicioItem servicioItem;
	
	
	@GetMapping(path= "/consultarItemsMolde", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarItemsMolde(@RequestParam(value = "idMolde") Long idMolde )throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioMoldeItem.consultarItemsMolde(idMolde));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@GetMapping(path= "/consultarItemsTipo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarItemsTipo(@RequestParam(value = "tipoItem") String tipoItem )throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioItem.consultarItemsTipo(tipoItem));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody ItemDTO itemDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioItem.crear(itemDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar el item ");
    	}
	}
	
	@PostMapping(path = "/crearItemsMolde", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearItemsMolde(@RequestBody List<CantidadItemDTO> cantidadItemDTOs )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioMoldeItem.crearItemsMolde(cantidadItemDTOs));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede vincular el item ");
    	}
	}

}
