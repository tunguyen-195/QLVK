package com.qlvk.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DanhSachVKModel {
	@NotNull
	private int soHieu;
	@NotNull
	@Size(max = 20)
	private String chungLoai;
	@NotNull
	@Size(max = 20)
	private String nhanHieu;
	private String nuocSX;
	@NotNull
	@Size(max = 45)
	private String tinhTrang;
	private String donViTinh;

	public int getSoHieu() {
		return soHieu;
	}

	public void setSoHieu(int soHieu) {
		this.soHieu = soHieu;
	}

	public String getChungLoai() {
		return chungLoai;
	}

	public void setChungLoai(String chungLoai) {
		this.chungLoai = chungLoai;
	}

	public String getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public String getNuocSX() {
		return nuocSX;
	}

	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

}
