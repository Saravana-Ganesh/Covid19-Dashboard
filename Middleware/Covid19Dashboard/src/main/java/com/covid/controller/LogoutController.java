package com.covid.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.service.LogoutService;

@RestController
public class LogoutController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	LogoutService logoutService = (LogoutService)applicationContext.getBean("logoutService");
	@PostMapping(value="/logout",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO logOutSession(@RequestBody OAuthBO oAuthBO) {
		return logoutService.logOutSession(oAuthBO);		
	}	

}
         