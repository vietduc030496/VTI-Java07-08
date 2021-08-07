package service;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailService {
	public void sendMail(String receiveMail) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session mailSession;
		MimeMessage mailMessage;
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		mailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(mailSession);
		
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveMail));
		
		mailMessage.setSubject("Ban da dang ki thanh cong");
		mailMessage.setText("Ban da dang ki thanh cong");
		
		Transport transprot = mailSession.getTransport("smtp");
		transprot.connect("smtp.gmail.com","thinoi987654@gmail.com","thinh12061999");
		transprot.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transprot.close();
	}
}
