package com.covid.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.covid.bo.LoginBO;
import com.covid.constants.QueryConstants;
import com.covid.utils.HibernateUtils;

public class LoginDAO {
	
	public boolean validateUser(LoginBO loginBO) {
		Session session =  HibernateUtils.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(QueryConstants.IS_VALID_USER);
			query.setParameter("email",loginBO.getUserEmail());
			query.setParameter("password", loginBO.getPassword());		
			query.setParameter("isActive", 1);
			return !query.getResultList().isEmpty();
		}catch(Exception e) { 
			e.printStackTrace();
			return false;
		}finally {
			session.clear();
			session.close();
		}		
	}	
}
