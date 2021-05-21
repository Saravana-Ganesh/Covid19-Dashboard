package com.covid.delete;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.covid.bo.RegistrationBO;
import com.covid.utils.HibernateUtils;

public class TestDAO {
	Session session = HibernateUtils.getSessionFactory().openSession();
	private static RegistrationBO registrationBO = new RegistrationBO();
	public static void main(String[] args) {		
		registrationBO.setEmail("email");
		registrationBO.setName("Saravana");
		registrationBO.setPassword1("kemfke");
		registrationBO.setPhone("98765432210");
		new TestDAO().m1();
	}
	private void m1() {
		try {
			Transaction t1 = session.beginTransaction(); 
			session.save(registrationBO);		
			t1.commit();	
		}catch(Exception e) {
			e.getMessage();
			for(int i=0;i<100;i++) {
				System.out.println("Exception Occured........");
			}			
		}
	}
}
