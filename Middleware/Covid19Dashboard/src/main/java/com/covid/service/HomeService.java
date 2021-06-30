package com.covid.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.dao.HomeDAO;
import com.covid.helper.OAuthHelper;

public class HomeService {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	public ResponseBO getHomeData(OAuthBO oAuthBO){
		ResponseBO responseBO = new ResponseBO();
		if(OAuthHelper.isLoggedIn(oAuthBO)) {
			HomeDAO homeDAO = (HomeDAO)applicationContext.getBean("homeDAO");
			List<Object[]> list = homeDAO.getCaseCount();
			responseBO.setResults(list);
			responseBO.setStatus(HttpStatusCodeConstants.OK);
			return responseBO;
		}
		responseBO.setStatus(HttpStatusCodeConstants.UNAUTHORIZED);
		return responseBO;
	}
}
