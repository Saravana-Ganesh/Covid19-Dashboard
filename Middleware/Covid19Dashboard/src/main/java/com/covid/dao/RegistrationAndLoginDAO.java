package com.covid.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.utils.HibernateUtils;

public class RegistrationAndLoginDAO {	
	private static Session session =  HibernateUtils.getSessionFactory();
	public ResponseBO registerUser(RegistrationBO registrationBO) {
		ResponseBO responseBO = new ResponseBO();
		try {
			Transaction t1 = session.beginTransaction(); 
			session.save(registrationBO);		
			t1.commit();	
			responseBO.setStatus(HttpStatusCodeConstants.CREATED);
			responseBO.setRegistrationBO(registrationBO);
			responseBO.setStatusMessage("Created");
			return responseBO; 
		}catch(Exception e){
			responseBO.setStatus(HttpStatusCodeConstants.CONFLICT);
			responseBO.setStatusMessage("Conflict");
			return responseBO;
		}
	}
}
