package Ex.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckData {
    public static boolean checkInDate(String birthDate) {
        if (birthDate.trim().equals("")) return true;
        else {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            formater.setLenient(false);
            try {
                Date javaDate = formater.parse(birthDate);
                System.out.println(birthDate + " Hop le.");
            } catch (ParseException e) {
                System.out.println(birthDate + " Khong hop le!");
                return false;
            }
            return true;
        }
    }

    public static boolean checkInPhone(String phone) {
        if (phone.matches("^\\d{7,}+")) return true;
        else {
            System.out.println("So khong ton tai!");
            return false;
        }
    }

    public static boolean checkInMail(String mail) {
        if (mail.matches("^(.+)@(.+)$")) return true;
        else {
            System.out.println("Dinh dang email hong hop le!");
            return false;
        }
    }
}
