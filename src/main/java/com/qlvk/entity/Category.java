package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CategoryPK id;

	@Column(name="cmn_create_date")
	private Timestamp cmnCreateDate;

	@Column(name="cmn_create_program")
	private String cmnCreateProgram;

	@Column(name="cmn_create_user")
	private String cmnCreateUser;

	@Column(name="cmn_update_date")
	private Timestamp cmnUpdateDate;

	@Column(name="cmn_update_program")
	private String cmnUpdateProgram;

	@Column(name="cmn_update_user")
	private String cmnUpdateUser;

	@Column(name="del_flag")
	private String delFlag;

	private String name;

	private Integer range;

	private String value;

	public Category() {
	}

	public CategoryPK getId() {
		return this.id;
	}

	public void setId(CategoryPK id) {
		this.id = id;
	}

	public Timestamp getCmnCreateDate() {
		return this.cmnCreateDate;
	}

	public void setCmnCreateDate(Timestamp cmnCreateDate) {
		this.cmnCreateDate = cmnCreateDate;
	}

	public String getCmnCreateProgram() {
		return this.cmnCreateProgram;
	}

	public void setCmnCreateProgram(String cmnCreateProgram) {
		this.cmnCreateProgram = cmnCreateProgram;
	}

	public String getCmnCreateUser() {
		return this.cmnCreateUser;
	}

	public void setCmnCreateUser(String cmnCreateUser) {
		this.cmnCreateUser = cmnCreateUser;
	}

	public Timestamp getCmnUpdateDate() {
		return this.cmnUpdateDate;
	}

	public void setCmnUpdateDate(Timestamp cmnUpdateDate) {
		this.cmnUpdateDate = cmnUpdateDate;
	}

	public String getCmnUpdateProgram() {
		return this.cmnUpdateProgram;
	}

	public void setCmnUpdateProgram(String cmnUpdateProgram) {
		this.cmnUpdateProgram = cmnUpdateProgram;
	}

	public String getCmnUpdateUser() {
		return this.cmnUpdateUser;
	}

	public void setCmnUpdateUser(String cmnUpdateUser) {
		this.cmnUpdateUser = cmnUpdateUser;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRange() {
		return this.range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}