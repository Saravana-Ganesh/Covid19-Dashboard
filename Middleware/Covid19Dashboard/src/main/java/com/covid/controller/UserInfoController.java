package com.covid.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.service.UserInfoService;

@RestController
public class UserInfoController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	UserInfoService userInfoService = (UserInfoService)applicationContext.getBean("userInfoService");
	
	@PostMapping(value="/profile",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO getUserInfo(@RequestBody OAuthBO oAuthBO) {
		return userInfoService.getUserInfo(oAuthBO);		
	}
}
