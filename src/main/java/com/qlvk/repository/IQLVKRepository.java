/**
 * (c)Copyright Since 2018, KISOJI. All rights reserved.
 *
 */
package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlvk.entity.Category;

/**
 * Booking Basic Repository.<BR>
 * <BR>
 * Access data Booking Basic from database.<BR>
 */
public interface IQLVKRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT a.chungLoai,a.nhanHieuVK_VLN_CCHT, a.nuocSanXuat, a.soHieuVK_VLN_CCHT, b.soGPSD,b.ngayCap, b.ngayHetHan FROM vk_vln_ccht a left join gpsd b on a.soHieuVK_VLN_CCHT = b.soHieuVK_VLN_CCHT ", nativeQuery = true)
	public List<Object[]> findListTongLuc();
}