package Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {
    public static boolean checkDate(String s) {
        return s.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
    }

    public static boolean checkPhone(String s) {
        return Pattern.matches("[0-9]{7}", s);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean checkMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return ((Matcher) matcher).find();
    }
}
