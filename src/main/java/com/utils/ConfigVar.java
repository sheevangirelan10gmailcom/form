package com.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConfigVar {

	public static String path="http://sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/";

	
	
	public static String dateFormatter(String date) {
		 String startDateString = date;
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		   return LocalDate.parse(startDateString, formatter).format(formatter2);
			//return startDateString;
	}
}
