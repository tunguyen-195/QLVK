package com.qlvk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

	@Query("SELECT e FROM AppUser e " + "Where e.userName = :userName")
	public AppUser findUserAccount(@Param("userName") String userName);

	@Query("SELECT e.locale FROM AppUser e " + "Where e.userName = :userName")
	public String getLocale(@Param("userName") String userName);
}
