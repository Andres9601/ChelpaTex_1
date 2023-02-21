package com.bus.chelpaTex.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServiceInterceptorAppConfig implements WebMvcConfigurer  {

	@Autowired
	ServiceInterceptor serviceInterceptors;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(serviceInterceptors)
		.excludePathPatterns(
				"/**/webresources/controller/controladorUsuario/registrarUsuario/",
				"/**/webresources/controller/controladorUsuario/consultar/",
				"/**/webresources/controller/",
				"/**/*"
				

				

				

		);
		}

		
}
