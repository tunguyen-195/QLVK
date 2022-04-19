package com.qlvk.model;

import java.io.Serializable;

public class VuKhiModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imgPath;
	private String chungLoai;
	private String nhanHieu;
	private String nuocSanXuat;
	private String soHieu;
	private String soGiayPhep;
	private String ngayCapPhep;
	private String coGiaTriDen;
	private String soLuong;

	public String getChungLoai() {
		return chungLoai;
	}

	public void setChungLoai(String chungLoai) {
		this.chungLoai = chungLoai;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public String getSoHieu() {
		return soHieu;
	}

	public void setSoHieu(String soHieu) {
		this.soHieu = soHieu;
	}

	public String getSoGiayPhep() {
		return soGiayPhep;
	}

	public void setSoGiayPhep(String soGiayPhep) {
		this.soGiayPhep = soGiayPhep;
	}

	public String getNgayCapPhep() {
		return ngayCapPhep;
	}

	public void setNgayCapPhep(String ngayCapPhep) {
		this.ngayCapPhep = ngayCapPhep;
	}

	public String getCoGiaTriDen() {
		return coGiaTriDen;
	}

	public void setCoGiaTriDen(String coGiaTriDen) {
		this.coGiaTriDen = coGiaTriDen;
	}

	public String getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
}
