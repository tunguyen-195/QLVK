package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the quan_ly database table.
 * 
 */
@Entity
@Table(name="quan_ly")
@NamedQuery(name="QuanLy.findAll", query="SELECT q FROM QuanLy q")
public class QuanLy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ten_tkql")
	private String tenTkql;

	@Column(name="cap_bac")
	private String capBac;

	@Column(name="chuc_vu")
	private String chucVu;

	@Column(name="ho_ten")
	private String hoTen;

	@Column(name="mat_khau")
	private String matKhau;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_sinh")
	private Date ngaySinh;

	@Column(name="so_dien_thoai")
	private String soDienThoai;

	@Column(name="so_hieu_cand")
	private String soHieuCand;

	public QuanLy() {
	}

	public String getTenTkql() {
		return this.tenTkql;
	}

	public void setTenTkql(String tenTkql) {
		this.tenTkql = tenTkql;
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

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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