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
	private int maCbcs;

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

	public Cbcs() {
	}

	public int getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(int maCbcs) {
		this.maCbcs = maCbcs;
	}

	public String getCapBac() {
		return this.capBac;
	}

	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getDonVi() {
		return this.donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoHieuCand() {
		return this.soHieuCand;
	}

	public void setSoHieuCand(String soHieuCand) {
		this.soHieuCand = soHieuCand;
	}

}