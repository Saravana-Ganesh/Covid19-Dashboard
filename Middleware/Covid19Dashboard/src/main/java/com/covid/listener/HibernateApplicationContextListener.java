package com.covid.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.covid.utils.HibernateUtils;

public class HibernateApplicationContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/*
		 * Purpose: To load Hibernate session factory object in JVM memory
		 */
		try {
			Class.forName("com.covid.utils.HibernateUtils");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtils.closeSessionFactory();

	}

}
