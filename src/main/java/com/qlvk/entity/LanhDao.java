package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lanh_dao database table.
 * 
 */
@Entity
@Table(name="lanh_dao")
@NamedQuery(name="LanhDao.findAll", query="SELECT l FROM LanhDao l")
public class LanhDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_lanh_dao")
	private int maLanhDao;

	@Column(name="ten_tkql")
	private String tenTkql;

	public LanhDao() {
	}

	public int getMaLanhDao() {
		return this.maLanhDao;
	}

	public void setMaLanhDao(int maLanhDao) {
		this.maLanhDao = maLanhDao;
	}

	public String getTenTkql() {
		return this.tenTkql;
	}

	public void setTenTkql(String tenTkql) {
		this.tenTkql = tenTkql;
	}

}