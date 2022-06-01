package com.qlvk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.DuyetMuon;

public interface IDuyetMuonRepository extends JpaRepository<DuyetMuon, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM danh_sach_muon WHERE ma_muon =:maMuon", nativeQuery = true)
	public void deleteByMaMuon(@Param("maMuon") int maMuon);
}