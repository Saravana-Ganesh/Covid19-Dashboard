package com.covid.constants;

import com.covid.config.PropertiesConfig;

public final class EmailConstants {
	public static final String EMAIL_USERNAME = PropertiesConfig.getProperties().getProperty("userName");
	public static final String EMAIL_APP_PASSWORD =  PropertiesConfig.getProperties().getProperty("appPassword");
	
	
}
