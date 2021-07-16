package constant;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dung.trananh
 */
public class CheckData {

    public static boolean checkInputDateData(String birthdate) {
        if (birthdate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(birthdate);
                System.out.println(birthdate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(birthdate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    public static boolean checkInputPhoneData(String phone) {
        if (phone.matches("^\\d{7}$")) {
            return true;
        } else {
            System.out.println("Wrong phone");
            return false;
        }
    }

    public static boolean checkInputEmailData(String email) {
        if (email.matches("\"^(.+)@(.+)$\"")) {
            return true;
        } else {
            System.out.println("Wrong email");
            return false;
        }
    }
        
}
