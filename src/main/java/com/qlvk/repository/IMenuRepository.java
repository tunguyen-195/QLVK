package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlvk.entity.MstScreen;

@Repository
public interface IMenuRepository  extends JpaRepository<MstScreen, String> {

	@Query(value = "SELECT MN FROM MstScreen MN WHERE MN.delFlag = '0' AND MN.locale = :locale ORDER BY cast(MN.orderDisplay as int)")
	public List<MstScreen> getListMenu(@Param("locale") String locale);
}