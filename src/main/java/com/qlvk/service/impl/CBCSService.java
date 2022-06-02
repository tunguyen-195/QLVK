package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.DanhSachMuon;
import com.qlvk.model.CBCSModel;
import com.qlvk.repository.ICBCSRepository;
import com.qlvk.repository.IDanhSachMuonRepository;
import com.qlvk.repository.IVkVlnCchtRepository;

@Service
public class CBCSService extends BaseService {
	@Autowired
	ICBCSRepository rep;
	@Autowired
	IDanhSachMuonRepository dsMuonRep;
	@Autowired
	IVkVlnCchtRepository vkVlnCchtRep;

	// create image by chungLoai, nhanHieu
	public List<CBCSModel> getListImgVK(String chungLoai, String nhanHieu) {

		List<Object[]> listImgDB = rep.getListImgVK(chungLoai, nhanHieu);
		List<CBCSModel> outputList = new ArrayList<>();
		CBCSModel model;
		for (Object[] object : listImgDB) {
			model = new CBCSModel();
			model.setSrcImg(StringUtil.toString(object[0]));
			model.setNhanHieu(StringUtil.toString(object[1]));
			outputList.add(model);
		}
		return outputList;
	}

	public CBCSModel getSoLuong(String nhanHieuVK) {
		CBCSModel model = new CBCSModel();
		model.setNhanHieu(nhanHieuVK);
		int tongSL = rep.getTongSoLuong(nhanHieuVK);
		int sLDaMuon = rep.getSoLuongDaMuon(nhanHieuVK);
		model.setSoLuongConLai(tongSL - sLDaMuon);
		return model;
	}

	public Map<String, Object> requestMuon(String userId, String nhanHieuVK, int soLuongMuon, String lyDo) {
		Map<String, Object> data = new HashMap<>();
		int soLuongConLai = rep.getTongSoLuong(nhanHieuVK) - rep.getSoLuongDaMuon(nhanHieuVK);
		if (soLuongMuon > soLuongConLai) {
			data.put("statusCode", "200");
			data.put("messageWarning", "Số lượng mượn nhiều hơn số lượng hiện có. Vui lòng thay đổi số lượng mượn");
			return data;
		}
		// thêm vào danh sách mượn
		try {
			int maCbcs = rep.getMaCBCSByUserID(userId);
			DanhSachMuon dsMuon = new DanhSachMuon();
			dsMuon.setMaCbcs(maCbcs);
			dsMuon.setNhanHieuVkVlnCcht(nhanHieuVK);
			dsMuon.setSoLuong(soLuongMuon);
			dsMuon.setTrangThaiMuon(0);
			dsMuon.setLyDo(lyDo);
			dsMuonRep.save(dsMuon);
			data.put("statusCode", "200");
			data.put("messageInfor", "Gửi yêu cầu mượn thành công");
		} catch (Exception e) {
			data.put("statusCode", "500");
			data.put("messageError", "Không thể gửi yêu cầu mượn, hãy thử lại sau");
		}

		return data;
	}
}
