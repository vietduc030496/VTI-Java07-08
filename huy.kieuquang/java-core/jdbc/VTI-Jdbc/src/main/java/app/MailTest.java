package app;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {
	public static void main(String[] args) throws ParseException {
		String a = "20-11-1999";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf.parse(a);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		System.out.println(sqlDate);
	}
}
