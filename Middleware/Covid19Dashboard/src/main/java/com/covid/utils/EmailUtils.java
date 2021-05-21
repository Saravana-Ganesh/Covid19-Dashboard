package com.covid.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.covid.bo.EmailBO;
import com.covid.bo.RegistrationBO;
import com.covid.constants.EmailConstants;

public final class EmailUtils {
	private EmailUtils() {
		
	}
	public static boolean sendEmail(EmailBO emailBO) {
		Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EmailConstants.EMAIL_USERNAME,EmailConstants.EMAIL_APP_PASSWORD);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailConstants.EMAIL_USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(StringUtils.convertStringArrayToString(emailBO.getToMailList()))
            );
            message.setSubject(emailBO.getMailSubject());
            message.setText(emailBO.getMailBodyContent());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
		return true;
	}
	public static EmailBO generateOTPContentForRegistration(RegistrationBO registrationBO,int otp) {
		EmailBO emailBO = new EmailBO();
		emailBO.setMailSubject("One Time Password (OTP) for Registration in Covid Dashboard");
		emailBO.setMailBodyContent("Dear "+registrationBO.getName()+", \nYour One Time Password (OTP) for Registration in Covid Dashboard is "+otp);
		emailBO.setToMailList(new String[]{registrationBO.getEmail()});
		return emailBO;
	}
}
