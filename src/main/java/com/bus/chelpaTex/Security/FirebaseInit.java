package com.bus.chelpaTex.Security;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInit {
	
	private static FirebaseOptions firebaseOptions;
//	private static final String FIREBASE_DATABASEURL = "https://chelpa-tex-dev.firebaseio.com";
	private static final String FIREBASE_CONFIG = "firebase.json";
		
		public static void inicializacion() throws Exception {
		    try {
		        InputStream serviceAccount = FirebaseInit.class.getClassLoader().getResourceAsStream(FIREBASE_CONFIG);
		        firebaseOptions = new FirebaseOptions.Builder()
		                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		                .build();
		        FirebaseApp.initializeApp(firebaseOptions);
		} catch (Exception e){
			throw new Exception("Fallo al inicializar FirebaseApp");
		}
		
		}
	
	
	

}

