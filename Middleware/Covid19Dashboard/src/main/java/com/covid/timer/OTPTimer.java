package com.covid.timer;

import com.covid.auth.AuthenticationData;
import com.covid.bo.EmailBO;
import com.covid.bo.RegistrationBO;
import com.covid.utils.EmailUtils;

public class OTPTimer extends Thread {
	RegistrationBO registrationBO;
	int otp;
	EmailBO emailBO;
	public OTPTimer() {
		
	}
	public OTPTimer(RegistrationBO registrationBO,int otp) {
		this.registrationBO = registrationBO;
		this.otp = otp;
	}
	public void run() {
		AuthenticationData.oAuthOTP.put(this.registrationBO.getEmail(),otp);
		EmailBO emailBO = EmailUtils.generateOTPContentForRegistration(this.registrationBO,this.otp);
		EmailUtils.sendEmail(emailBO);
		destroyOTP();
	}
	public void destroyOTP() {
		try {
			Thread.sleep(1000*60*5);
			AuthenticationData.oAuthOTP.remove(this.registrationBO.getEmail());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
