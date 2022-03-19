package com.qlvk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlvk.entity.UserRole;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, String> {

    @Query(value = "SELECT e FROM UserRole e WHERE"
            + " e.appUser.userId = :userId"
            + " AND e.delFlag = '0'")
    public UserRole findIdByOne(@Param("userId") String userId);
}