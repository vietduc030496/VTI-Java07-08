package ToolJDBC.utils;

import java.util.Properties;
import javax.mail.*;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public MailUtils(String email) {
		super();
		// TODO Auto-generated constructor stub
		final String username = "jdbc.email@gmail.com";
		final String password = "homnaymuakhong?";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); 
//		prop.put("mail.smtp.socketFactory.port", "465");
//		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("helo@ddss.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email+", hieuhamhocpro@gmail.com, nvhieu.dev@yahoo.com"));
			message.setSubject("Testing Gmail SSL");
			message.setText("chao anh/chi anh chi vua dang ky dich vu mail, khac day " + "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
