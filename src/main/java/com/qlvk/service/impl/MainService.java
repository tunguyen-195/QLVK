package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.model.MstScreenModel;

@Service
public class MainService extends BaseService {

	public List<MstScreenModel> getListScreen() {
		List<MstScreenModel> menuModelList = new ArrayList<>();

		return menuModelList;
	}
}