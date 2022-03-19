package com.qlvk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlvk.entity.AppRole;
import com.qlvk.entity.UserRole;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole, String> {
}