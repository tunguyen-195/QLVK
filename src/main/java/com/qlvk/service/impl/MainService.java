package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.entity.MstScreen;
import com.qlvk.model.MstScreenModel;
import com.qlvk.repository.IMenuRepository;

@Service
public class MainService extends BaseService {

	@Autowired
	IMenuRepository menu;

	public List<MstScreenModel> getListScreen() {
		List<MstScreen> menuList = menu.getListMenu(getUser().getLocale().toString().toLowerCase());
		List<MstScreenModel> menuModelList = new ArrayList<>();
		MstScreenModel menuModel = new MstScreenModel();
		int i = 0;
		int currentLevel = 999;
		String url = null;
		String classMarginLeft = null;
		int countStr = 0;
		int countEnd = 0;
		for (MstScreen mstScreen : menuList) {
			if (StringUtils.isEmpty(mstScreen.getRoleId()) || Arrays.asList(mstScreen.getRoleId().split(",")).contains(getUser().getRoleId())) {
				if (countEnd < countStr && i > 2
						&& (StringUtils.isEmpty(mstScreen.getUrl()) || Integer.parseInt(mstScreen.getLevel()) < currentLevel)) {
					menuModel.setModeGenerateHtml("END");
					countEnd++;
				}
				url = mstScreen.getUrl();
				classMarginLeft = " margin-left-" + mstScreen.getLevel() + " ";
				menuModel.setLevel(classMarginLeft);

				menuModel = new MstScreenModel();
				menuModel.setName(mstScreen.getName());
				menuModel.setUrl(url);
				menuModel.setAwesomeClass(mstScreen.getAwesomeClass());
				if (StringUtils.isEmpty(url)) {
					menuModel.setModeGenerateHtml("START");
					countStr++;
					if (mstScreen.getLevel().equals("1")) {
						menuModel.setLevel("nav-second-level" + classMarginLeft);
					} else if (mstScreen.getLevel().equals("2")) {
						menuModel.setLevel("nav nav-third-level" + classMarginLeft);
					}
				}
				currentLevel = Integer.parseInt(mstScreen.getLevel());
				menuModelList.add(menuModel);
				i++;
			}
		}
		while (countEnd < countStr) {
			menuModel.setModeGenerateHtml("END");
			countEnd++;
		}
		return menuModelList;
	}
}