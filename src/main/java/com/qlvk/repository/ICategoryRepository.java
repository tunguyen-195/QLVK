package com.qlvk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qlvk.entity.Category;
import com.qlvk.entity.CategoryPK;

public interface ICategoryRepository extends JpaRepository<Category, CategoryPK> {

	@Query("SELECT e FROM Category e " + "Where e.id.id = :id and locale = :locale order by e.range")
	public List<Category> getListCategory(@Param("id") String id, @Param("locale") String locale);

	@Query("SELECT e FROM Category e " + "Where e.id.id = :id and e.id.key = :key and locale = :locale order by e.range")
	public Category getCategory(@Param("id") String id, @Param("key") String key, @Param("locale") String locale);

	@Query("SELECT e.value FROM Category e " + "Where e.id.id = :id and e.id.key = :key and locale = :locale order by e.range")
	public String getValue(@Param("id") String id, @Param("key") String key, @Param("locale") String locale);

		@Query("SELECT e FROM Category e " + "Where e.id.id = :id and e.id.key IN :arrParam and locale = :locale order by e.range")
	public List<Category> getListCategory(@Param("id") String id, @Param("locale") String locale,  @Param("arrParam") String[] arrParam);
	
		@Query("SELECT e FROM Category e " + "Where e.id.id = :id and e.id.key NOT IN :arrParam and locale = :locale order by e.range")
	public List<Category> getListCategoryDistince(@Param("id") String id, @Param("locale") String locale,  @Param("arrParam") String[] arrParam);

		@Query("SELECT e.id.key FROM Category e " + "Where e.id.id = :id and e.value = :value and locale = :locale order by e.range")
		public String getKey(@Param("id") String id, @Param("value") String value, @Param("locale") String locale);
}