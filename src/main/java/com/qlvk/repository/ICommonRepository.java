package com.qlvk.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ICommonRepository {

	@Autowired
	private EntityManager entityManager;

	public Integer nextVal(String tableId) {

		//String sql = "SELECT nextval(?)";
		//Query query = entityManager.createNativeQuery(sql);
		//query.setParameter(1, tableId);
		//return Integer.parseInt(query.getSingleResult().toString());
		
		String sql = "SELECT count(1) from " +tableId;
		Query query = entityManager.createNativeQuery(sql);
		//query.setParameter(1, tableId);
		return Integer.parseInt(query.getSingleResult().toString());
	}
}