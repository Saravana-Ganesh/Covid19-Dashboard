package com.covid.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.covid.bo.RegistrationBO;
import com.covid.service.RegistrationAndLoginService;
 
@RestController
public class RegistrationAndLoginController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	@PostMapping(value="/signup",produces = MediaType.APPLICATION_JSON_VALUE)
	public void signup(@RequestBody RegistrationBO registrationBO) {
		RegistrationAndLoginService registrationAndLoginService= (RegistrationAndLoginService)applicationContext.getBean("registrationAndLoginService");
		registrationAndLoginService.register(registrationBO);
	} 
}
   
