package com.covid.helper;

import com.covid.bo.LoginBO;
import com.covid.bo.OAuthBO;

public class OAuthHelper {
	
	public static int getOAuthValue(String key) {
		return AuthenticationDataHelper.oAuthMap.get(key);
	}	
	public static void generateOAuth(LoginBO loginBO) {
		String metaData = loginBO.getUserEmail()+"##?"+loginBO.getPassword()+"?##"+java.time.LocalTime.now().toString();
		AuthenticationDataHelper.oAuthMap.put(loginBO.getUserEmail(), metaData.hashCode());		
	}
	
	public static boolean isLoggedIn(OAuthBO oAuthBO) {
		try {
			return AuthenticationDataHelper.oAuthMap.get(oAuthBO.getEmail())==oAuthBO.getKey();
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	public static Integer logOutSession(OAuthBO oAuthBO) {
		return AuthenticationDataHelper.oAuthMap.remove(oAuthBO.getEmail());
	}
}
