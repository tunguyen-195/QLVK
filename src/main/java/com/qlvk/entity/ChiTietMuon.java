package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chi_tiet_muon database table.
 * 
 */
@Entity
@Table(name="chi_tiet_muon")
@NamedQuery(name="ChiTietMuon.findAll", query="SELECT c FROM ChiTietMuon c")
public class ChiTietMuon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_chi_tiet")
	private int maChiTiet;

	@Column(name="ma_duyet")
	private int maDuyet;

	@Column(name="ma_muon")
	private int maMuon;

	@Column(name="so_hieu_vk_vln_ccht")
	private int soHieuVkVlnCcht;

	public ChiTietMuon() {
	}

	public int getMaChiTiet() {
		return this.maChiTiet;
	}

	public void setMaChiTiet(int maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public int getMaDuyet() {
		return this.maDuyet;
	}

	public void setMaDuyet(int maDuyet) {
		this.maDuyet = maDuyet;
	}

	public int getMaMuon() {
		return this.maMuon;
	}

	public void setMaMuon(int maMuon) {
		this.maMuon = maMuon;
	}

	public int getSoHieuVkVlnCcht() {
		return this.soHieuVkVlnCcht;
	}

	public void setSoHieuVkVlnCcht(int soHieuVkVlnCcht) {
		this.soHieuVkVlnCcht = soHieuVkVlnCcht;
	}

}