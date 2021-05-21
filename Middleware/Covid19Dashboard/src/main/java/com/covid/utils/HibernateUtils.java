package com.covid.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory;
    static {
    	getSessionFactory();
    }
    
    //to disallow creating objects by other classes.
    private HibernateUtils() {
    }
    //SessionFactory object as singleton
    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("resources//hibernate.cfg.xml").
                    buildSessionFactory();            
        }
        return factory;
    }
}
