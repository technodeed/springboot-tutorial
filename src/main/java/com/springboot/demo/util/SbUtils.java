package com.springboot.demo.util;

import java.util.Calendar;

public class SbUtils {
	
	public static Calendar createDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);   
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		return cal;
	}
}
