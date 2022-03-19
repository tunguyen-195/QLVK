package com.qlvk.common.util;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

import com.qlvk.common.constant.CommonConstant;

public class DecimalUtil {

	public static final String FORMAT_DECIMAL = "##,###.###";
	public static final String FORMAT_NUMBER = "##,###";
	public static final String FORMAT_DECIMAL_DB = "#####.###";
	public static final String FORMAT_NUMBER_DB = "#####";

	public static String format(String num, String pattern) {
		if (num == null || num.equals("")) {
			return "";
		}
		DecimalFormat format = new DecimalFormat();

		if (pattern != null && !pattern.equals("")) {
			format.applyPattern(pattern);
		}
		return format.format(Double.parseDouble(num));
	}

	public static String format(Integer num, String pattern) {
		if (num == null) {
			return "";
		}
		return format(String.valueOf(num), pattern);
	}

	public static Integer convertInt(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			return Integer.parseInt(str.replaceAll(CommonConstant.COMMA, ""));
		} catch (Exception e) {
			return null;
		}
	}

	public static Double convertDouble(String str, String pattern) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		try {
			return Double.parseDouble(str.replaceAll(CommonConstant.COMMA, ""));
		} catch (Exception e) {
			return null;
		}
	}
}