package com.covid.utils;

import java.util.regex.Pattern;

public final class StringUtils {
	private StringUtils() {
		
	}
	public static String convertStringArrayToString(String...arr) {
		StringBuilder stringBuilder  = new StringBuilder();
		for(String str:arr) {
			stringBuilder.append(str+",");
		}
		stringBuilder.setLength(stringBuilder.length()-1);
		return new String(stringBuilder);		
	}
	public static boolean isNullOrEmpty(String str) {
		return str!=null && !str.equals("");		
	}
	public static boolean isValidEmail(String email) {
		if (email == null) 
            return false; 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";                   
        return Pattern.compile(emailRegex).matcher(email).matches(); 
    } 
	public static boolean isValidPhone(String phone) {
		return phone!=null && phone.length()==10;
	}
	public static boolean isValidUserName(String name) {
		return name!=null && name.length()>=3;
	}
}
