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

import com.bus.chelpaTex.DTO.RegistroDTO;
import com.bus.chelpaTex.Security.FirebaseService;
import com.bus.chelpaTex.Service.ServicioUsuario;
import com.google.firebase.auth.FirebaseAuthException;

@RestController
@RequestMapping("/webresources/controller/controladorUsuario")
public class ControladorUsuario {
	
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@Autowired
	FirebaseService firebaseService;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioUsuario.consultar());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@PostMapping("/createUserFirebase")
    public ResponseEntity<?> createUserFirebase(@RequestParam(value="email") String email, @RequestParam(value="password")String password ) throws FirebaseAuthException {
    	try {
    	return ResponseEntity.ok(firebaseService.createUsers(email, password));
    	}
    	catch (Exception e)
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al crear usuario" + e);
    	}
	}
	
	
	@PostMapping(path = "/registrarUsuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUserFirebase(@RequestBody RegistroDTO registroDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioUsuario.registrarUsuario(registroDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede registrar el usuario ");
    	}
	}
}
