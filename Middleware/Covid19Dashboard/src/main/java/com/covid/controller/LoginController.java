package com.covid.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.LoginBO;
import com.covid.bo.ResponseBO;
import com.covid.service.LoginService;

@RestController
public class LoginController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	LoginService loginService = (LoginService)applicationContext.getBean("loginService");
	@PostMapping(value="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO login(@RequestBody LoginBO loginBO) {
		return loginService.validateUser(loginBO);		
	}	
}
