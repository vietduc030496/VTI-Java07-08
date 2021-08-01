package utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendMail {
	public static void sendText(String email) throws AddressException, MessagingException {
	    Properties mailServerProperties;
	    Session getMailSession;
	    MimeMessage mailMessage;
	 
	    mailServerProperties = System.getProperties();
	    mailServerProperties.put("mail.smtp.auth", "true");
	    mailServerProperties.put("mail.smtp.starttls.enable", "true");
	    mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
	    mailServerProperties.put("mail.smtp.port", "587");
	 
	    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	    mailMessage = new MimeMessage(getMailSession);
	 
	    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	 
	    // Bạn có thể chọn CC, BCC
//	    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
	 
	 
	    mailMessage.setSubject("Send gmail from Java");
	    mailMessage.setText("Ban da them thanh cong");
	 
	    Transport transport = getMailSession.getTransport("smtp");
	 
	    transport.connect("smtp.gmail.com", "chelsea_hieuh7@gmail.com", "Trunghieunguyen2903"); 
	    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    transport.close();
	  }
}
