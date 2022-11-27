package com.pos.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.time.Month;
import java.time.LocalDate;

public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	public static final String DATE_PATTERN_SERVICE = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN_SERVICE_NO_SECONDS = "yyyy-MM-dd HH:mm";
	public static final String DATE_PATTERN_dd_MM_YYYY = "dd/MM/YYYY";

	public static final String TIME_PATTERN_HH_mm = "HH:mm";

	public static Date getCurrentDate() {
		log.info("inside getCurrentDate method - DateUtil");
		DateTime jodaDate = new DateTime(DateTimeZone.forID("Asia/Kolkata"));
		java.util.Date date = jodaDate.toDate();
		return date;
	}

	public static String convertDateToGivenStringPattern(Date date, String pattern) {
		log.info("inside convertDateToString method - DateUtil");
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String strDate = dateFormat.format(date);
		return strDate;
	}

	public static Date convertStringToDate(final String str) {
		try {
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN_dd_MM_YYYY);
			return DATE_FORMAT.parse(str);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return null;
	}

	public static void getDayMonthYear(String date) {

		// Get an instance of LocalTime
		// from date
		LocalDate currentDate = LocalDate.parse(date);

		// Get day from date
		int day = currentDate.getDayOfMonth();

		// Get month from date
		Month month = currentDate.getMonth();

		// Get year from date
		int year = currentDate.getYear();

		// Print the day, month, and year
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);
		System.out.println("Year: " + year);
	}
	
	public static Integer getDay(String date) {
		LocalDate currentDate = LocalDate.parse(date);
		int day = currentDate.getDayOfMonth();
		return day;
	}
	
	public static Integer getYear(String date) {
		LocalDate currentDate = LocalDate.parse(date);
		int year = currentDate.getYear();
		return year;
	}
	
	
	public static String getMonth(String date) {
		LocalDate currentDate = LocalDate.parse(date);
		Month month = currentDate.getMonth();
		return month.toString();
	}
	
	
	

	public static void main(String[] args) {
		// System.out.println(convertStringToDate("17-Mar-2022"));
		
		System.out.println(getDay("2022-11-18"));
		System.out.println(getYear("2022-11-18"));
		
		System.out.println(getMonth("2022-01-18"));
		System.out.println(getMonth("2022-02-18"));
		System.out.println(getMonth("2022-03-18"));
		System.out.println(getMonth("2022-04-18"));
		System.out.println(getMonth("2022-05-18"));
		System.out.println(getMonth("2022-06-18"));
		System.out.println(getMonth("2022-07-18"));
		System.out.println(getMonth("2022-08-18"));
		System.out.println(getMonth("2022-09-18"));
		System.out.println(getMonth("2022-10-18"));
		System.out.println(getMonth("2022-11-18"));
		System.out.println(getMonth("2022-12-18"));
		// System.out.println(getCurrentDate());
	}

}
