package com.covid.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.bo.LoginBO;
import com.covid.bo.ResponseBO;

@RestController
public class LoginController {
	@PostMapping(value="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBO login(@RequestBody LoginBO loginBO) {
		//return registrationService.reSendSignupOTP(registrationBO);
		return null;
	}	
}
