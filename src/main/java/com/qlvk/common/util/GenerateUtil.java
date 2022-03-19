package com.qlvk.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.CategoryModel;

@SuppressWarnings("deprecation")
public class GenerateUtil {

	/**
	 * Generate ID unique of system
	 * 
	 * @return
	 */
	public static String generateID() {
		Date date = new Date();
		Random rd = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(date) + String.format("%03d", rd.nextInt(1000));
	}

	/**
	 * Generate ID unique of system
	 * 
	 * @return
	 */
	public static String generateID(String prefix) {
		Date date = new Date();
		Random rd = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return prefix + "_" +format.format(date) + String.format("%03d", rd.nextInt(1000));
	}
	/**
	 * gerenate key
	 * 
	 * @param args
	 * @return 1_2_3 .....
	 */
	public static String generateKey(String... args) {
		StringJoiner joiner = new StringJoiner(CommonConstant.JOIN_KEY_PREFIX);
		for (String string : args) {
			joiner.add(string);
		}
		return joiner.toString();
	}

	/**
	 * Geneate HTML của SelectBox, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param className
	 * @param list
	 * @param selected
	 * @return
	 */
	public static String generateSelectBox(String idElement, String className, List<CategoryModel> list, String onchange, String selected, boolean emptyOption) {
		idElement = StringUtils.defaultString(idElement);
		className = StringUtils.defaultString(className);
		selected = StringUtils.defaultString(selected);
		onchange = StringUtils.defaultString(onchange);
		if (StringUtils.isNotEmpty(onchange)) {
			onchange = "onchange=\"" + onchange + "\"";
		}
		StringBuilder element = new StringBuilder();

		element.append("<select class=\"form-control radius " + className + "\" id=\"" + idElement + "\" name=\"" + idElement + "\" "+ StringUtils.defaultString(onchange) +">");
		if (emptyOption) {
			element.append("<option></option>");
		}
		for (CategoryModel categoryModel : list) {
			if (categoryModel.getKey().equals(selected)) {
				element.append("<option " + StringUtils.defaultString(categoryModel.getAttr()) + " value = \"" + categoryModel.getKey() + "\" selected>"
						+ categoryModel.getValue() + "</option>");
			} else {
				element.append("<option " + StringUtils.defaultString(categoryModel.getAttr()) + " value = \"" + categoryModel.getKey() + "\">" + categoryModel.getValue()
						+ "</option>");
			}
		}
		element.append("</select>");
		element.append(generateHidden(idElement, selected));
		return element.toString();
	}

	/**
	 * Geneate HTML của SelectBox, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param className
	 * @param list
	 * @param selected
	 * @return
	 */
	public static String generateSelectBox(String idElement, String className, List<CategoryModel> list, String selected) {
		return generateSelectBox(idElement, className, list, null,selected, false);
	}

	public static String generateSelectBox(String idElement, String className, List<CategoryModel> list, String selected, boolean emptyOption) {
		return generateSelectBox(idElement, className, list, null,selected, emptyOption);
	}
	/**
	 * Geneate HTML của Input Text, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param className
	 * @param value
	 * @param onchange
	 * @return
	 */
	public static String generateTextBox(String idElement, String className, String value, String onchange) {
		idElement = StringUtils.defaultString(idElement);
		className = StringUtils.defaultString(className);
		value = StringUtils.defaultString(value);
		onchange = StringUtils.defaultString(onchange);
		if (StringUtils.isNotEmpty(onchange)) {
			onchange = "onchange=\"" + onchange + "\"";
		}
		return "<input type=\"text\" class=\"form-control " + className + "\" id=\"" + idElement + "\" name=\"" + idElement + "\" value = \"" + value
				+ "\" " + StringUtils.defaultString(onchange) + ">" + generateHidden(idElement, value);
	}

	/**
	 * Geneate HTML của LABEL, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param className
	 * @param value
	 * @param onchange
	 * @return
	 */
	public static String generateLabel(String idElement, String className, String value) {
		idElement = StringUtils.defaultString(idElement);
		className = StringUtils.defaultString(className);
		value = StringUtils.defaultString(value);
		return "<span class=\"" + className + "\" id=\"" + idElement + "\">"+value+"</span>" + generateHidden(idElement, value);
	}

	/**
	 * Geneate HTML của Input Hidden, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param value
	 * @return
	 */
	public static String generateHidden(String idElement, String value) {
		idElement = "HIDDEN_" + StringUtils.defaultString(idElement);
		value = StringUtils.defaultString(value);
		return "<input type=\"hidden\" id=\"" + idElement + "\" name=\"" + idElement + "\" value = \"" + value + "\">";
	}

	/**
	 * Geneate HTML của TextArea, dành cho các màn hình nhập data tương tự excel
	 * 
	 * @param idElement
	 * @param className
	 * @param value
	 * @param onchange
	 * @return
	 */
	public static String generateTextArea(String idElement, String className, String value, String onchange) {
		idElement = StringUtils.defaultString(idElement);
		className = StringUtils.defaultString(className);
		value = StringUtils.defaultString(value);
		onchange = StringUtils.defaultString(onchange);
		if (StringUtils.isNotEmpty(onchange)) {
			onchange = "onchange=\"" + onchange + "\"";
		}
		return "<textarea rows=\"3\" class=\"form-control " + className + "\" id=\"" + idElement + "\" name=\"" + idElement + "\" >" + value
				+ "</textarea>" + generateHidden(idElement, value);
	}

	/**
	 * Hỗ trợ paging mặc định: paging theo Sort Page size mặc định
	 * 
	 * @param start
	 * @param sort
	 * @return
	 */
	public static Pageable generatePageable(int start, Sort sort) {
		return new PageRequest(start / CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE, sort);
	}

	/**
	 * Hỗ trợ paging mặc định: paging theo Sort Page size customize của user (có thể
	 * lựa chọn ở pulldown màn hình hoặc constant)
	 * 
	 * @param start
	 * @param length
	 * @param sort
	 * @return
	 */
	public static Pageable generatePageable(int start, int length, Sort sort) {
		return new PageRequest(start / length, length, sort);
	}

	/**
	 * Hỗ trợ paging mặc định: paging theo column và direction Page size customize
	 * của user (có thể lựa chọn ở pulldown màn hình hoặc constant)
	 * 
	 * @param start
	 * @param length
	 * @param orderColumn
	 * @param orderDirection
	 * @return
	 */
	public static Pageable generatePageable(int start, int length, String orderColumn, String orderDirection) {
		Sort sort;
		if (orderDirection.equalsIgnoreCase(Direction.ASC.toString())) {
			sort = new Sort(new Sort.Order(Direction.ASC, orderColumn));
		} else {
			sort = new Sort(new Sort.Order(Direction.DESC, orderColumn));
		}
		return new PageRequest(start / length, length, sort);
	}

	/**
	 * Hỗ trợ paging mặc định: paging theo column và direction Page size mặc định
	 * 
	 * @param start
	 * @param orderColumn
	 * @param orderDirection
	 * @return
	 */
	public static Pageable generatePageable(int start, String orderColumn, String orderDirection) {
		Sort sort;
		if (orderDirection.equalsIgnoreCase(Direction.ASC.toString())) {
			sort = new Sort(new Sort.Order(Direction.ASC, orderColumn));
		} else {
			sort = new Sort(new Sort.Order(Direction.DESC, orderColumn));
		}
		return new PageRequest(start / CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE, sort);
	}

	/**
	 * Hỗ trợ order theo nhiều column Page size mặc định
	 * 
	 * @param start
	 * @param orderColumn
	 * @return
	 */
	public static Pageable generatePageable(int start, String... orderColumn) {
		return PageRequest.of(start / CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE, Direction.ASC, orderColumn);
	}
}