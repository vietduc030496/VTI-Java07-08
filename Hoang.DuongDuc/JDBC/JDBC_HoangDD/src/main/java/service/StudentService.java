package service;

import constant.SQLConstant;
import entity.*;
import utils.CheckData;
import utils.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class StudentService {
    static Scanner sc = new Scanner(System.in);

    public static Student inputStudent() {
        System.out.println("Nhap firstname:");
        String fname = sc.nextLine();
        System.out.println("Nhap lastname:");
        String lname = sc.nextLine();
        System.out.println("Nhap gender:");
        String gender = sc.nextLine();
        System.out.println("Nhap ngay thang nam sinh:");
        String bdate;
        while (true) {
            bdate = sc.nextLine();
            if (CheckData.checkInDate(bdate)) break;
        }
        System.out.println("Nhap dia chi:");
        String address = sc.nextLine();
        System.out.println("Nhap SDT:");
        String sphone;
        while (true) {
            sphone = sc.nextLine();
            if (CheckData.checkInPhone(sphone)) break;
        }
        System.out.println("Nhap Email:");
        String mail;
        while (true) {
            mail = sc.nextLine();
            if (CheckData.checkInMail(mail)) break;
        }
        System.out.println("Nhap ID class:");
        int classId = sc.nextInt();
        return new Student(0, fname, lname, gender, bdate, address, sphone, mail, classId);
    }

    public int insertStudent(Student student) throws SQLException, IOException, ClassNotFoundException {
        Connection con;
        PreparedStatement preSta;
        con = DBConnection.getInstance().getConnection();
        preSta = con.prepareStatement(SQLConstant.INSERT_STUDENT);
        preSta.setString(1, student.getFirstName());
        preSta.setString(2, student.getLastName());
        preSta.setString(3, student.getGender());
        preSta.setString(4, student.getDob());
        preSta.setString(5, student.getAddress());
        preSta.setString(6, student.getPhoneNumber());
        preSta.setString(7, student.getEmail());
        preSta.setInt(8, student.getClassId());
        try {
            preSta.execute();
            return preSta.getUpdateCount();
        } catch (Exception e) {
            return 0;
        } finally {
            preSta.close();
            con.close();
        }
    }

    public List<StudentWithClassName> getAllStudents() throws SQLException, IOException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        Statement sta = con.createStatement();
        ResultSet rs = null;
        List<StudentWithClassName> students = new ArrayList<>();
        try {
            rs = sta.executeQuery(SQLConstant.SELECT_STUDENT);
            while (rs.next()) {
                StudentWithClassName st = new StudentWithClassName();
                st.setStudentId(rs.getInt("Idstudent"));
                st.setFirstName(rs.getString("firstName"));
                st.setLastName(rs.getString("lastName"));
                st.setGender(rs.getString("gender"));
                st.setDob(rs.getString("DOB"));
                st.setClassName(rs.getString("ClassName"));
                students.add(st);
            }
            rs.close();
            return students;
        } catch (Exception e) {
            return students;
        } finally {
            sta.close();
            con.close();
        }
    }

    public List<MarkOfStudent> getMarkOfStudent(int id) throws SQLException, IOException, ClassNotFoundException {
        ResultSet rs = null;
        List<MarkOfStudent> marks = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement preSta = null;
        try {
            preSta = con.prepareStatement(SQLConstant.SELECT_TRANSCRIPT);
            preSta.setInt(1, id);
            rs = preSta.executeQuery();
            while (rs.next()) {
                MarkOfStudent mark = new MarkOfStudent();
                mark.setStudentId(rs.getInt("Idstudent"));
                mark.setClassName(rs.getString("ClassName"));
                mark.setSubjectName(rs.getString("subjectName"));
                mark.setMark(rs.getDouble("mark"));
                marks.add(mark);
            }
            rs.close();
            return marks;
        } catch (Exception e) {
            return marks;
        } finally {
            preSta.close();
            con.close();
        }
    }

    public StudentWithAVGMark getMarkAVGOfStudent(int id) throws SQLException, IOException, ClassNotFoundException {
        ResultSet rs = null;
        StudentWithAVGMark studentWithAVGMark = new StudentWithAVGMark();
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement preSta = null;
        try {
            preSta = con.prepareStatement(SQLConstant.STORE_PROCEDURE_AVG);
            preSta.setInt(1, id);
            rs = preSta.executeQuery();
            if (rs.next()) {
                studentWithAVGMark.setStudentId(rs.getInt("Idstudent"));
                studentWithAVGMark.setFirstName(rs.getString("firstName"));
                studentWithAVGMark.setLastName(rs.getString("lastName"));
                studentWithAVGMark.setGender(rs.getString("gender"));
                studentWithAVGMark.setDob(rs.getString("DOB"));
                studentWithAVGMark.setMarkAVG(rs.getDouble("DiemTB"));
            }
            return studentWithAVGMark;
        } catch (Exception e) {
            return studentWithAVGMark;
        } finally {
            rs.close();
            preSta.close();
            con.close();
        }
    }

    public TuitionOfStudent getTuition(int id) throws SQLException, IOException, ClassNotFoundException {
        ResultSet rs = null;
        TuitionOfStudent tuition = new TuitionOfStudent();
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement preSta = null;
        try {
            preSta = con.prepareStatement(SQLConstant.FUNCTION_SUM_CREDIT);
            preSta.setInt(1, id);
            rs = preSta.executeQuery();
            if (rs.next()) {
                tuition.setStudentId(rs.getInt("IDstudent"));
                tuition.setTuition(rs.getInt("TongHocPhi_VND"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            preSta.close();
            con.close();
        }
        return tuition;
    }

    public static void sendMailText(String email) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        //setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        //get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        mailMessage.setSubject("Thong bao dang ky tai khoan he thong");
        mailMessage.setText("Ban da dang ky tai khoan student thanh cong");

        //Send mail
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "deokhwang3ne@gmail.com", "Chip123456789");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }
}
