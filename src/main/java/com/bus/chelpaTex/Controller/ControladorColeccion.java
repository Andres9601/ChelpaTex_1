package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.chelpaTex.DTO.ColeccionDTO;
import com.bus.chelpaTex.Service.ServicioColeccion;

@RestController
@RequestMapping("/webresources/controller/controladorColeccion")
public class ControladorColeccion {

	@Autowired
	ServicioColeccion servicioColeccion;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar(@RequestParam(value = "idUsuario") String idUsuario) throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioColeccion.consultar(idUsuario));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUserFirebase(@RequestBody ColeccionDTO coleccionDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioColeccion.crear(coleccionDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar la coleccion ");
    	}
	}
	
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam(value="idColeccion") Long idColeccion) {
    	try {
    		return ResponseEntity.ok(servicioColeccion.eliminar(idColeccion));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede eliminar la coleccion ");
    	}
	}
	
}
