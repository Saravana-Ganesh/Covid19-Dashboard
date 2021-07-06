package com.covid.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.covid.bo.OAuthBO;
import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.QueryConstants;
import com.covid.utils.HibernateUtils;

public class UserInfoDAO {

	public ResponseBO getUserInfo(OAuthBO oAuthBO) {

		Session session =  HibernateUtils.getSessionFactory().openSession();
		ResponseBO responseBO = null;
		try {
			Query query = session.createQuery(QueryConstants.GET_USER_INFO);
			query.setParameter("email", oAuthBO.getEmail());	
			List<RegistrationBO> registrationBOList = query.getResultList();
			if(registrationBOList!=null) {
				responseBO = new ResponseBO();
				responseBO.setRegistrationBOList(registrationBOList);				
			}
			return responseBO;
		}catch(Exception e) {
			e.printStackTrace();
			return responseBO;
		}finally {
			session.clear();
			session.close();
		}		
			
	}

}
