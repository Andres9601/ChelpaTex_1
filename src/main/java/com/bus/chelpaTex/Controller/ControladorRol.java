package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.chelpaTex.Service.ServicioRol;

@RestController
@RequestMapping("/webresources/controller/controladorRol")
public class ControladorRol {
	
	@Autowired
	ServicioRol servicioRol;
	
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioRol.consultar());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}

}
