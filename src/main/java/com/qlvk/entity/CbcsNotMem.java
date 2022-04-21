package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cbcs_not_mem database table.
 * 
 */
@Entity
@Table(name="cbcs_not_mem")
@NamedQuery(name="CbcsNotMem.findAll", query="SELECT c FROM CbcsNotMem c")
public class CbcsNotMem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_cbcs_not_mem")
	private int maCbcsNotMem;

	@Column(name="ma_cbcs")
	private int maCbcs;

	@Column(name="so_hieu_cand")
	private String soHieuCand;

	public CbcsNotMem() {
	}

	public int getMaCbcsNotMem() {
		return this.maCbcsNotMem;
	}

	public void setMaCbcsNotMem(int maCbcsNotMem) {
		this.maCbcsNotMem = maCbcsNotMem;
	}

	public int getMaCbcs() {
		return this.maCbcs;
	}

	public void setMaCbcs(int maCbcs) {
		this.maCbcs = maCbcs;
	}

	public String getSoHieuCand() {
		return this.soHieuCand;
	}

	public void setSoHieuCand(String soHieuCand) {
		this.soHieuCand = soHieuCand;
	}

}