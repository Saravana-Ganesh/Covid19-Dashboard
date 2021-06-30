package com.covid.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.covid.bo.CovidDataBO;
import com.covid.constants.QueryConstants;
import com.covid.utils.HibernateUtils;

public class HomeDAO {
	public List<Object[]> getCaseCount() {
		try(Session session =  HibernateUtils.getSessionFactory().openSession()) {
			Query query = session.createNativeQuery(QueryConstants.GET_COVID_CASE_COUNT);				
			List list = query.getResultList();			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
		
	}
}
