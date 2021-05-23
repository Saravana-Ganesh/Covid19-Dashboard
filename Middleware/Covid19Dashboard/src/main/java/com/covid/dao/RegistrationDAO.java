package com.covid.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.covid.bo.OTPBO;
import com.covid.bo.RegistrationBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.constants.QueryConstants;
import com.covid.constants.StoredProcedureConstants;
import com.covid.utils.HibernateUtils;

public class RegistrationDAO {	
	public ResponseBO registerUser(RegistrationBO registrationBO) {
		Session session =  HibernateUtils.getSessionFactory().openSession();
		ResponseBO responseBO = new ResponseBO();
		try{
			Transaction t1 = session.beginTransaction(); 
			session.save(registrationBO);
			t1.commit();
			Transaction t2 = session.beginTransaction();		  
		    session.createStoredProcedureCall(StoredProcedureConstants.IDENTITY_USER_DETAIL_MASTER).execute();
		    t2.commit();
			responseBO.setStatus(HttpStatusCodeConstants.CREATED);
			responseBO.setRegistrationBO(registrationBO);
			return responseBO; 
		}catch(Exception e){
			responseBO.setStatus(HttpStatusCodeConstants.CONFLICT);
			return responseBO;
		}finally {
			session.clear();
			session.close();
		}
	}
	public ResponseBO verifyOTPSignup(OTPBO otpBO) {
		Session session =  HibernateUtils.getSessionFactory().openSession();
		ResponseBO responseBO = new ResponseBO();
		Transaction t1 = session.beginTransaction(); 
		try {
			Query query = session.createNativeQuery(QueryConstants.UPDATE_OTP_VERIFICATION_SIGNUP);  
			query.setParameter(1,1);  
			query.setParameter(2,otpBO.getEmail());
			int status = query.executeUpdate();			
			t1.commit();
			if(status==1)
				responseBO.setStatus(HttpStatusCodeConstants.CREATED);
			else
				responseBO.setStatus(HttpStatusCodeConstants.NOT_FOUND);
		}catch(Exception e) {
			e.printStackTrace();
			responseBO.setStatus(HttpStatusCodeConstants.BAD_REQUEST);
		}finally {
			session.clear();
			session.close();
		}		
		return responseBO;
	}
	public boolean checkUserExist(RegistrationBO registrationBO) {
		Session session =  HibernateUtils.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(QueryConstants.IS_EXISTS_IN_USER_DETAIL_MASTER);
			query.setParameter("email", registrationBO.getEmail());	
			//return query.getResultList().iterator().hasNext();
			return !query.getResultList().isEmpty();
		}catch(Exception e) {
			return false;
		}finally {
			session.clear();
			session.close();
		}		
	}
}
