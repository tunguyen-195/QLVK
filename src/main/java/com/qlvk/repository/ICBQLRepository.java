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
			+ "WHERE c.trang_thai_muon = '1' AND (:timKiem = '' OR (a.ho_ten like %:timKiem% OR d.so_hieu_cand like %:timKiem% "
			+ "OR d.ho_ten like %:timKiem% OR b.so_hieu_vk_vln_ccht like %:timKiem% "
			+ "OR c.nhan_hieu_vk_vln_ccht like %:timKiem%)) ", nativeQuery = true)
	public List<Object[]> getDSMuon(@Param("timKiem") String timKiem);

	@Query(value = "SELECT e.so_hieu_cand as 'soHieuCBCS', e.ho_ten as 'hoTenCBCS', "
			+ " c.nhan_hieu_vk_vln_ccht, c.so_luong, b.ngay_muon, f.so_hieu_cand as 'soHieuCBQL', "
			+ " f.ho_ten as 'hoTenCBQL', d.ho_ten as 'lanhDaoDuyet', e.don_vi, c.ma_muon, b.so_bien_ban "
			+ "FROM duyet_muon a INNER JOIN bien_ban b ON a.ma_duyet = b.ma_duyet "
			+ "INNER JOIN danh_sach_muon c ON a.ma_muon = c.ma_muon AND c.trang_thai_muon = '2' "
			+ "INNER JOIN  cbcs d ON a.ma_lanh_dao = d.ma_cbcs " + "INNER JOIN cbcs e ON c.ma_cbcs = e.ma_cbcs "
			+ "INNER JOIN cbcs f ON b.ma_cbql = f.ma_cbcs "
			+ "WHERE :timKiem = '' OR (e.so_hieu_cand like %:timKiem% OR e.ho_ten like %:timKiem% "
			+ "OR c.nhan_hieu_vk_vln_ccht like %:timKiem% OR f.so_hieu_cand like %:timKiem% "
			+ "OR f.ho_ten like %:timKiem% OR d.ho_ten like %:timKiem%)", nativeQuery = true)
	public List<Object[]> getDSTra(@Param("timKiem") String timKiem);

	@Query(value = "SELECT so_hieu_vk_vln_ccht FROM vk_vln_ccht WHERE nhan_hieu_vk_vln_ccht =:nhanHieu ", nativeQuery = true)
	public List<Integer> getSoHieuVK(@Param("nhanHieu") String nhanHieu);

	@Transactional
	@Modifying
	@Query(value = "UPDATE vk_vln_ccht SET tinh_trang =:tinhTrang "
			+ "WHERE so_hieu_vk_vln_ccht =:soHieu", nativeQuery = true)
	public void updateTinhTrangVK(@Param("soHieu") int soHieu, @Param("tinhTrang") int tinhTrang);

	@Transactional
	@Modifying
	@Query(value = "UPDATE danh_sach_muon SET trang_thai_muon =:trangThai WHERE ma_muon =:maMuon", nativeQuery = true)
	public void updateTrangThaiMuon(@Param("maMuon") int maMuon, @Param("trangThai") int trangThai);

	@Transactional
	@Modifying
	@Query(value = "UPDATE duyet_muon SET so_hieu_vk_vln_ccht = :soHieuVK "
			+ "WHERE ma_muon =:maMuon AND ma_duyet=:maDuyet ", nativeQuery = true)
	public void updateSohieuVK(@Param("maDuyet") int maDuyet, @Param("maMuon") int maMuon,
			@Param("soHieuVK") int soHieuVK);

	@Query(value = "SELECT a.ma_cbcs  FROM cbcs a  WHERE (a.user_id =:userId) ", nativeQuery = true)
	public int getMaCBCSByUserID(@Param("userId") String userId);

	@Query(value = "SELECT a.user_id  FROM cbcs a  WHERE (a.ma_cbcs =:maCBCS) ", nativeQuery = true)
	public String getUserIDByMaCBCS(@Param("maCBCS") int maCBCS);

	@Query(value = "SELECT a.chung_loai, a.nhan_hieu_vk_vln_ccht, a.so_hieu_vk_vln_ccht, a.nuoc_san_xuat, "
			+ "b.so_gpsd, b.ngay_cap, b.ngay_het_han FROM vk_vln_ccht a left join gpsd b on a.so_hieu_vk_vln_ccht = b.so_hieu_vk_vln_ccht "
			+ " WHERE (:chungLoai = '' or a.chung_loai =:chungLoai) "
			+ "AND (:nhanHieu = '' or a.nhan_hieu_vk_vln_ccht =:nhanHieu) "
			+ "AND (:tinhTrang = '' or a.tinh_trang =:tinhTrang)", nativeQuery = true)
	public List<Object[]> getDSVuKhiDownload(@Param("chungLoai") String chungLoai, @Param("nhanHieu") String nhanHieu,
			@Param("tinhTrang") String tinhTrang);

	@Query(value = "select a.ma_cbcs, a.nhan_hieu_vk_vln_ccht, d.so_hieu_vk_vln_ccht, so_luong, ly_do from danh_sach_muon a "
			+ "INNER JOIN duyet_muon b ON a.ma_muon = b.ma_muon "
			+ "INNER JOIN chi_tiet_muon d ON a.ma_muon = d.ma_muon "
			+ "INNER JOIN bien_ban c ON b.ma_duyet = c.ma_duyet " + "WHERE a.trang_thai_muon = '2' "
			+ "AND (((:ngayBatDau = '' AND :ngayKetThuc = '') OR c.ngay_muon BETWEEN :ngayBatDau AND :ngayKetThuc) "
			+ "OR (:ngayBatDau = '' OR c.ngay_muon <= :ngayKetThuc) "
			+ "OR (:ngayKetThuc = '' OR c.ngay_muon >= :ngayBatDau))", nativeQuery = true)
	public List<Object[]> getDSBaocao(@Param("ngayBatDau") String ngayBatDau, @Param("ngayKetThuc") String ngayKetThuc);

	@Query(value = "SELECT b.chung_loai, b.nhan_hieu_vk_vln_ccht, b.so_hieu_vk_vln_ccht, '1', c.ly_do "
			+ "FROM danh_sach_muon c INNER JOIN chi_tiet_muon a ON c.ma_muon = a.ma_muon "
			+ "INNER JOIN vk_vln_ccht b ON a.so_hieu_vk_vln_ccht = b.so_hieu_vk_vln_ccht "
			+ "WHERE a.ma_muon = :maMuon" , nativeQuery = true)
	public List<Object[]> getDataBienBan(@Param("maMuon") int maMuon);
	
	@Query(value = "SELECT b.ho_ten as 'hoTenCBCS', b.so_hieu_cand as 'soHieuCBCS', e.ngay_muon, "
			+ "f.ho_ten as 'hoTenCBQL', f.so_hieu_cand as 'soHieuCBQL', "
			+ "d.ho_ten as 'hoTenLanhDao', a.so_luong "
			+ "FROM danh_sach_muon a INNER JOIN cbcs b ON a.ma_cbcs = b.ma_cbcs AND a.trang_thai_muon = '2' "
			+ "INNER JOIN duyet_muon c ON a.ma_muon = c.ma_muon "
			+ "INNER JOIN cbcs d ON c.ma_lanh_dao = d.ma_cbcs "
			+ "INNER JOIN bien_ban e ON c.ma_duyet = e.ma_duyet "
			+ "INNER JOIN cbcs f ON e.ma_cbql = f.ma_cbcs "
			+ "WHERE a.ma_muon = :maMuon", nativeQuery = true)
	public List<Object[]> getBienBanInfo(@Param("maMuon") int maMuon);

	@Query(value = "SELECT so_hieu_vk_vln_ccht FROM chi_tiet_muon WHERE ma_muon =:maMuon ", nativeQuery = true)
	public List<Integer> getDsSoHieu(@Param("maMuon") int maMuon);
}
