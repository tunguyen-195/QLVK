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

	@Column(name="ma_cbcs")
	private int maCbcs;

	@Column(name="so_hieu_vk_vln_ccht")
	private int soHieuVkVlnCcht;

	public DanhSachMuon() {
	}

	public int getMaMuon() {
		return this.maMuon;
	}

	public void setMaMuon(int maMuon) {
		this.maMuon = maMuon;
	}

	public int getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(int maCbcs) {
		this.maCbcs = maCbcs;
	}

	public int getSoHieuVkVlnCcht() {
		return this.soHieuVkVlnCcht;
	}

	public void setSoHieuVkVlnCcht(int soHieuVkVlnCcht) {
		this.soHieuVkVlnCcht = soHieuVkVlnCcht;
	}

}