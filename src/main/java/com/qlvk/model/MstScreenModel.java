package com.qlvk.model;

import java.io.Serializable;

public class MstScreenModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;


	private String url;
	private String level;
	private String awesomeClass;
	private String modeGenerateHtml;
	public MstScreenModel() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAwesomeClass() {
		return awesomeClass;
	}

	public void setAwesomeClass(String awesomeClass) {
		this.awesomeClass = awesomeClass;
	}

	public String getModeGenerateHtml() {
		return modeGenerateHtml;
	}

	public void setModeGenerateHtml(String modeGenerateHtml) {
		this.modeGenerateHtml = modeGenerateHtml;
	}

	@Override
	public String toString() {
		return "MstScreenModel [name=" + name + ", url=" + url + ", modeGenerateHtml=" + modeGenerateHtml + "]";
	}
}