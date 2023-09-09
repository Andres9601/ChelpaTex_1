package com.bus.chelpaTex.Service.Utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public interface ServiceUtil {

	@Qualifier("ServiceUtilImpl")
	public void copiarAtributos(Object origen, Object Destino) throws IllegalAccessException;
}
