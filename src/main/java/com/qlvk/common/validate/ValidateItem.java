package com.qlvk.common.validate;

public class ValidateItem {
	private boolean required;
	private Integer length;
	private Integer format;
	private boolean ignoreSpace;
	private boolean fullDigit;
	private String value;
	private String idElement;
	private String label;
	private Integer line;// Using for import file

	public ValidateItem(String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit, boolean ignoreSpace,
			Integer format) {
		super();
		this.value = value;
		this.idElement = idElement;
		this.required = isRequired;
		this.length = length;
		this.format = format;
		this.ignoreSpace = ignoreSpace;
		this.fullDigit = isFullDigit;
		this.label = label;
	}

	public ValidateItem(int line, String value, String idElement, String label, boolean isRequired, Integer length, boolean isFullDigit,
			boolean ignoreSpace, Integer format) {
		this.line = line;
		this.value = value;
		this.idElement = idElement;
		this.required = isRequired;
		this.length = length;
		this.format = format;
		this.ignoreSpace = ignoreSpace;
		this.fullDigit = isFullDigit;
		this.label = label;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean isRequired) {
		this.required = isRequired;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getFormat() {
		return format;
	}

	public void setFormat(Integer format) {
		this.format = format;
	}

	public boolean isIgnoreSpace() {
		return ignoreSpace;
	}

	public void setIgnoreSpace(boolean ignoreSpace) {
		this.ignoreSpace = ignoreSpace;
	}

	public boolean isFullDigit() {
		return fullDigit;
	}

	public void setFullDigit(boolean isFullDigit) {
		this.fullDigit = isFullDigit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIdElement() {
		return idElement;
	}

	public void setIdElement(String idElement) {
		this.idElement = idElement;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}
}