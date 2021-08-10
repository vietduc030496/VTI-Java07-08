package com.vti.jdbc.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.vti.jdbc.constant.MailConstant;

public class MailUtils {
	public void sendMail(String mail) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;

		// Step1: setup Mail Server
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		// Step2: get Mail Session
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);

		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

		mailMessage.setSubject("Demo send mail from Java");
		mailMessage.setText("You inserted successfully !! ");

		// Step3: Send mail
		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", MailConstant.NAME_MAIL,MailConstant.PASSWORD_MAIL );
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
}
