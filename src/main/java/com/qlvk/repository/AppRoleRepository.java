package com.qlvk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qlvk.entity.UserRole;

@Repository
public class AppRoleRepository {

   @Autowired
   private EntityManager entityManager;

   public List<String> getRoleNames(String userId) {
       String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
               + " where ur.appUser.userId = :userId ";

       Query query = this.entityManager.createQuery(sql, String.class);
       query.setParameter("userId", userId);
       return query.getResultList();
   }
   public List<String> getRoleId(String userId) {
       String sql = "Select ur.appRole.roleId from " + UserRole.class.getName() + " ur " //
               + " where ur.appUser.userId = :userId ";

       Query query = this.entityManager.createQuery(sql, String.class);
       query.setParameter("userId", userId);
       return query.getResultList();
   }

}