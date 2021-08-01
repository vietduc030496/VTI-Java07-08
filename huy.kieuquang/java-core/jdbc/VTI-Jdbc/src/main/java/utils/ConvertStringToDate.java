package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ConvertStringToDate {
	public static Date toDate(String stringDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf.parse(stringDate);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		return sqlDate;
	}
}
