package service;

import constant.SQLConstant;
import entity.MarkOfStudent;
import entity.SubjectWithMark;
import utils.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectService {
    public List<SubjectWithMark> getMarkOfSubjectMin() throws SQLException, IOException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        Statement sta = con.createStatement();
        ResultSet rs = null;
        List<SubjectWithMark> minMarks = new ArrayList<>();
        try {
            rs = sta.executeQuery(SQLConstant.SELECT_MIN_OF_MARK_STUDENT);
            while (rs.next()) {
                SubjectWithMark minMarkOfStudent = new SubjectWithMark();
                minMarkOfStudent.setSubjectId(rs.getInt("IDsubject"));
                minMarkOfStudent.setSubjectName(rs.getString("subjectName"));
                minMarkOfStudent.setMinOfMark(rs.getDouble("MinOfMark"));
                minMarkOfStudent.setStudentId(rs.getInt("Idstudent"));
                minMarkOfStudent.setFirstName(rs.getString("firstName"));
                minMarkOfStudent.setLastName(rs.getString("lastName"));
                minMarkOfStudent.setGender(rs.getString("gender"));
                minMarkOfStudent.setDob(rs.getString("DOB"));
                minMarks.add(minMarkOfStudent);
            }
            rs.close();
            return minMarks;
        } catch (Exception e) {
            return minMarks;
        } finally {
            sta.close();
            con.close();
        }
    }

    public List<SubjectWithMark> getMarkTop5OfSubject(int id) throws SQLException, IOException, ClassNotFoundException {
        ResultSet rs = null;
        List<SubjectWithMark> topMarks = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement preSta = null;
        try {
            preSta = con.prepareStatement(SQLConstant.STORE_PROCEDURE_TOP_5);
            preSta.setInt(1, id);
            rs = preSta.executeQuery();
            while (rs.next()) {
                SubjectWithMark topMark = new SubjectWithMark();
                topMark.setSubjectId(rs.getInt("IDsubject"));
                topMark.setSubjectName(rs.getString("subjectName"));
                topMark.setStudentId(rs.getInt("Idstudent"));
                topMark.setFirstName(rs.getString("firstName"));
                topMark.setLastName(rs.getString("lastName"));
                topMark.setGender(rs.getString("gender"));
                topMark.setDob(rs.getString("DOB"));
                topMark.setMark(rs.getDouble("mark"));
                topMarks.add(topMark);
            }
            rs.close();
            return topMarks;
        } catch (Exception e) {
            return topMarks;
        } finally {
            preSta.close();
            con.close();
        }
    }

}
