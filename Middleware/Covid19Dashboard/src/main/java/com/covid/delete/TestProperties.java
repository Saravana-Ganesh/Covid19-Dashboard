package com.covid.delete;

import java.io.IOException;

import com.covid.bo.EmailBO;
import com.covid.utils.EmailUtils;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		EmailBO emailBO = new EmailBO();
		emailBO.setMailSubject("HI Testing mail.....");
		emailBO.setMailBodyContent("Test Email \n<b>Thanks & Regards<b>,\nSaravana Ganesh V");
		emailBO.setToMailList(new String[] {"saravanaganesh@protonmail.com","saravanaganeshdinesh@gmail.com"});
		EmailUtils.sendEmail(emailBO);
	}
}
