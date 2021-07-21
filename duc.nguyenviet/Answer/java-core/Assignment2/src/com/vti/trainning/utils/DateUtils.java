package com.vti.trainning.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

	public static final String DDMMYYYY = "dd/MM/yyyy";

	public static boolean checkValidDate(String date) {
		try {
			SimpleDateFormat dfm = new SimpleDateFormat(DDMMYYYY);
			dfm.parse(date);
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
