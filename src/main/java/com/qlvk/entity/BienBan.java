package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bien_ban database table.
 * 
 */
@Entity
@Table(name="bien_ban")
@NamedQuery(name="BienBan.findAll", query="SELECT b FROM BienBan b")
public class BienBan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="so_bien_ban")
	private int soBienBan;

	@Column(name="da_xuat_bien_ban")
	private int daXuatBienBan;

	@Column(name="ma_cbql")
	private int maCbql;

	@Column(name="ma_duyet")
	private int maDuyet;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_muon")
	private Date ngayMuon;

	public BienBan() {
	}

	public int getSoBienBan() {
		return this.soBienBan;
	}

	public void setSoBienBan(int soBienBan) {
		this.soBienBan = soBienBan;
	}

	public int getDaXuatBienBan() {
		return this.daXuatBienBan;
	}

	public void setDaXuatBienBan(int daXuatBienBan) {
		this.daXuatBienBan = daXuatBienBan;
	}

	public int getMaCbql() {
		return this.maCbql;
	}

	public void setMaCbql(int maCbql) {
		this.maCbql = maCbql;
	}

	public int getMaDuyet() {
		return this.maDuyet;
	}

	public void setMaDuyet(int maDuyet) {
		this.maDuyet = maDuyet;
	}

	public Date getNgayMuon() {
		return this.ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

}