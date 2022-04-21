package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cbql database table.
 * 
 */
@Entity
@NamedQuery(name="Cbql.findAll", query="SELECT c FROM Cbql c")
public class Cbql implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_cbql")
	private int maCbql;

	@Column(name="ten_tkql")
	private String tenTkql;

	public Cbql() {
	}

	public int getMaCbql() {
		return this.maCbql;
	}

	public void setMaCbql(int maCbql) {
		this.maCbql = maCbql;
	}

	public String getTenTkql() {
		return this.tenTkql;
	}

	public void setTenTkql(String tenTkql) {
		this.tenTkql = tenTkql;
	}

}