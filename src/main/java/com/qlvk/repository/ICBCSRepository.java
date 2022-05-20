package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;

public interface ICBCSRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT a.so_hieu_vk_vln_ccht, c.img_path, a.nhan_hieu_vk_vln_ccht "
			+ "FROM vk_vln_ccht a " + "LEFT JOIN gpsd b ON a.so_hieu_vk_vln_ccht = b.so_hieu_vk_vln_ccht "
			+ " LEFT JOIN img_vk c ON a.nhan_hieu_vk_vln_ccht = c.nhan_hieu_vk_vln_ccht "
			+ "WHERE (:chungLoai ='' OR a.chung_loai =:chungLoai) "
			+ "AND (:nhanHieu ='' OR a.nhan_hieu_vk_vln_ccht =:nhanHieu)", nativeQuery = true)
	public List<Object[]> getListImgVK(@Param("chungLoai") String chungLoai, @Param("nhanHieu") String nhanHieu);
	
	@Query(value = "SELECT a.so_hieu_vk_vln_ccht, a.chung_loai, a.nhan_hieu_vk_vln_ccht, "
			+ " a.so_luong_ton_kho, a.don_vi_tinh, a.nuoc_san_xuat, a.tinh_trang "
			+ "FROM vk_vln_ccht a "
			+ "WHERE (a.so_hieu_vk_vln_ccht =:soHieuVK) ", nativeQuery = true)
	public List<Object[]> getDetailVK(@Param("soHieuVK") String soHieuVK);
	
	@Query(value = "SELECT DISTINCT a.chung_loai FROM vk_vln_ccht a", nativeQuery = true)
	public List<Object[]> getAllChungLoai();
	
	@Query(value = "SELECT DISTINCT a.nhan_hieu_vk_vln_ccht FROM vk_vln_ccht a", nativeQuery = true)
	public List<Object[]> getAllNhanHieu();
	
	@Query(value = "SELECT DISTINCT a.nhan_hieu_vk_vln_ccht "
			+ " FROM vk_vln_ccht a "
			+ " WHERE (:chungLoai = '' OR a.chung_loai =:chungLoai) ", nativeQuery = true)
	public List<Object[]> getNhanHieu(@Param("chungLoai") String chungLoai);
	
	@Query(value = "SELECT a.so_luong_ton_kho "
			+ " FROM vk_vln_ccht a "
			+ " WHERE (a.so_hieu_vk_vln_ccht =:soHieuVK) ", nativeQuery = true)
	public int getSoLuongTonKho(@Param("soHieuVK") String soHieuVK);
}
