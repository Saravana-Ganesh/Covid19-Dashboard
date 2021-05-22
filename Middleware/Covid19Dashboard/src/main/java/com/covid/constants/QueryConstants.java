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
}
