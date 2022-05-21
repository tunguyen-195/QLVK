package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cbcs database table.
 * 
 */
@Entity
@NamedQuery(name="Cbcs.findAll", query="SELECT c FROM Cbcs c")
public class Cbcs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_cbcs")
	private String maCbcs;

	@Column(name="cap_bac")
	private String capBac;


	@Column(name="chuc_vu")
	private String chucVu;


	@Column(name="don_vi")
	private String donVi;


	@Column(name="ho_ten")
	private String hoTen;


	@Temporal(TemporalType.DATE)
	@Column(name="ngay_sinh")
	private Date ngaySinh;


	@Column(name="so_dien_thoai")
	private String soDienThoai;

	@Column(name="so_hieu_cand")
	private String soHieuCand;


	@Column(name="user_id")
	private String userId;

	public Cbcs() {
	}

	public String getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(String maCbcs) {
		this.maCbcs = maCbcs;
	}


	public String getCapBac() {
		return this.capBac;
	}

	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}


	public String getSoHieuCand() {
		return this.soHieuCand;
	}

	public void setSoHieuCand(String soHieuCand) {
		this.soHieuCand = soHieuCand;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}