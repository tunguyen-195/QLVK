
package com.qlvk.common.component;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.User;

@Component
public final class Messages {

	private static MessageSource messageSource;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private MessageSource messageSourceAutowired;

	@Autowired
	private static HttpServletRequest requestCons;

	private static User user;

	@PostConstruct
	private void initMessageSource() {
		messageSource = this.messageSourceAutowired;
		requestCons = request;
	}

	private static User getUser() {
		if (user == null) {
			user = (User) requestCons.getSession().getAttribute(CommonConstant.USER_INFO);
			if (user == null) {
				user = new User();
				user.setLocale(new Locale("vn"));
			}
		}
		return user;
	}

	public static String getMessage(String code, String[] args) {

		try {
			return messageSource.getMessage(code, convertLabel(args), getUser().getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	public static String getMessage(String code, String arg1) {
		String[] args = new String[] { arg1 };
		try {
			return messageSource.getMessage(code, convertLabel(args), getUser().getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	public static String getMessage(String code, String arg1, String arg2) {
		String[] args = new String[] { arg1, arg2 };
		try {
			return messageSource.getMessage(code, convertLabel(args), getUser().getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	public static String getMessage(String code, String arg1, String arg2, String arg3) {
		String[] args = new String[] { arg1, arg2, arg3 };
		try {
			return messageSource.getMessage(code, convertLabel(args), getUser().getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	public static String getMessage(String code) {
		try {
			return messageSource.getMessage(code, null, getUser().getLocale());
		} catch (Exception e) {
			return code;
		}
	}

	private static String[] convertLabel(String[] arg) {
		String[] argArr = new String[arg.length];
		String argProp = null;
		for (int i = 0; i < argArr.length; i++) {
			argProp = Messages.getMessage(arg[i]);
			if (StringUtils.isNotEmpty(argProp)) {
				argArr[i] = argProp;
			} else {
				argArr[i] = arg[i];
			}
		}
		return argArr;
	}
}