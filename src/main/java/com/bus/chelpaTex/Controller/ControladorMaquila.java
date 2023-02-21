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

import com.bus.chelpaTex.DTO.MaquilaDTO;
import com.bus.chelpaTex.Service.ServicioMaquila;

@RestController
@RequestMapping("/webresources/controller/controladorMaquila")
public class ControladorMaquila {
	
	@Autowired
	ServicioMaquila servicioMaquila;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar()throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioMaquila.consultar());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@GetMapping(path= "/consultarMaquilasTipo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarMaquilasTipo(@RequestParam(value = "tipoMaquila") String tipoMaquila )throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioMaquila.consultarMaquilasTipo(tipoMaquila));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody MaquilaDTO maquilaDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioMaquila.crear(maquilaDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar la Maquila ");
    	}
	}

}
