package com.qlvk.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qlvk.entity.AppUser;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, String> {

    @Query(value = "SELECT e FROM AppUser e WHERE e.userName like %:userName%")
    public Page<AppUser> findUser(@Param("userName") String userName, Pageable pageable);

    @Query(value = "SELECT e FROM AppUser e left join UserRole f on e.userId = f.appUser.userId WHERE (:id = '' or e.userName like %:id% or e.name like %:id%) and f.appRole.roleId in ('1','3')")
    public Page<AppUser> findList(@Param("id") String id, Pageable pageable);
    
    @Query(value = "SELECT e FROM AppUser e WHERE e.userName = :userName")
    public Optional<AppUser> findUser(@Param("userName") String userName);
}