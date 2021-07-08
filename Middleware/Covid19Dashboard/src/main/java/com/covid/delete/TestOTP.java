package com.covid.delete;

import java.util.Random;

public class TestOTP {
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
	     if(otp[0]=='0') {
	    	 otp[0] = '7';
	     }
	     String s = Integer.parseInt(new String(otp))+"";
	     if(s.length()<6) {
	    	 System.out.println();
	     }
	     return Integer.parseInt(new String(otp));
	}
	public static void main(String[] args) {
		
		int count  = 0;
		for(int i=0;i<1000;i++) {			
			int a = generateOTP();
			System.out.println(a);
			String s =a+"";
			if(s.length()<6) {
				++count;
				System.out.println(s+"-----"+s.length());
			}
		}
		System.out.println(count+" times wrong otp");
	}
}
