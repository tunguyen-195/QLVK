package com.qlvk.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
	protected Timestamp cmnUpdateDate;
	protected String primaryKey;

	protected String cmnCreateUserLabel;
	protected String cmnCreateDateLabel;
	protected String cmnUpdateUserLabel;
	protected String cmnUpdateDateLabel;
}