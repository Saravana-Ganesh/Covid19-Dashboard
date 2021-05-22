package com.covid.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.OTPBO;
import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.service.RegistrationService;

@RestController
public class RegistrationController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	RegistrationService registrationService= (RegistrationService)applicationContext.getBean("registrationService");
	@PostMapping(value="/signup",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO signup(@RequestBody RegistrationBO registrationBO) {
		return registrationService.register(registrationBO);		
	} 
	
	@PostMapping(value="/signupOTP",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO verifyOTP(@RequestBody OTPBO otpBO) {
		return registrationService.verifyOTPSignup(otpBO);		
	} 
	
	@PostMapping(value="/reSendSignupOTP",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO reSendSignupOTP(@RequestBody RegistrationBO registrationBO) {
		return registrationService.reSendSignupOTP(registrationBO);		 
	}	
}
   
