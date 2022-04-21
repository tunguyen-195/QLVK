package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ma_admin")
	private int maAdmin;

	@Column(name="ten_tkql")
	private String tenTkql;

	public Admin() {
	}

	public int getMaAdmin() {
		return this.maAdmin;
	}

	public void setMaAdmin(int maAdmin) {
		this.maAdmin = maAdmin;
	}

	public String getTenTkql() {
		return this.tenTkql;
	}

	public void setTenTkql(String tenTkql) {
		this.tenTkql = tenTkql;
	}

}