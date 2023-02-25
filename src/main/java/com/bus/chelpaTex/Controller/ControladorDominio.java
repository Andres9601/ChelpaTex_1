package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.chelpaTex.Service.ServicioDominio;

@RestController
@RequestMapping("/webresources/controller/controladorDominio")
public class ControladorDominio {
	
	@Autowired
	ServicioDominio servicioDominio;
	
	@GetMapping(path= "/consultarTiposItem", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarTiposItem() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioDominio.consultarTiposItem());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}

	}
	
	@GetMapping(path= "/consultarTiposMaquila", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarTiposMaquila() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioDominio.consultarTiposMaquila());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}

	}
	
	
	@GetMapping(path= "/consultarDominiosTipo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultarDominiosTipo(@Param("tipoDominio") String tipoDominio) throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioDominio.consultarDominiosTipo(tipoDominio));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}

	}
	
}
