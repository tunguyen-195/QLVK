package com.qlvk.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;

public interface ICBQLRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT so_hieu_vk_vln_ccht, chung_loai, nhan_hieu_vk_vln_ccht, nuoc_san_xuat, tinh_trang, don_vi_tinh "
			+ "FROM vk_vln_ccht " + "WHERE (:chungLoai = '' or chung_loai =:chungLoai) "
			+ "AND (:nhanHieu = '' or nhan_hieu_vk_vln_ccht =:nhanHieu) "
			+ "AND (:tinhTrang = '' or tinh_trang =:tinhTrang)", nativeQuery = true)
	public List<Object[]> getDSVuKhi(@Param("chungLoai") String chungLoai, @Param("nhanHieu") String nhanHieu,
			@Param("tinhTrang") String tinhTrang);

	@Query(value = "SELECT a.ho_ten as 'lanhDaoDuyet', d.so_hieu_cand, d.ho_ten as 'hoTenCBCS',"
			+ " b.so_hieu_vk_vln_ccht, c.nhan_hieu_vk_vln_ccht, c.so_luong, c.ma_muon, b.ma_duyet "
			+ "FROM cbcs a INNER JOIN duyet_muon b ON a.ma_cbcs = b.ma_lanh_dao "
			+ "INNER JOIN danh_sach_muon c ON b.ma_muon = c.ma_muon " + "INNER JOIN cbcs d ON c.ma_cbcs = d.ma_cbcs "
			+ "WHERE c.trang_thai_muon = '1' :timKiem = '' OR (a.ho_ten like %:timKiem% OR d.so_hieu_cand like %:timKiem% "
			+ "OR d.ho_ten like %:timKiem% OR b.so_hieu_vk_vln_ccht like %:timKiem% "
			+ "OR c.nhan_hieu_vk_vln_ccht like %:timKiem%) ", nativeQuery = true)
	public List<Object[]> getDSMuon(@Param("timKiem") String timKiem);

	@Query(value = "SELECT e.so_hieu_cand as 'soHieuCBCS', e.ho_ten as 'hoTenCBCS', a.so_hieu_vk_vln_ccht, "
			+ " c.nhan_hieu_vk_vln_ccht, c.so_luong, b.ngay_muon, f.so_hieu_cand as 'soHieuCBQL', "
			+ " f.ho_ten as 'hoTenCBQL', d.ho_ten as 'lanhDaoDuyet' "
			+ "FROM duyet_muon a INNER JOIN bien_ban b ON a.ma_duyet = b.ma_duyet "
			+ "INNER JOIN danh_sach_muon c ON a.ma_muon = c.ma_muon "
			+ "INNER JOIN  cbcs d ON a.ma_lanh_dao = d.ma_cbcs " + "INNER JOIN cbcs e ON c.ma_cbcs = e.ma_cbcs "
			+ "INNER JOIN cbcs f ON b.ma_cbql = f.ma_cbcs "
			+ "WHERE :timKiem = '' OR (e.so_hieu_cand like %:timKiem% OR e.ho_ten like %:timKiem% OR a.so_hieu_vk_vln_ccht like %:timKiem% "
			+ "OR c.nhan_hieu_vk_vln_ccht like %:timKiem% OR f.so_hieu_cand like %:timKiem% "
			+ "OR f.ho_ten like %:timKiem% OR d.ho_ten like %:timKiem%)", nativeQuery = true)
	public List<Object[]> getDSTra(@Param("timKiem") String timKiem);

	@Query(value = "SELECT so_hieu_vk_vln_ccht FROM vk_vln_ccht WHERE nhan_hieu_vk_vln_ccht =:nhanHieu ", nativeQuery = true)
	public List<Integer> getSoHieu(@Param("nhanHieu") String nhanHieu);

	@Transactional
	@Modifying
	@Query(value = "UPDATE vk_vln_ccht SET tinh_trang = '1' "
			+ "WHERE so_hieu_vk_vln_ccht =:soHieu", nativeQuery = true)
	public void updateTinhTrangVK(@Param("soHieu") int soHieu);

	@Transactional
	@Modifying
	@Query(value = "UPDATE danh_sach_muon SET trang_thai_muon = '2' WHERE ma_muon =:maMuon", nativeQuery = true)
	public void updateTrangThaiMuon(@Param("maMuon") int maMuon);

	@Transactional
	@Modifying
	@Query(value = "UPDATE danh_sach_muon SET trang_thai_muon = '3' WHERE ma_muon =:maMuon", nativeQuery = true)
	public void updateTrangThaiHuy(@Param("maMuon") int maMuon);

	@Transactional
	@Modifying
	@Query(value = "UPDATE duyet_muon SET so_hieu_vk_vln_ccht = :soHieuVK "
			+ "WHERE ma_muon =:maMuon AND ma_duyet=:maDuyet ", nativeQuery = true)
	public void updateSohieuVK(@Param("maDuyet") int maDuyet, @Param("maMuon") int maMuon,
			@Param("soHieuVK") int soHieuVK);

	@Query(value = "SELECT a.ma_cbcs  FROM cbcs a  WHERE (a.user_id =:userId) ", nativeQuery = true)
	public int getMaCBCSByUserID(@Param("userId") String userId);
}
