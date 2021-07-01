package com.covid.service;

import com.covid.bo.OAuthBO;
import com.covid.bo.ResponseBO;
import com.covid.constants.HttpStatusCodeConstants;
import com.covid.helper.OAuthHelper;
import com.covid.utils.StringUtils;

public class LogoutService {
	public ResponseBO logOutSession(OAuthBO oAuthBO) {
		ResponseBO responseBO = new ResponseBO();
		if(StringUtils.isValidEmail(oAuthBO.getEmail()) && oAuthBO.getKey()!=0){
			Integer removedValue = OAuthHelper.logOutSession(oAuthBO);
			if(removedValue!=null && removedValue.equals(oAuthBO.getKey())) {
				responseBO.setStatus(HttpStatusCodeConstants.OK);
				return responseBO;
			}
			responseBO.setStatus(HttpStatusCodeConstants.BAD_REQUEST);
			return responseBO;
		}		
		responseBO.setStatus(HttpStatusCodeConstants.BAD_REQUEST);
		return responseBO;
	}
}
