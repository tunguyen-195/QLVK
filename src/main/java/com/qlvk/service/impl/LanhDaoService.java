package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.DanhSachMuon;
import com.qlvk.entity.DuyetMuon;
import com.qlvk.model.LanhDaoModel;
import com.qlvk.repository.IDanhSachMuonRepository;
import com.qlvk.repository.IDuyetMuonRepository;
import com.qlvk.repository.ILanhDaoRepository;

@Service
public class LanhDaoService extends BaseService {

	@Autowired
	ILanhDaoRepository rep;
	@Autowired
	IDanhSachMuonRepository dsMuonRep;
	@Autowired
	IDuyetMuonRepository duyetMuonRep;

	public Map<String, Object> getDatatable(String timKiem) {
		Map<String, Object> data = new HashMap<>();
		List<LanhDaoModel> listOut = new ArrayList<>();
		LanhDaoModel model = null;
		List<Object[]> dsMuon = rep.getDatatable(timKiem);

		for (Object[] object : dsMuon) {
			model = new LanhDaoModel();
			model.setSoHieuCAND(StringUtil.toString(object[0]));
			model.setHoTen(StringUtil.toString(object[1]));
			model.setSdt(StringUtil.toString(object[2]));
			model.setNhanHieu(StringUtil.toString(object[3]));
			model.setSoLuong(Integer.parseInt(StringUtil.toString(object[4])));
			model.setLyDo(StringUtil.toString(object[5]));
			model.setMaMuon(Integer.parseInt(StringUtil.toString(object[6])));
			listOut.add(model);
		}

		data.put("statusCode", "200");
		data.put(CommonConstant.DATA, listOut);

		return data;
	}

	public Map<String, Object> duyetMuon(int maMuon, String userId) {
		Map<String, Object> data = new HashMap<>();

		// kiểm tra tồn tại yêu cầu mượn
		DanhSachMuon dsMuon = dsMuonRep.getOne(maMuon);
		if (dsMuon == null) {
			data.put("statusCode", "500");
			data.put("messageError", "Không tồn tại yêu cầu mượn");
			return data;
		}
		// update trạng thái mượn thành 1 (lãnh đạo đã duyệt)
		dsMuon.setTrangThaiMuon(1);
		dsMuonRep.save(dsMuon);
		// lấy mã lãnh đạo bằng userId đang login
		int maLanhDao = rep.getMaLanhDao(userId);
		// insert data vào table duyet_muon
		DuyetMuon duyetMuon = new DuyetMuon();
		duyetMuon.setMaLanhDao(maLanhDao);
		duyetMuon.setMaMuon(maMuon);
		duyetMuonRep.save(duyetMuon);
		data.put("statusCode", "200");
		data.put("messageInfo", "Chấp nhận yêu cầu mượn thành công");
		return data;
	}

	public Map<String, Object> tuChoi(int maMuon) {
		Map<String, Object> data = new HashMap<>();

		// kiểm tra tồn tại yêu cầu mượn
		DanhSachMuon dsMuon = dsMuonRep.getOne(maMuon);
		if (dsMuon == null) {
			data.put("statusCode", "500");
			data.put("messageError", "Không tồn tại yêu cầu mượn");
			return data;
		}
		// update trạng thái mượn thành 3 (lãnh đạo từ chối)
		dsMuon.setTrangThaiMuon(3);
		dsMuonRep.save(dsMuon);
		data.put("statusCode", "200");
		data.put("messageInfo", "Từ chối yêu cầu mượn thành công");
		return data;

	}
}
