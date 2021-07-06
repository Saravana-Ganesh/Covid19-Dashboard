package com.covid.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.dao.LoginDAO;
import com.covid.dao.UserInfoDAO;
import com.covid.helper.OAuthHelper;

public class UserInfoService {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	
	public ResponseBO getUserInfo(OAuthBO oAuthBO) {
		
		ResponseBO responseBO = new ResponseBO();
		UserInfoDAO userInfoDAO = (UserInfoDAO)applicationContext.getBean("userInfoDAO");
		
		if(OAuthHelper.isLoggedIn(oAuthBO)) {
			responseBO = userInfoDAO.getUserInfo(oAuthBO);
			responseBO.setStatus(HttpStatusCodeConstants.OK);
			
			return responseBO;
		}
		
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);
		return responseBO;
	}

}
