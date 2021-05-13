package com.covid.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory;
    private static Session session;
    
    static {
    	getSessionFactory();
    }
    
    //to disallow creating objects by other classes.
    private HibernateUtils() {
    }
    //SessionFactory object as singleton
    public static synchronized Session getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("resources//hibernate.cfg.xml").
                    buildSessionFactory();
            session =  factory.openSession();
        }
        return session;
    }
}
