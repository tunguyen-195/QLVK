package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;

public interface ILanhDaoRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT b.so_hieu_cand, b.ho_ten, b.so_dien_thoai, a.nhan_hieu_vk_vln_ccht, "
			+ "a.so_luong, a.ly_do, a.ma_muon " + "FROM danh_sach_muon a INNER JOIN cbcs b ON a.ma_cbcs = b.ma_cbcs "
			+ "WHERE a.trang_thai_muon = '0' AND (:timKiem = '' OR (b.so_hieu_cand like %:timKiem% OR b.ho_ten like %:timKiem% "
			+ "OR b.so_dien_thoai like %:timKiem% OR a.nhan_hieu_vk_vln_ccht like %:timKiem% "
			+ "OR a.so_luong like %:timKiem% OR a.ly_do like %:timKiem%))", nativeQuery = true)
	public List<Object[]> getDatatable(@Param("timKiem") String timkiem);

	@Query(value = "SELECT a.ma_cbcs  FROM cbcs a  WHERE (a.user_id =:userId) ", nativeQuery = true)
	public int getMaLanhDao(@Param("userId") String userId);
}
