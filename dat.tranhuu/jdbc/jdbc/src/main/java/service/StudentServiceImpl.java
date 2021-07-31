package service;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import constant.MailConfig;
import dao.impl.StudentDAO;
import dao.impl.StudentDtoDAO;
import dto.StudentDto;
import entity.Student;

public class StudentServiceImpl{
	
	private StudentDAO studentDAO;
	private StudentDtoDAO studentDtoDAO;
	
	public StudentServiceImpl (StudentDAO studentDAO,StudentDtoDAO studentDtoDAO) {
		this.studentDAO=studentDAO;
		this.studentDtoDAO=studentDtoDAO;
	}

	
	public Student saveOrUpdate(Student student) {
		if(student!=null) {
			if(student.getId()!=null) {
				return null; 
			}else {
				Long id = this.studentDAO.save(student);
				if(id!=null) {
					student= this.studentDAO.findOne(id);
					this.sendMail(student);
					return student;
				}
				return null;
			}
		}else {
			return null;
		}
	}
	
	
	public void sendMail(Student student) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.user", MailConfig.EMAIL);
        props.put("mail.smtp.password", MailConfig.PASSWORD);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.EMAIL, MailConfig.PASSWORD);
            }
        });
        
        try {
            MimeMessage msg = new MimeMessage(session);
            
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			
			msg.setSubject("Testing Subject");
            msg.setText("Welcome to gpcoder.com");
            msg.setFrom(new InternetAddress("no_reply@example.com", "JDBC_VTI"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject("cảm ơn bạn " +student.getName() +" đã tham gia" , "UTF-8");

			msg.setText("Chúng tôi rất vui khi bạn đã tham gia lớp học của chúng tôi", "UTF-8");

			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(student.getEmail(),false));
            
            Transport.send(msg);
 
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> findALl(){
		return this.studentDAO.findAll();
	}
	
	public List<Student> findByLop(long id){
		return this.studentDAO.findByLop(id);
	}
	
	public List<StudentDto> findAllDto(){
		return this.studentDtoDAO.findAll();
	}
	
	public List<Student> findByScoreSubject(Long id, float score) {
		return  this.studentDAO.findByScoreSubject(id, score);
	}
	public List<Student> findByTop5ScoreSubject(Long id) {
		return  this.studentDAO.findByTopScore(id);
	}
	
	public Integer getTotal(long id) {
		return this.studentDAO.getTotal(id);
	}
}
