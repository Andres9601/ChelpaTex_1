package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;

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

import com.bus.chelpaTex.DTO.MoldeDTO;
import com.bus.chelpaTex.Service.ServicioMolde;

@RestController
@RequestMapping("/webresources/controller/controladorMolde")
public class ControladorMolde {

	@Autowired
	ServicioMolde servicioMolde;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar(@RequestParam(value = "tipoPrenda") String tipoPrenda,
			@RequestParam(value = "tipoModa") String tipoModa,
			@RequestParam(value = "objetivo") String objetivo,
			@RequestParam(value = "tipoAcabado") String tipoAcabado) throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioMolde.consultar(tipoPrenda, tipoModa, objetivo, tipoAcabado));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUserFirebase(@RequestBody MoldeDTO moldeDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioMolde.crear(moldeDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar el molde ");
    	}
	}
	
}