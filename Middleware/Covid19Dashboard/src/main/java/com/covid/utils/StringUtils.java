package com.covid.utils;

import java.util.regex.Pattern;

public final class StringUtils {
	private StringUtils() {
		//To prevent creating instance for this class constructor
		//is made as private
	}
	public static String convertStringArrayToString(String...arr) {
		/*
		 * Purpose: To convert String array to normal String with comma seperated 
		 * Time Complexity : O(n)
		 * Auxiliary Space : O(n)
		 */
		StringBuilder stringBuilder  = new StringBuilder();
		for(String str:arr) {
			stringBuilder.append(str+",");
		}
		stringBuilder.setLength(stringBuilder.length()-1);
		return new String(stringBuilder);		
	}
	public static boolean isNotNullOrNotEmpty(String str) {
		/*
		 * Purpose: To Check whether the string is not null and not empty
		 * Time Complexity : O(1)
		 * Auxiliary Space : O(1)
		 */
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
