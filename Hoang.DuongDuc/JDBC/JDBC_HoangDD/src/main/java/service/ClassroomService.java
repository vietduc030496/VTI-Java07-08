package service;

import constant.SQLConstant;
import entity.Classroom;
import entity.NumberOfGenderClass;
import utils.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    public List<NumberOfGenderClass> getAmountGender() throws SQLException, IOException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        Statement sta = con.createStatement();
        ResultSet rs = null;
        List<NumberOfGenderClass> numberOfGenderClassList = new ArrayList<>();
        try {
            rs = sta.executeQuery(SQLConstant.SELECT_GENDERS);
            while (rs.next()) {
                NumberOfGenderClass genderClass = new NumberOfGenderClass();
                genderClass.setClassId(rs.getInt("Idclass"));
                genderClass.setClassName(rs.getString("ClassName"));
                genderClass.setNumberOfMale(rs.getInt("num_of_male"));
                genderClass.setNumberOfFemale(rs.getInt("num_of_female"));
                numberOfGenderClassList.add(genderClass);
            }
            rs.close();
            return numberOfGenderClassList;
        } catch (Exception e) {
            return numberOfGenderClassList;
        } finally {
            sta.close();
            con.close();
        }
    }

    public List<Classroom> getAmountStudent() throws SQLException, IOException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        Statement sta = con.createStatement();
        ResultSet rs = null;
        List<Classroom> classrooms = new ArrayList<>();
        try {
            rs = sta.executeQuery(SQLConstant.SELECT_STUDENT_OF_CLASS);
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setClassId(rs.getInt("IDclass"));
                classroom.setAmountStudent(rs.getInt("So_Luong_Sinh_Vien"));
                classrooms.add(classroom);
            }
            rs.close();
            return classrooms;
        } catch (Exception e) {
            return classrooms;
        } finally {
            sta.close();
            con.close();
        }
    }

}
