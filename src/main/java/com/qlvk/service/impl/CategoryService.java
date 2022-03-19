package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.entity.Category;
import com.qlvk.model.CategoryModel;
import com.qlvk.repository.ICategoryRepository;

@Service
public class CategoryService extends BaseService {

	@Autowired
	ICategoryRepository categoryRepo;

	//@Autowired
	//IMstAnkenRepository ankenRepo;

	//@Autowired
	//IMstFunctionRepository functionRepo;

	public List<CategoryModel> getListCategory(String id) {

		CategoryModel model = null;
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		List<Category> subjectList = categoryRepo.getListCategory(id, getUser().getLocale().toString().toLowerCase());
		for (Category category : subjectList) {
			model = new CategoryModel();
			model.setKey(category.getId().getKey());
			model.setValue(category.getValue());
			list.add(model);
		}
		return list;
	}

	public CategoryModel getCategory(String id, String key) {

		CategoryModel model = null;
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		Category category = categoryRepo.getCategory(id, key, getUser().getLocale().toString().toLowerCase());
		model = new CategoryModel();
		model.setKey(category.getId().getKey());
		model.setValue(category.getValue());
		list.add(model);
		return model;
	}

	public String getValue(String id, String key) {

		return categoryRepo.getValue(id, key, getUser().getLocale().toString().toLowerCase());
	}

	public String getValue(List<CategoryModel> list, String key) {
		if (StringUtils.isEmpty(key)) {
			return StringUtils.EMPTY;
		}
		for (CategoryModel categoryModel : list) {
			if (StringUtils.equals(key, categoryModel.getKey())) {
				return categoryModel.getValue();
			}
		}
		return StringUtils.EMPTY;
	}
	public String getKey(String id, String value) {

		return StringUtils.defaultString(categoryRepo.getKey(id, value, getUser().getLocale().toString().toLowerCase()));
	}
	public String getKey(List<CategoryModel> list, String value) {
		if (StringUtils.isEmpty(value)) {
			return StringUtils.EMPTY;
		}
		for (CategoryModel categoryModel : list) {
			if (StringUtils.equals(value, categoryModel.getValue())) {
				return categoryModel.getKey();
			}
		}
		return StringUtils.EMPTY;
	}
	public String getKeyD(List<CategoryModel> list, String value) {
		if (StringUtils.isEmpty(value)) {
			return list.get(0).getKey();
		}
		for (CategoryModel categoryModel : list) {
			if (StringUtils.equals(value, categoryModel.getValue())) {
				return categoryModel.getKey();
			}
		}
		return list.get(0).getKey();
	}
//	public List<Map<String, String>> findAllAnkenId() {
//
//		List<Object[]> listAnkenId = ankenRepo.findAllAnkenId();
//		List<Map<String, String>> list = new ArrayList<>();
//		Map<String, String> map = null;
//		for (Object[] objects : listAnkenId) {
//			map = new HashMap<>();
//			map.put("id", String.valueOf(objects[0]));
//			map.put("ankenId", String.valueOf(objects[1]));
//			list.add(map);
//		}
//		return list;
//	}

	public Object getListCategory(String id, String[] arrParam) {
		CategoryModel model = null;
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		List<Category> subjectList = categoryRepo.getListCategory(id, getUser().getLocale().toString().toLowerCase(),
				arrParam);
		for (Category category : subjectList) {
			model = new CategoryModel();
			model.setKey(category.getId().getKey());
			model.setValue(category.getValue());
			list.add(model);
		}
		return list;
	}
	public List<CategoryModel> getListCategoryDistince(String id, String[] arrParam) {
		CategoryModel model = null;
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		List<Category> subjectList = categoryRepo.getListCategoryDistince(id, getUser().getLocale().toString().toLowerCase(),
				arrParam);
		for (Category category : subjectList) {
			model = new CategoryModel();
			model.setKey(category.getId().getKey());
			model.setValue(category.getValue());
			list.add(model);
		}
		return list;
	}

//	public List<Map<String, String>> findAllFunctionNo() {
//		List<Object[]> listAnkenId = functionRepo.findAllFunctionNo();
//		List<Map<String, String>> list = new ArrayList<>();
//		Map<String, String> map = null;
//		for (Object[] objects : listAnkenId) {
//			map = new HashMap<>();
//			map.put("ankenId", String.valueOf(objects[1]));
//			map.put("functionNo", String.valueOf(objects[2]));
//			map.put("functionId", String.valueOf(objects[3]));
//			list.add(map);
//		}
//		return list;
//	}

}