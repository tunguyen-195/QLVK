package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cbcs_member database table.
 * 
 */
@Entity
@Table(name="cbcs_member")
@NamedQuery(name="CbcsMember.findAll", query="SELECT c FROM CbcsMember c")
public class CbcsMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ten_tk")
	private String tenTk;

	@Column(name="ma_cbcs")
	private int maCbcs;

	@Column(name="mat_khau")
	private String matKhau;

	public CbcsMember() {
	}

	public String getTenTk() {
		return this.tenTk;
	}

	public void setTenTk(String tenTk) {
		this.tenTk = tenTk;
	}

	public int getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(int maCbcs) {
		this.maCbcs = maCbcs;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}