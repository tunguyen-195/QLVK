package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;

public interface IQLVKRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT a.chung_loai,a.nhan_hieu_vk_vln_ccht, a.nuoc_san_xuat, a.so_hieu_vk_vln_ccht, b.so_gpsd,b.ngay_cap, b.ngay_het_han, c.img_path "
			+ "FROM vk_vln_ccht a " + "LEFT JOIN gpsd b ON a.so_hieu_vk_vln_ccht = b.so_hieu_vk_vln_ccht "
			+ " LEFT JOIN img_vk c ON a.nhan_hieu_vk_vln_ccht = c.nhan_hieu_vk_vln_ccht "
			+ "WHERE (:type = 3 OR a.chung_loai =:type) "
			+ "AND (a.nhan_hieu_vk_vln_ccht like %:allSearch% OR a.nuoc_san_xuat like %:allSearch% OR a.so_hieu_vk_vln_ccht like %:allSearch% OR b.so_gpsd like %:allSearch%)", nativeQuery = true)
	public List<Object[]> findListTongLuc(@Param("type") int type, @Param("allSearch") String allSearch);
}