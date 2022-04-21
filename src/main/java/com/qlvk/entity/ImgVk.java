package com.qlvk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the img_vk database table.
 * 
 */
@Entity
@Table(name="img_vk")
@NamedQuery(name="ImgVk.findAll", query="SELECT i FROM ImgVk i")
public class ImgVk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nhan_hieu_vk_vln_ccht")
	private String nhanHieuVkVlnCcht;

	@Column(name="img_path")
	private String imgPath;

	public ImgVk() {
	}

	public String getNhanHieuVkVlnCcht() {
		return this.nhanHieuVkVlnCcht;
	}

	public void setNhanHieuVkVlnCcht(String nhanHieuVkVlnCcht) {
		this.nhanHieuVkVlnCcht = nhanHieuVkVlnCcht;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}