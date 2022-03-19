package com.qlvk.model;

import java.io.Serializable;

public class TaiKhoanModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;


	private String hoTen;
	private String userName;
	private String quyen;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	
}