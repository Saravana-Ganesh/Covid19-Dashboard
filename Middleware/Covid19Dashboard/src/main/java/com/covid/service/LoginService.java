package com.covid.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.bo.LoginBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.dao.LoginDAO;
import com.covid.helper.OAuthHelper;

public class LoginService {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	public ResponseBO validateUser(LoginBO loginBO) {
		ResponseBO responseBO = new ResponseBO();
		LoginDAO loginDAO = (LoginDAO)applicationContext.getBean("loginDAO");
		if(loginDAO.validateUser(loginBO)) {
			OAuthHelper.generateOAuth(loginBO);
			responseBO.setStatus(HttpStatusCodeConstants.OK);
			responseBO.setTokenID(OAuthHelper.getOAuthValue(loginBO.getUserEmail()));
			return responseBO;
		}
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);
		return responseBO;
	}

}
