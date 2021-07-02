package com.covid.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.bo.OTPBO;
import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.dao.RegistrationDAO;
import com.covid.helper.AuthenticationDataHelper;
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
			if(responseBO.getStatus() == HttpStatusCodeConstants.CREATED && OTPUtils.sendOTP(registrationBO))																
				return responseBO;								
			else
				return responseBO;			
		}
		
		ResponseBO responseBO = new ResponseBO();
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);
		return responseBO;
	}
	public ResponseBO verifyOTPSignup(OTPBO otpBO) {
		Integer otp = AuthenticationDataHelper.oAuthOTP.get(otpBO.getEmail());
		
		if(otp!=null && otp==otpBO.getOtp()) {			
			RegistrationDAO registrationDAO = (RegistrationDAO)applicationContext.getBean("registrationDAO");
			return registrationDAO.verifyOTPSignup(otpBO);			
		}
		
		ResponseBO responseBO = new ResponseBO();
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);				
		return responseBO;
	}	
	public ResponseBO reSendSignupOTP(RegistrationBO registrationBO) {
		ResponseBO responseBO = new ResponseBO();
		
		if(StringUtils.isValidUserName(registrationBO.getName()) && StringUtils.isValidEmail(registrationBO.getEmail())
				&& StringUtils.isValidPhone(registrationBO.getPhone()) && registrationBO.getPassword1()!=0) {
		
			RegistrationDAO registrationDAO = (RegistrationDAO)applicationContext.getBean("registrationDAO");					
			
			if(registrationDAO.checkUserExist(registrationBO) && OTPUtils.sendOTP(registrationBO)){
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
