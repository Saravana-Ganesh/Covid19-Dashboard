package com.covid.constants;

public final class QueryConstants {
	private QueryConstants() {
		
	}
	public static final String UPDATE_OTP_VERIFICATION_SIGNUP = "UPDATE "
			+TableConstants.USER_DETAIL_MASTER
			+" set "+TableConstants.USER_DETAIL_MASTER_IS_ACTIVE+"=? "
			+ "WHERE "+TableConstants.USER_DETAIL_MASTER_EMAIL+"=?"; 
}
