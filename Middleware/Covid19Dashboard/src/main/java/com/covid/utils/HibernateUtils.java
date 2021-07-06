package com.covid.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory;
    static {
    	factory = new Configuration().configure("resources//hibernate.cfg.xml").
                buildSessionFactory(); 
    }
    
    //To prevent creating instance at outside of the class
    private HibernateUtils() {
    }
    //Returning common SessionFactory object
    public static SessionFactory getSessionFactory() {        
        return factory;
    }
    
    public static void closeSessionFactory() {
    	factory.close();
    }
}
