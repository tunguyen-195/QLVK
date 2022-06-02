package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the danh_sach_muon database table.
 * 
 */
@Entity
@Table(name="danh_sach_muon")
@NamedQuery(name="DanhSachMuon.findAll", query="SELECT d FROM DanhSachMuon d")
public class DanhSachMuon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_muon")
	private int maMuon;

	@Column(name="ly_do")
	private String lyDo;

	@Column(name="ma_cbcs")
	private int maCbcs;

	@Column(name="nhan_hieu_vk_vln_ccht")
	private String nhanHieuVkVlnCcht;

	@Column(name="so_luong")
	private int soLuong;

	@Column(name="trang_thai_muon")
	private int trangThaiMuon;

	public DanhSachMuon() {
	}

	public int getMaMuon() {
		return this.maMuon;
	}

	public void setMaMuon(int maMuon) {
		this.maMuon = maMuon;
	}

	public String getLyDo() {
		return this.lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public int getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(int maCbcs) {
		this.maCbcs = maCbcs;
	}

	public String getNhanHieuVkVlnCcht() {
		return this.nhanHieuVkVlnCcht;
	}

	public void setNhanHieuVkVlnCcht(String nhanHieuVkVlnCcht) {
		this.nhanHieuVkVlnCcht = nhanHieuVkVlnCcht;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getTrangThaiMuon() {
		return this.trangThaiMuon;
	}

	public void setTrangThaiMuon(int trangThaiMuon) {
		this.trangThaiMuon = trangThaiMuon;
	}

}