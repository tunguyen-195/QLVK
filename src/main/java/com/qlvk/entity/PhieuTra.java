package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the phieu_tra database table.
 * 
 */
@Entity
@Table(name="phieu_tra")
@NamedQuery(name="PhieuTra.findAll", query="SELECT p FROM PhieuTra p")
public class PhieuTra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_tra")
	private int maTra;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_tra")
	private Date ngayTra;

	@Column(name="so_bien_ban")
	private int soBienBan;

	public PhieuTra() {
	}

	public int getMaTra() {
		return this.maTra;
	}

	public void setMaTra(int maTra) {
		this.maTra = maTra;
	}

	public Date getNgayTra() {
		return this.ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public int getSoBienBan() {
		return this.soBienBan;
	}

	public void setSoBienBan(int soBienBan) {
		this.soBienBan = soBienBan;
	}

}