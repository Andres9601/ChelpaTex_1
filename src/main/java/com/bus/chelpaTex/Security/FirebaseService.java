package com.bus.chelpaTex.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

@Service
public class FirebaseService {
	
	@Autowired
	FirebaseInit firebaseInit;
	
	
	public String createUsers(String email, String password) throws FirebaseAuthException {
		
		firebaseInit.inicializacion();
		CreateRequest request = new CreateRequest()
			    .setEmail(email)
			    .setEmailVerified(true)
			    .setPassword(password)
			    /*.setPhoneNumber("+11234567890")
			    .setDisplayName("John Doe")
			    .setPhotoUrl("http://www.example.com/12345678/photo.png")
			    .setDisabled(false)*/;

			UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
			System.out.println("Successfully created new user: " + userRecord.getUid());
			//userRecord.getTokensValidAfterTimestamp();
			return userRecord.getUid();
			}
		
	
	
	public  FirebaseToken verifyToken (String idToken) throws FirebaseException{
		try {
		firebaseInit.inicializacion();
		FirebaseToken respuesta = FirebaseAuth.getInstance().verifyIdToken(idToken);
			return respuesta;
		}catch (Exception e) {
			return null;
		}
			
	}
	
   public Boolean authFirebase (String token) throws FirebaseException {
	   FirebaseToken respuesta = verifyToken(token);
	   try {
	   if(respuesta != null) {
		   return true;
		   }
	   	}catch(Exception e) {
	   	}
	return null;
	
   
   }


}
