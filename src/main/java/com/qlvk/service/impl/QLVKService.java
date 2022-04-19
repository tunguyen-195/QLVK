package com.qlvk.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.TongLucModel;
import com.qlvk.model.VuKhiModel;
import com.qlvk.repository.IQLVKRepository;

@Service
public class QLVKService extends BaseService {

	@Autowired
	IQLVKRepository qlvkRepo;

	public Map<String, Object> getListTongLuc(String allSearch, int type) {
		List<Object[]> listSearch = qlvkRepo.findListTongLuc(type, allSearch);
		Map<String, Object> data = new HashMap<>();
		List<TongLucModel> listData = new ArrayList<>();
		TongLucModel tongLuc = null;
		int i = 0;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		for (Object[] object : listSearch) {
			i++;
			tongLuc = new TongLucModel();
			tongLuc.setStt(String.valueOf(i));
			tongLuc.setChungLoai(String.valueOf(object[0]));
			tongLuc.setNhanHieu(String.valueOf(object[1]));
			tongLuc.setNuocSanXuat(String.valueOf(object[2]));
			tongLuc.setSoHieu(String.valueOf(object[3]));
			tongLuc.setSoGiayPhep(String.valueOf(object[4]));
			tongLuc.setNgayCapPhep(format.format(object[5]));
			tongLuc.setCoGiaTriDen(format.format(object[6]));
			listData.add(tongLuc);
		}
		// Push data
		data.put(CommonConstant.DATA, listData);
		return data;
	}

	public Map<String, Object> getListVuKhi(String allSearch) {
		// Page<HoSo> listSearch = hoSoRepo.findList(allSearch,maDvNl,maLoai, pageable);
		Map<String, Object> data = new HashMap<>();
		List<VuKhiModel> listData = new ArrayList<>();
		VuKhiModel tongLuc = null;
		for (int i = 0; i < 10; i++) {
			tongLuc = new VuKhiModel();
			tongLuc.setImgPath(String.valueOf(i + 1) + ".png");
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