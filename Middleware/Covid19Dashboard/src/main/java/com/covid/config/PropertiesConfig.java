package com.covid.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesConfig {	
	private static final String RESOURCE_NAME = "resources//email.properties";	
	private static Properties properties = new Properties();
	private PropertiesConfig() {
		//For Singleton configuration
	}
	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();		
		try(InputStream resourceStream = loader.getResourceAsStream(PropertiesConfig.RESOURCE_NAME)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Properties getProperties() {
		return properties;
	}
}
