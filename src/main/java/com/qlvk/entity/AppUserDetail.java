package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the app_user_detail database table.
 * 
 */
@Entity
@Table(name="app_user_detail")
@NamedQuery(name="AppUserDetail.findAll", query="SELECT a FROM AppUserDetail a")
public class AppUserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	private String address;

	@Column(name="avatar_path")
	private String avatarPath;

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

	private String dob;

	@Column(name="in_date")
	private String inDate;

	@Column(name="leader_id")
	private String leaderId;

	private Integer level;

	@Column(name="mail_fsoft")
	private String mailFsoft;

	@Column(name="out_date")
	private String outDate;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="phone_number_urgent")
	private String phoneNumberUrgent;

	public AppUserDetail() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatarPath() {
		return this.avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
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

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getInDate() {
		return this.inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMailFsoft() {
		return this.mailFsoft;
	}

	public void setMailFsoft(String mailFsoft) {
		this.mailFsoft = mailFsoft;
	}

	public String getOutDate() {
		return this.outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberUrgent() {
		return this.phoneNumberUrgent;
	}

	public void setPhoneNumberUrgent(String phoneNumberUrgent) {
		this.phoneNumberUrgent = phoneNumberUrgent;
	}

}