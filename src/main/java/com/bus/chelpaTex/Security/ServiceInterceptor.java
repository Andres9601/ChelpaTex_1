package com.bus.chelpaTex.Security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class ServiceInterceptor implements HandlerInterceptor {
	
	@Autowired
	FirebaseService firebaseService;
	
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		String key = request.getHeader("x-firebase-auth");
		try {
			return firebaseService.authFirebase(key);
			} catch (Exception e) {
				response.setStatus(401);
				response.getWriter().write("La credencial ha caducado o se encuentra invalida");
				response.getWriter().flush();
				response.getWriter().close();
				return false;
			}
			
		}

}
