package com.qlvk.model;

import java.util.List;

public class ThuHoiModel {
	private int soBienBan;
	private int maMuon;
	private List<String> soHieuVK;

	public int getSoBienBan() {
		return soBienBan;
	}

	public void setSoBienBan(int soBienBan) {
		this.soBienBan = soBienBan;
	}

	public int getMaMuon() {
		return maMuon;
	}

	public void setMaMuon(int maMuon) {
		this.maMuon = maMuon;
	}

	public List<String> getSoHieuVK() {
		return soHieuVK;
	}

	public void setSoHieuVK(List<String> soHieuVK) {
		this.soHieuVK = soHieuVK;
	}

}
