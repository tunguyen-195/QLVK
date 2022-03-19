package com.qlvk.common.validate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.qlvk.common.component.Messages;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.DateUtil;

public class Validate {
	public static final Integer FORMAT_INTEGER = 0;
	public static final Integer FORMAT_DECIMAL = 1;
	public static final Integer FORMAT_HALF_SIZE = 2;
	public static final Integer FORMAT_FULL_SIZE = 3;
	public static final Integer FORMAT_ALL = 4;
	public static final Integer FORMAT_DATE = 5;
	private List<ValidateItem> validateItemList = null;
	private List<Map<String, String>> listItemError = null;
	private String messageError = null;

	/**
	 * 
	 */
	public Validate() {
		validateItemList = new ArrayList<>();
		listItemError = new ArrayList<>();
	}

	/**
	 * 
	 * @return
	 */
	public boolean check() {
		boolean valid = true;
		for (ValidateItem item : validateItemList) {
			if (!check(item)) {
				valid = false;
			}
		}
		return valid;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean check(Map<String, Object> data) {
		boolean valid = true;
		for (ValidateItem item : validateItemList) {
			if (!check(item)) {
				valid = false;
			}
		}
		if (!valid) {
			setError(data);
		}
		return valid;
	}

	/**
	 * 
	 * @param data
	 */
	private void setError(Map<String, Object> data) {
		data.put(CommonConstant.LIST_ITEM_ERROR, listItemError);
		data.put(CommonConstant.MESSAGE_ERROR, messageError);
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_BAD_REQUEST);
	}

	/**
	 * 
	 * @param data
	 * @param idElement
	 * @param message
	 */
	public void addError(Map<String, Object> data, String idElement, String message) {

		listItemError.add(setMapError(idElement, null, message));
		data.put(CommonConstant.LIST_ITEM_ERROR, listItemError);
		data.put(CommonConstant.MESSAGE_ERROR, getMessageError());
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_BAD_REQUEST);
	}

	/**
	 * 
	 * @param data
	 * @param message
	 */
	public void addError(Map<String, Object> data, String message) {
		setMessageError(message);
		data.put(CommonConstant.MESSAGE_ERROR, getMessageError());
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_BAD_REQUEST);
	}

	/**
	 * 
	 * @param data
	 * @param message
	 */
	public void addInfor(Map<String, Object> data, String message) {
		data.put(CommonConstant.MESSAGE_INFOR, message);
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_OK);
	}

	/**
	 * 
	 * @param data
	 * @param message
	 */
	public void addWarning(Map<String, Object> data, String message) {
		setMessageError(message);
		data.put(CommonConstant.MESSAGE_WARNING, message);
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_OK);
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean check(ValidateItem item) {
		if (item == null) {
			return true;
		}
		item.setValue(parseValue(item));
		if (!required(item)) {
			return false;
		}

		if (!maxLength(item)) {
			return false;
		}

		if (!checkFullDigit(item)) {
			return false;
		}
		if (!checkIgnoreSpace(item)) {
			return false;
		}
		if (!checkFormat(item)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private String parseValue(ValidateItem item) {
		String value = StringUtils.defaultString(item.getValue());
		switch (item.getFormat()) {
		case 0:
		case 1:
			if (StringUtils.isNotEmpty(value)) {
				value = item.getValue().replaceAll(CommonConstant.COMMA, "");
			}
			break;
		case 5:
			if (value.length() == 10) {
				value = DateUtil.formatDB(value);
			}
			break;
		default:
			break;
		}
		return value;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean checkFormat(ValidateItem item) {
		if (item.getFormat() == null) {
			return true;
		}
		String value = item.getValue();
		switch (item.getFormat()) {
		case 0:
			try {
				if (StringUtils.isNotEmpty(value)) {
					Integer.parseInt(item.getValue().replaceAll(CommonConstant.COMMA, ""));
				}
			} catch (Exception e) {
				listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.integer", item.getLabel())));
				return false;
			}
			break;
		case 1:
			try {
				if (StringUtils.isNotEmpty(value)) {
					new BigDecimal(item.getValue().replaceAll(CommonConstant.COMMA, ""));
				}
			} catch (Exception e) {
				listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.decimal", item.getLabel())));
				return false;
			}
			break;
		case 2:
			if (StringUtils.isNotEmpty(value)) {
				char c;
				for (int i = 0; i < value.length(); i++) {
					c = value.charAt(i);
					if (!((0x0020 <= c && c < 0x007f) || (0xff60 < c && c <= 0xff9f))) {
						listItemError.add(
								setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.haftSize", item.getLabel())));
						return false;
					}
				}
			}
			break;
		case 3:
			if (StringUtils.isNotEmpty(value)) {
				char c;
				for (int i = 0; i < value.length(); i++) {
					c = value.charAt(i);
					if (0xff60 < c && c <= 0xff9f) {
						listItemError.add(
								setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.fullSize", item.getLabel())));
						return false;
					}
				}
			}
			break;
		case 5:
			if (StringUtils.isNotEmpty(value)) {
				if (value.length() == 10) {
					value = DateUtil.formatDB(value);
				}
				if (value.length() != 8) {
					listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.date", item.getLabel())));
					return false;
				}
				try {
					SimpleDateFormat fmt = new SimpleDateFormat();
					fmt.setLenient(false);
					fmt.applyPattern(DateUtil.DDMMYYYY);
					fmt.parse(value);
				} catch (Exception e) {
					listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.date", item.getLabel())));
					return false;
				}
			}

			break;
		default:
			return true;
		}
		return true;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean checkIgnoreSpace(ValidateItem item) {
		if (!item.isIgnoreSpace() && (item.getValue().contains(" ") || item.getValue().contains("　"))) {
			listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.refuseSpace", item.getLabel())));
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean checkFullDigit(ValidateItem item) {
		if (item.isFullDigit() && item.getLength() != item.getValue().length()) {
			listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.fullDigit", item.getLabel())));
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean maxLength(ValidateItem item) {
		if (StringUtils.isNotEmpty(item.getValue()) && item.getLength() < item.getValue().length()) {
			listItemError.add(setMapError(item.getIdElement(), item.getLine(),
					Messages.getMessage("common.validate.maxLength", item.getLabel(), String.valueOf(item.getLength()))));
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	private boolean required(ValidateItem item) {

		if (item.isRequired() && StringUtils.isEmpty(item.getValue())) {
			listItemError.add(setMapError(item.getIdElement(), item.getLine(), Messages.getMessage("common.validate.required", item.getLabel())));
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 * @param ignoreSpace
	 * @param format
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit, boolean ignoreSpace,
			Integer format) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, isFullDigit, ignoreSpace, format));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 * @param ignoreSpace
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit, boolean ignoreSpace) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, isFullDigit, ignoreSpace, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, isFullDigit, true, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, false, true, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param format
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length, Integer format) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, false, true, format));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param ignoreSpace
	 * @param format
	 */
	public void add(String value, String idElement, String label, boolean isRequired, Integer length, boolean ignoreSpace, Integer format) {
		validateItemList.add(new ValidateItem(value, idElement, label, isRequired, length, false, ignoreSpace, format));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 * @param ignoreSpace
	 * @param format
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit,
			boolean ignoreSpace, Integer format) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, isFullDigit, ignoreSpace, format));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 * @param ignoreSpace
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit,
			boolean ignoreSpace) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, isFullDigit, ignoreSpace, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param isFullDigit
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, isFullDigit, true, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, false, true, null));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param format
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length, Integer format) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, false, true, format));
	}

	/**
	 * 
	 * @param value
	 * @param idElement
	 * @param label
	 * @param isRequired
	 * @param length
	 * @param ignoreSpace
	 * @param format
	 */
	public void addLine(int line, String value, String idElement, String label, boolean isRequired, Integer length, boolean ignoreSpace,
			Integer format) {
		validateItemList.add(new ValidateItem(line, value, idElement, label, isRequired, length, false, ignoreSpace, format));
	}

	/**
	 * 
	 * @return
	 */
	public String getMessageError() {
		return messageError;
	}

	/**
	 * 
	 * @param messageError
	 */
	public void setMessageError(String messageError) {
		if (StringUtils.isEmpty(this.messageError)) {
			this.messageError = messageError;
		}
	}

	/**
	 * 
	 * @param idElement
	 * @param message
	 * @return
	 */
	private Map<String, String> setMapError(String idElement, Integer line, String message) {
		Map<String, String> errorMap = new HashMap<>();
		if (line != null) {
			errorMap.put("line", String.valueOf(line));
		}
		errorMap.put("id", idElement);
		errorMap.put("message", message);
		return errorMap;
	}

	public List<Map<String, String>> getListItemError() {
		return listItemError;
	}
	/**
	 * 
	 */
	public void reset() {
		validateItemList.clear();
		listItemError.clear();
		messageError = null;
	}
}