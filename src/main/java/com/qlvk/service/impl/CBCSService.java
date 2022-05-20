package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.ast.tools.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.DanhSachMuon;
import com.qlvk.model.CBCSModel;
import com.qlvk.repository.ICBCSRepository;

@Service
public class CBCSService extends BaseService {
	@Autowired
	ICBCSRepository rep;

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
			model.setTinhTrang(StringUtil.toString(detail[6]));
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
	
	public boolean requestMuon(String soHieuVK, int soLuongMuon) {
		int soLuongTonKho = rep.getSoLuongTonKho(soHieuVK);
		if(soLuongMuon > soLuongTonKho) {
			return false;
		}
		
		
		
		
		return true;
	}
}
