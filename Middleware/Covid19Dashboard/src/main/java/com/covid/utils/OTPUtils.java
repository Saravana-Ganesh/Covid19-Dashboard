package com.covid.utils;

import java.util.Random;

public final class OTPUtils {
	private OTPUtils() {
		
	}
	public static int generateOTP() {
		 String numbers = "0123456789";		  	   
	     Random rndm_method = new Random();	  
	     char[] otp = new char[6];	  
	     for (int i = 0; i < 6; i++){	            
	    	 otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
	     }
	     return Integer.parseInt(new String(otp).toString());
	}
}
