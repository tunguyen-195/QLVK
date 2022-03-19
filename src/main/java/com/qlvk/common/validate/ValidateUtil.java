package com.qlvk.common.validate;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtil {

	public static boolean lineHasUpdated(String newData, String olData, String dataUpdated) {
		if (!StringUtils.equals(newData, olData) && !StringUtils.equals(dataUpdated, olData)) {
			return true;
		}
		return false;
	}
}
