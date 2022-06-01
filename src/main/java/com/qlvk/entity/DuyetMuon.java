package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the duyet_muon database table.
 * 
 */
@Entity
@Table(name="duyet_muon")
@NamedQuery(name="DuyetMuon.findAll", query="SELECT d FROM DuyetMuon d")
public class DuyetMuon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_duyet")
	private int maDuyet;

	@Column(name="ma_lanh_dao")
	private int maLanhDao;

	@Column(name="ma_muon")
	private int maMuon;

	@Column(name="so_hieu_vk_vln_ccht")
	private int soHieuVkVlnCcht;

	public DuyetMuon() {
	}

	public int getMaDuyet() {
		return this.maDuyet;
	}

	public void setMaDuyet(int maDuyet) {
		this.maDuyet = maDuyet;
	}

	public int getMaLanhDao() {
		return this.maLanhDao;
	}

	public void setMaLanhDao(int maLanhDao) {
		this.maLanhDao = maLanhDao;
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