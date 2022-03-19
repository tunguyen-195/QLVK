package com.qlvk.model;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.stereotype.Component;

/**
 * The persistent class for the app_user database table.
 * 
 */
@Component
public class User implements Serializable {
	@Override
	public String toString() {
		return "User [locale=" + locale + ", userId=" + userId + ", name=" + name + ", role=" + role + ", roleId=" + roleId + "]";
	}

	private static final long serialVersionUID = 1L;

	private Locale locale;

	private String userId;

	private String name;

	private String role;
	private String roleName;
	private String roleId;

	public User() {
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}