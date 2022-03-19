package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the mst_screen database table.
 * 
 */
@Entity
@Table(name="mst_screen")
@NamedQuery(name="MstScreen.findAll", query="SELECT m FROM MstScreen m")
public class MstScreen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_program")
	private String createProgram;

	@Column(name="create_user")
	private String createUser;

	@Column(name="del_flag")
	private String delFlag;

	private String locale;

	private String name;
	private String level;
	private String awesomeClass;
	
	@Column(name="order_display")
	private String orderDisplay;

	@Column(name="role_id")
	private String roleId;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_program")
	private String updateProgram;

	@Column(name="update_user")
	private String updateUser;

	private String url;

	public MstScreen() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateProgram() {
		return this.createProgram;
	}

	public void setCreateProgram(String createProgram) {
		this.createProgram = createProgram;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderDisplay() {
		return this.orderDisplay;
	}

	public void setOrderDisplay(String orderDisplay) {
		this.orderDisplay = orderDisplay;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateProgram() {
		return this.updateProgram;
	}

	public void setUpdateProgram(String updateProgram) {
		this.updateProgram = updateProgram;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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

}