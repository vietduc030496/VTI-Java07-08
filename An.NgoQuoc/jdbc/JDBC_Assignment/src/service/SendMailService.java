package service;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailService {
	public void sendtext(String mailNhan) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session mailSession;
		MimeMessage mailMessage;
		
		//thiet lap mail server
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		//session
		mailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(mailSession);
		
		//nguoi nhan
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailNhan));
		
		//noi dung
		mailMessage.setSubject("Send Mail From JDBC");
		mailMessage.setText("Đăng ký thành công");
		
		//gửi mail
		Transport transprot = mailSession.getTransport("smtp");
		transprot.connect("smtp.gmail.com","ngoquocan161199@gmail.com","Ngoquocan161199");
		transprot.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transprot.close();
	}
}

