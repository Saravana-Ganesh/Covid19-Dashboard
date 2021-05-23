package com.covid.helper;

import com.covid.bo.LoginBO;

public class OAuthHelper {
	
	public static int getOAuthValue(String key) {
		return AuthenticationDataHelper.oAuthMap.get(key);
	}	
	public static void generateOAuth(LoginBO loginBO) {
		String metaData = loginBO.getUserEmail()+"##?"+loginBO.getPassword()+"?##"+java.time.LocalTime.now().toString();
		AuthenticationDataHelper.oAuthMap.put(loginBO.getUserEmail(), metaData.hashCode());		
	}
	
	public static boolean isLoggedIn(String key) {
		return AuthenticationDataHelper.oAuthMap.get(key)!=null;
	}
	
	public static void logOutSession(String key) {
		AuthenticationDataHelper.oAuthMap.remove(key);
	}
}
