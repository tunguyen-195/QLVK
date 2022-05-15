package com.qlvk.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

	public static final String DATE_TIME = "yyyyMMddHHmmssSSS";
	public static final String DATE_TIME_DISPLAY = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_TIME_DISPLAY_2 = "dd/MM/yyyy HH:mm:ss";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYY_MM_DD = "yyyy/MM/dd";
	public static final String DDMMYYYY = "ddMMyyyy";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final Date convertStringtoDate(String date, String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(date);

	}

	public static final String getTimestamp() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME);
		return format.format(now);
	}

	public static final Timestamp getFormatTimestamp() {
		Date now = new Date();
		return new Timestamp(now.getTime());
	}

	public static final Timestamp getFormatTimestamp(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DDMMYYYY);
			Date parsedDate = dateFormat.parse(date);
			return new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static final String getCurrentDate(String dateFormat) {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(now);
	}

	public static final String format(String date, String from, String to) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(from);
			Date d = format.parse(date);
			format.applyPattern(to);
			return format.format(d);
		} catch (ParseException e) {
			return date;
		}
	}

	public static final String format(Timestamp ts, String dateFormat) {
		Date date = new Date(ts.getTime());
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern(dateFormat);
		return format.format(date);
	}
	
	public static final String formatDisplay(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return format(date, DDMMYYYY, DD_MM_YYYY);
	}

	public static final String formatQLVK(Object date) {
		if (date == null || date.toString().isEmpty()) {
			return null;
		}
		return format(date.toString(), "yyyy-MM-dd", DD_MM_YYYY);
	}
	public static final String formatDB(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return format(date, DD_MM_YYYY, DDMMYYYY);
	}
	public static final String formatCompare(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		return format(date, DD_MM_YYYY, YYYYMMDD);
	}

	public static final String formatTimestampDisplay(Timestamp date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME);
		Date dateT = new Date(date.getTime());
		format.applyPattern(DATE_TIME_DISPLAY_2);
		return format.format(dateT);
	}
}