package com.bus.chelpaTex.Controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.chelpaTex.DTO.ActualizarDisenoDTO;
import com.bus.chelpaTex.DTO.DisenoDTO;
import com.bus.chelpaTex.DTO.NuevoDisenoDTO;
import com.bus.chelpaTex.Service.ServicioDiseno;

@RestController
@RequestMapping("/webresources/controller/controladorDiseno")
public class ControladorDiseno {
	
	@Autowired
	ServicioDiseno servicioDiseno;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar(@RequestParam(value = "idUsuario") String idUsuario) throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioDiseno.consultar(idUsuario));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody DisenoDTO disenoDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioDiseno.crear(disenoDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar el diseno ");
    	}
	}
	
	@PostMapping(path = "/nuevoDiseno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> nuevoDiseno (@RequestBody NuevoDisenoDTO nuevoDisenoDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioDiseno.nuevoDiseno(nuevoDisenoDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede guardar el diseno ");
    	}
	}
	
	@PutMapping(path = "/actualizarDiseno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarDiseno (@RequestBody ActualizarDisenoDTO actualizarDisenoDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioDiseno.actualizarDiseno(actualizarDisenoDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede actualizar el diseno ");
    	}
	}
	
	@PutMapping(path = "/actualizarDisenoMg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarDisenoMg (@RequestBody DisenoDTO DisenoDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioDiseno.actualizarDisenoMg(DisenoDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede actualizar el diseno ");
    	}
	}

	@DeleteMapping(path = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam(value="idDiseno") Long idDiseno) {
    	try {
    		return ResponseEntity.ok(servicioDiseno.eliminar(idDiseno));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede eliminar el diseno ");
    	}
	}

}
