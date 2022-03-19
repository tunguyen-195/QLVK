package com.qlvk.model;

import java.io.Serializable;

/**
 * The persistent class for the category database table.
 * 
 */
public class CategoryModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String key;

	private String value;

	private String attr;
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}
}