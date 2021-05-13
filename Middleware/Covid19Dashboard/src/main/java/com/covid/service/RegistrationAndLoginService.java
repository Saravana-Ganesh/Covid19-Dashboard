package com.covid.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.dao.RegistrationAndLoginDAO;
import com.covid.utils.OTPUtils;
import com.covid.utils.StringUtils;

public class RegistrationAndLoginService {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	public ResponseBO register(RegistrationBO registrationBO) {
		if(StringUtils.isValidUserName(registrationBO.getName()) && StringUtils.isValidEmail(registrationBO.getEmail())
				&& StringUtils.isValidPhone(registrationBO.getPhone()) && registrationBO.getPassword1()!=0) {
			registrationBO.setOtp(OTPUtils.generateOTP());
			RegistrationAndLoginDAO registrationAndLoginDAO = (RegistrationAndLoginDAO)applicationContext.getBean("registrationAndLoginDAO");
			return registrationAndLoginDAO.registerUser(registrationBO);
		}
		ResponseBO responseBO = new ResponseBO();
		responseBO.setStatus(449);
		responseBO.setStatusMessage("Invalid user details");
		return responseBO;
	}
}	
