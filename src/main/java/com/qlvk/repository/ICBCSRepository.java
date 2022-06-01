package com.qlvk.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;

public interface ICBCSRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT c.img_path, a.nhan_hieu_vk_vln_ccht " + "FROM vk_vln_ccht a "
			+ "LEFT JOIN gpsd b ON a.so_hieu_vk_vln_ccht = b.so_hieu_vk_vln_ccht "
			+ " LEFT JOIN img_vk c ON a.nhan_hieu_vk_vln_ccht = c.nhan_hieu_vk_vln_ccht "
			+ "WHERE (:chungLoai ='' OR a.chung_loai =:chungLoai) "
			+ "AND (:nhanHieu ='' OR a.nhan_hieu_vk_vln_ccht =:nhanHieu)", nativeQuery = true)
	public List<Object[]> getListImgVK(@Param("chungLoai") String chungLoai, @Param("nhanHieu") String nhanHieu);

	@Query(value = "SELECT count('so_hieu_vk_vln_ccht') " + "FROM vk_vln_ccht "
			+ "WHERE nhan_hieu_vk_vln_ccht =:nhanHieuVK ", nativeQuery = true)
	public int getTongSoLuong(@Param("nhanHieuVK") String nhanHieuVK);

	@Query(value = "SELECT count('so_hieu_vk_vln_ccht') " + "FROM danh_sach_muon "
			+ "WHERE nhan_hieu_vk_vln_ccht =:nhanHieuVK ", nativeQuery = true)
	public int getSoLuongDaMuon(@Param("nhanHieuVK") String nhanHieuVK);

	@Query(value = "SELECT a.ma_cbcs " + " FROM cbcs a " + " WHERE (a.user_id =:userId) ", nativeQuery = true)
	public int getMaCBCSByUserID(@Param("userId") String userId);

	// @Transactional
	// @Modifying
	// @Query(value = "UPDATE vk_vln_ccht "
	// + " SET so_luong_ton_kho = :soLuongTonKhoUpdate "
	// + " WHERE so_hieu_vk_vln_ccht = :sohieu ", nativeQuery = true)
	// public void updateVkVlnCcht(@Param("sohieu") int so_hieu_vk_vln_ccht,
	// @Param("soLuongTonKhoUpdate") int soLuongTonKhoUpdate);
}
