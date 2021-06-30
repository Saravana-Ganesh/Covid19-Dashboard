package com.covid.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.service.HomeService;
import com.covid.service.RegistrationService;

@RestController
public class HomePageController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	HomeService homeService = (HomeService)applicationContext.getBean("homeService");
	@PostMapping(value="/home")
	public ResponseBO getHomeData(@RequestBody OAuthBO oAuthBO){
		return homeService.getHomeData(oAuthBO);
	}
}
