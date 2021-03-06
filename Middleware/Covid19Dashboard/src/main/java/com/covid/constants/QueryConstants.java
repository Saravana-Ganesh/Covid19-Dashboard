package com.covid.constants;

public final class QueryConstants {
	private QueryConstants() {
		
	}
	public static final String UPDATE_OTP_VERIFICATION_SIGNUP = "UPDATE "
			+TableConstants.USER_DETAIL_MASTER
			+" set "+TableConstants.USER_DETAIL_MASTER_IS_ACTIVE+"=? "
			+ "WHERE "+TableConstants.USER_DETAIL_MASTER_EMAIL+"=?";
	
	public static final String IS_EXISTS_IN_USER_DETAIL_MASTER = "from RegistrationBO "
			+ " where email=:email";
	
	public static final String GET_USER_INFO = " select name, email, phone from RegistrationBO"
			+ " where email=:email";
	
	public static final String IS_VALID_USER = "from RegistrationBO "
			+ " where email=:email and password=:password and isActive=:isActive";
	
	public static final String GET_COVID_CASE_COUNT = ""
			+ "SELECT "+TableConstants.COVID_DATA_MASTER_MONTH_VALUES+","
			+TableConstants.COVID_DATA_MASTER_CASE_COUNT+
			","+TableConstants.COVID_DATA_MASTER_CITY+
			" FROM "+TableConstants.COVID_DATA_MASTER;
}
