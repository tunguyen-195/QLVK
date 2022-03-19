package com.qlvk.model;

import java.io.Serializable;

public class HoSoModel extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String soLt;


	private String cbnl;

	private String maDvNl;

	private String maLoai;

	private String ngayDk;
	private String ngayNl;
	private String thoiHanBaoQuan;

	public String getThoiHanBaoQuan() {
		return thoiHanBaoQuan;
	}

	public void setThoiHanBaoQuan(String thoiHanBaoQuan) {
		this.thoiHanBaoQuan = thoiHanBaoQuan;
	}

	private String ngayKt;

	private String ngayLap;


	private String soDk;

	private String trichYeu;

	public HoSoModel() {
	}

	public String getSoLt() {
		return this.soLt;
	}

	public void setSoLt(String soLt) {
		this.soLt = soLt;
	}

	public String getCbnl() {
		return this.cbnl;
	}

	public void setCbnl(String cbnl) {
		this.cbnl = cbnl;
	}

	public String getMaDvNl() {
		return this.maDvNl;
	}

	public void setMaDvNl(String maDvNl) {
		this.maDvNl = maDvNl;
	}

	public String getMaLoai() {
		return this.maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getNgayDk() {
		return this.ngayDk;
	}

	public void setNgayDk(String ngayDk) {
		this.ngayDk = ngayDk;
	}

	public String getNgayKt() {
		return this.ngayKt;
	}

	public void setNgayKt(String ngayKt) {
		this.ngayKt = ngayKt;
	}

	public String getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getSoDk() {
		return this.soDk;
	}

	public void setSoDk(String soDk) {
		this.soDk = soDk;
	}

	public String getTrichYeu() {
		return this.trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}

	public String getNgayNl() {
		return ngayNl;
	}

	public void setNgayNl(String ngayNl) {
		this.ngayNl = ngayNl;
	}

}
