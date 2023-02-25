package com.bus.chelpaTex.Service.UtilsImpl;

import java.lang.reflect.Field;

import org.springframework.stereotype.Service;

import com.bus.chelpaTex.Service.Utils.ServiceUtil;

@Service
public class ServiceUtilImpl implements ServiceUtil{

	public void copiarAtributos(Object origen, Object destino) throws IllegalAccessException {
	    Field[] camposOrigen = origen.getClass().getDeclaredFields();
	    Field[] camposDestino = destino.getClass().getDeclaredFields();
	    
	    for (Field campoOrigen : camposOrigen) {
	        for (Field campoDestino : camposDestino) {
	            if (campoOrigen.getName().equals(campoDestino.getName())) {
	                campoOrigen.setAccessible(true);
	                campoDestino.setAccessible(true);
	                Object valor = campoOrigen.get(origen);
	                campoDestino.set(destino, valor);
	                break;
	            }
	        }
	    }
	}
	
}
