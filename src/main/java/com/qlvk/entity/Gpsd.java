package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gpsd database table.
 * 
 */
@Entity
@NamedQuery(name="Gpsd.findAll", query="SELECT g FROM Gpsd g")
public class Gpsd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="so_gpsd")
	private int soGpsd;

	@Column(name="chung_loai_gpsd")
	private String chungLoaiGpsd;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_cap")
	private Date ngayCap;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_het_han")
	private Date ngayHetHan;

	@Column(name="nguoi_ky")
	private String nguoiKy;

	@Column(name="so_hieu_vk_vln_ccht")
	private int soHieuVkVlnCcht;

	public Gpsd() {
	}

	public int getSoGpsd() {
		return this.soGpsd;
	}

	public void setSoGpsd(int soGpsd) {
		this.soGpsd = soGpsd;
	}

	public String getChungLoaiGpsd() {
		return this.chungLoaiGpsd;
	}

	public void setChungLoaiGpsd(String chungLoaiGpsd) {
		this.chungLoaiGpsd = chungLoaiGpsd;
	}

	public Date getNgayCap() {
		return this.ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Date getNgayHetHan() {
		return this.ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getNguoiKy() {
		return this.nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public int getSoHieuVkVlnCcht() {
		return this.soHieuVkVlnCcht;
	}

	public void setSoHieuVkVlnCcht(int soHieuVkVlnCcht) {
		this.soHieuVkVlnCcht = soHieuVkVlnCcht;
	}

}