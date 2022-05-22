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

	public List<CBCSModel> getListImgVK(String chungLoai, String nhanHieu) {
		List<Object[]> listImgDB = rep.getListImgVK(chungLoai, nhanHieu);

		List<CBCSModel> outputList = new ArrayList<>();
		CBCSModel model;
		for (Object[] object : listImgDB) {
			model = new CBCSModel();
			model.setSoHieuVK(StringUtil.toString(object[0]));
			model.setSrcImg(StringUtil.toString(object[1]));
			model.setNhanHieu(StringUtil.toString(object[2]));
			outputList.add(model);
		}
		return outputList;
	}

	public CBCSModel getDetailVK(String soHieuVK) {
		List<Object[]> listDetail = rep.getDetailVK(soHieuVK);
		CBCSModel model = new CBCSModel();
		if (listDetail.size() != 0) {
			Object[] detail = listDetail.get(0);
			model.setSoHieuVK(StringUtil.toString(detail[0]));
			model.setChungLoai(StringUtil.toString(detail[1]));
			model.setNhanHieu(StringUtil.toString(detail[2]));
			model.setSoLuongTonKho(StringUtil.toString(detail[3]));
			model.setDonViTinh(StringUtil.toString(detail[4]));
			model.setNuocSx(StringUtil.toString(detail[5]));
		}
		return model;
	}

	public List<String> getAllChungLoai() {
		List<Object[]> listChungLoai = rep.getAllChungLoai();
		List<String> outputList = new ArrayList<>();
		for (Object[] object : listChungLoai) {
			outputList.add(StringUtil.toString(object[0]));
		}
		return outputList;
	}

	public List<String> getAllNhanHieu() {
		List<Object[]> listNhanHieu = rep.getAllNhanHieu();
		List<String> outputList = new ArrayList<>();
		for (Object[] object : listNhanHieu) {
			outputList.add(StringUtil.toString(object[0]));
		}
		return outputList;
	}

	public List<String> getNhanHieu(String chungLoai) {
		List<Object[]> listNhanHieu = rep.getNhanHieu(chungLoai);
		List<String> outputList = new ArrayList<>();
		for (Object[] object : listNhanHieu) {
			outputList.add(StringUtil.toString(object[0]));
		}
		return outputList;
	}

	public Map<String, Object> requestMuon(String userId, int soHieuVK, int soLuongMuon) {
		Map<String, Object> data = new HashMap<>();
		int soLuongTonKho = rep.getSoLuongTonKho(soHieuVK);
		if (soLuongMuon > soLuongTonKho) {
			data.put("statusCode", "200");
			data.put("messageWarning", "Số lượng mượn nhiều hơn số lượng hiện có. Vui lòng thay đổi số lượng mượn");
			return data;
		}
		// thêm vào danh sách mượn
		try {
			int maCbcs = rep.getMaCBCSByUserID(userId);
			DanhSachMuon dsMuon = new DanhSachMuon();
			dsMuon.setMaCbcs(maCbcs);
			dsMuon.setSoHieuVkVlnCcht(soHieuVK);
			dsMuon.setSoLuong(soLuongMuon);
			dsMuonRep.save(dsMuon);

			// update số lượng tồn kho
			int soLuong = soLuongTonKho - soLuongMuon;
			rep.updateVkVlnCcht(soHieuVK, soLuong);
			data.put("statusCode", "200");
			data.put("messageInfor", "Gửi yêu cầu mượn thành công");
		} catch (Exception e) {
			data.put("statusCode", "500");
			data.put("messageError", "Không thể gửi yêu cầu mượn, hãy thử lại sau");
		}

		return data;
	}
}
