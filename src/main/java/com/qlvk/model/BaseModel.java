package com.qlvk.model;

import java.sql.Timestamp;

public class BaseModel {
	protected Timestamp cmnUpdateDate;
	protected String primaryKey;

	protected String cmnCreateUserLabel;
	protected String cmnCreateDateLabel;
	protected String cmnUpdateUserLabel;
	protected String cmnUpdateDateLabel;

	public Timestamp getCmnUpdateDate() {
		return cmnUpdateDate;
	}

	public void setCmnUpdateDate(Timestamp cmnUpdateDate) {
		this.cmnUpdateDate = cmnUpdateDate;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getCmnCreateUserLabel() {
		return cmnCreateUserLabel;
	}

	public void setCmnCreateUserLabel(String cmnCreateUserLabel) {
		this.cmnCreateUserLabel = cmnCreateUserLabel;
	}

	public String getCmnCreateDateLabel() {
		return cmnCreateDateLabel;
	}

	public void setCmnCreateDateLabel(String cmnCreateDateLabel) {
		this.cmnCreateDateLabel = cmnCreateDateLabel;
	}

	public String getCmnUpdateUserLabel() {
		return cmnUpdateUserLabel;
	}

	public void setCmnUpdateUserLabel(String cmnUpdateUserLabel) {
		this.cmnUpdateUserLabel = cmnUpdateUserLabel;
	}

	public String getCmnUpdateDateLabel() {
		return cmnUpdateDateLabel;
	}

	public void setCmnUpdateDateLabel(String cmnUpdateDateLabel) {
		this.cmnUpdateDateLabel = cmnUpdateDateLabel;
	}
}