package com.covid.service;

import com.covid.bo.RegistrationBO;
import com.covid.utils.StringUtils;

public class RegistrationAndLoginService {
	public boolean register(RegistrationBO registrationBO) {
		if(StringUtils.isValidUserName(registrationBO.getName()) && StringUtils.isValidEmail(registrationBO.getEmail())
				&& StringUtils.isValidPhone(registrationBO.getPhone()) && registrationBO.getPassword1()!=0) {
			
		}
		return false;
	}
}	
