package com.covid.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.auth.AuthenticationData;
import com.covid.bo.OTPBO;
import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.dao.RegistrationDAO;
import com.covid.timer.OTPTimer;
import com.covid.utils.OTPUtils;
import com.covid.utils.StringUtils;

public class RegistrationService {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	public ResponseBO register(RegistrationBO registrationBO) {
		//Validating user Input 
		if(StringUtils.isValidUserName(registrationBO.getName()) && StringUtils.isValidEmail(registrationBO.getEmail())
				&& StringUtils.isValidPhone(registrationBO.getPhone()) && registrationBO.getPassword1()!=0) {						
			RegistrationDAO registrationDAO = (RegistrationDAO)applicationContext.getBean("registrationDAO");
			ResponseBO responseBO =  registrationDAO.registerUser(registrationBO);
			//Checking DAO response status && sending otp status
			if(responseBO.getStatus() == HttpStatusCodeConstants.CREATED && this.sendOTP(registrationBO))																
				return responseBO;								
			else
				return responseBO;			
		}
		ResponseBO responseBO = new ResponseBO();
		responseBO.setStatus(449);
		return responseBO;
	}
	public ResponseBO verifyOTPSignup(OTPBO otpBO) {
		Integer otp = AuthenticationData.oAuthOTP.get(otpBO.getEmail());
		if(otp!=null && otp==otpBO.getOtp()) {			
			RegistrationDAO registrationDAO = (RegistrationDAO)applicationContext.getBean("registrationDAO");
			return registrationDAO.verifyOTPSignup(otpBO);			
		}
		ResponseBO responseBO = new ResponseBO();
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);				
		return responseBO;
	}
	public boolean sendOTP(RegistrationBO registrationBO) {
		if(StringUtils.isValidEmail(registrationBO.getEmail())){
			//New thread started for sending & managing OTP based on time...
			OTPTimer otpTimer = new OTPTimer(registrationBO,OTPUtils.generateOTP());
			otpTimer.start();
			return true;
		}		
		return false;
	}
	public ResponseBO reSendSignupOTP(RegistrationBO registrationBO) {
		ResponseBO responseBO = new ResponseBO();
		if(StringUtils.isValidUserName(registrationBO.getName()) && StringUtils.isValidEmail(registrationBO.getEmail())
				&& StringUtils.isValidPhone(registrationBO.getPhone()) && registrationBO.getPassword1()!=0) {
			RegistrationDAO registrationDAO = (RegistrationDAO)applicationContext.getBean("registrationDAO");					
			if(registrationDAO.checkUserExist(registrationBO) && this.sendOTP(registrationBO)){
				responseBO.setStatus(HttpStatusCodeConstants.CREATED);
				return responseBO;
			}
			responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);
			return responseBO;
		}
		responseBO.setStatus(HttpStatusCodeConstants.BAD_REQUEST);
		return responseBO;
	}
}	
