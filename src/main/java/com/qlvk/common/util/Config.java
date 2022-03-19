package com.qlvk.common.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {
	private static PropertyResourceBundle resources;

	static {
		resources = (PropertyResourceBundle) ResourceBundle.getBundle("config", Locale.getDefault());
	}

	public static String get(String key) {
		try {
		return resources.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
	}
}