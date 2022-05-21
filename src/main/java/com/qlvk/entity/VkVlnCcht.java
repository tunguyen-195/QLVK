package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vk_vln_ccht database table.
 * 
 */
@Entity
@Table(name="vk_vln_ccht")
@NamedQuery(name="VkVlnCcht.findAll", query="SELECT v FROM VkVlnCcht v")
public class VkVlnCcht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="so_hieu_vk_vln_ccht")
	private int soHieuVkVlnCcht;

	@Column(name="chung_loai")
	private String chungLoai;

	@Column(name="don_vi_tinh")
	private String donViTinh;

	@Column(name="nhan_hieu_vk_vln_ccht")
	private String nhanHieuVkVlnCcht;

	@Column(name="nuoc_san_xuat")
	private String nuocSanXuat;

	@Column(name="so_luong")
	private int soLuong;

	@Column(name="so_luong_ton_kho")
	private int soLuongTonKho;

	public VkVlnCcht() {
	}

	public int getSoHieuVkVlnCcht() {
		return this.soHieuVkVlnCcht;
	}

	public void setSoHieuVkVlnCcht(int soHieuVkVlnCcht) {
		this.soHieuVkVlnCcht = soHieuVkVlnCcht;
	}

	public String getChungLoai() {
		return this.chungLoai;
	}

	public void setChungLoai(String chungLoai) {
		this.chungLoai = chungLoai;
	}

	public String getDonViTinh() {
		return this.donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getNhanHieuVkVlnCcht() {
		return this.nhanHieuVkVlnCcht;
	}

	public void setNhanHieuVkVlnCcht(String nhanHieuVkVlnCcht) {
		this.nhanHieuVkVlnCcht = nhanHieuVkVlnCcht;
	}

	public String getNuocSanXuat() {
		return this.nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSoLuongTonKho() {
		return this.soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

}