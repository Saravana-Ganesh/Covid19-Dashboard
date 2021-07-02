package com.covid.utils;

import java.util.Random;

import com.covid.bo.RegistrationBO;
import com.covid.timer.OTPTimerThread;

public final class OTPUtils {
	private OTPUtils() {
		
	}
	public static int generateOTP() {
		/*
		 * Purpose: To generate 6 digit OTP value
		 * Time Complexity : O(1)
		 * Auxiliary Space : O(1)
		 */
		 String numbers = "0123456789";		  	   
	     Random rndm_method = new Random();	  
	     char[] otp = new char[6];	  
	     for (int i = 0; i < 6; i++){	            
	    	 otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
	     }
	     return Integer.parseInt(new String(otp).toString());
	}
	public static boolean sendOTP(RegistrationBO registrationBO) {
		/*
		 * Purpose: 
		 * 		Create instance for OTPTimerThread & passing OTP details in constructor
		 * 		OTPTimerThread start method calls start() method for invoking a new thread
		 * 		New thread is responsible for sending OTP
		 * Time Complexity : O(1)
		 * Auxiliary Space : O(1)
		 */
		if(StringUtils.isValidEmail(registrationBO.getEmail())){
			//New thread started for sending & managing OTP based on time...
			OTPTimerThread oTPTimerThread = new OTPTimerThread(registrationBO,OTPUtils.generateOTP());
			oTPTimerThread.start();
			return true;
		}		
		return false;
	}
}
