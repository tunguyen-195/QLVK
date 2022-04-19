package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.TongLucModel;
import com.qlvk.model.VuKhiModel;

@Service
public class QLVKService extends BaseService {

	public Map<String, Object> getListTongLuc(String allSearch, int start, String orderColumn, String orderDirection) {
		// Page<HoSo> listSearch = hoSoRepo.findList(allSearch,maDvNl,maLoai, pageable);
		Map<String, Object> data = new HashMap<>();
		List<TongLucModel> listData = new ArrayList<>();
		TongLucModel tongLuc = null;
		for (int i = 0; i < 20; i++) {
			tongLuc = new TongLucModel();
			tongLuc.setStt(String.valueOf(i + 1));
			tongLuc.setChungLoai("Súng tiểu liên AK" + " " + i);
			tongLuc.setNhanHieu("AK 47" + " " + i);
			tongLuc.setNuocSanXuat("Trung Quốc" + " " + i);
			tongLuc.setSoHieu("1238ERB847" + " " + i);
			tongLuc.setSoGiayPhep("1238ERB847/GP" + " " + i);
			tongLuc.setNgayCapPhep("19/5/1997" + " " + i);
			tongLuc.setCoGiaTriDen("19/05/2024" + " " + i);
			listData.add(tongLuc);
		}
		// Push data
		data.put(CommonConstant.DATA, listData);
		// data.put(CommonConstant.RECORD_TOTAL, listSearch.getTotalElements());
		// data.put(CommonConstant.RECORD_FILTERED, listSearch.getTotalElements());
		return data;
	}

	public Map<String, Object> getListVuKhi(String allSearch) {
		// Page<HoSo> listSearch = hoSoRepo.findList(allSearch,maDvNl,maLoai, pageable);
		Map<String, Object> data = new HashMap<>();
		List<VuKhiModel> listData = new ArrayList<>();
		VuKhiModel tongLuc = null;
		for (int i = 0; i < 10; i++) {
			tongLuc = new VuKhiModel();
			tongLuc.setImgPath(String.valueOf(i + 1) +".png");
			tongLuc.setSoLuong(String.valueOf(i + 1));
			tongLuc.setChungLoai("Súng tiểu liên AK" + " " + i);
			tongLuc.setNhanHieu("AK 47" + " " + i);
			tongLuc.setNuocSanXuat("Trung Quốc" + " " + i);
			tongLuc.setSoHieu("1238ERB847" + " " + i);
			tongLuc.setSoGiayPhep("1238ERB847/GP" + " " + i);
			tongLuc.setNgayCapPhep("19/5/1997" + " " + i);
			tongLuc.setCoGiaTriDen("19/05/2024" + " " + i);
			listData.add(tongLuc);
		}
		// Push data
		data.put(CommonConstant.DATA, listData);
		// data.put(CommonConstant.RECORD_TOTAL, listSearch.getTotalElements());
		// data.put(CommonConstant.RECORD_FILTERED, listSearch.getTotalElements());
		return data;
	}
}