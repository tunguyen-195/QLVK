package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.BienBan;
import com.qlvk.entity.ChiTietMuon;
import com.qlvk.entity.DanhSachMuon;
import com.qlvk.entity.DuyetMuon;
import com.qlvk.entity.VkVlnCcht;
import com.qlvk.model.DanhSachMuonModel;
import com.qlvk.model.DanhSachTraModel;
import com.qlvk.model.DanhSachVKModel;
import com.qlvk.repository.IBienBanRepository;
import com.qlvk.repository.ICBQLRepository;
import com.qlvk.repository.IChiTietMuonRepository;
import com.qlvk.repository.IDanhSachMuonRepository;
import com.qlvk.repository.IDuyetMuonRepository;
import com.qlvk.repository.IVkVlnCchtRepository;

@Service
public class CBQLService extends BaseService {
	@Autowired
	ICBQLRepository rep;
	@Autowired
	IVkVlnCchtRepository vkRep;
	@Autowired
	IDanhSachMuonRepository dsMuonRep;
	@Autowired
	IBienBanRepository bienBanRep;
	@Autowired
	IDuyetMuonRepository duyetMuonRep;
	@Autowired
	IChiTietMuonRepository chiTietRep;
	@Autowired
	MessageSource message;

	public List<DanhSachVKModel> getDanhSachVK(String chungLoai, String nhanHieu, String tinhTrang) {
		List<DanhSachVKModel> outputList = new ArrayList<>();
		List<Object[]> danhSachVK = rep.getDSVuKhi(chungLoai, nhanHieu, tinhTrang);
		DanhSachVKModel model = null;
		for (Object[] object : danhSachVK) {
			model = new DanhSachVKModel();
			model.setSoHieu(Integer.parseInt(StringUtil.toString(object[0])));
			model.setChungLoai(StringUtil.toString(object[1]));
			model.setNhanHieu(StringUtil.toString(object[2]));
			model.setNuocSX(StringUtil.toString(object[3]));
			switch (StringUtil.toString(object[4])) {
			case "0":
				model.setTinhTrang("Còn");
				break;
			case "1":
				model.setTinhTrang("Đã mượn");
				break;
			case "2":
				model.setTinhTrang("Hỏng");
				break;
			default:
				model.setTinhTrang("Không xác định");
			}
			model.setDonViTinh(StringUtil.toString(object[5]));
			outputList.add(model);
		}
		return outputList;
	}

	public List<DanhSachMuonModel> getDanhSachMuon(String timKiem) {

		List<DanhSachMuonModel> outputList = new ArrayList<>();
		DanhSachMuonModel model = null;
		List<Object[]> danhSachMuon = rep.getDSMuon(timKiem);
		for (Object[] object : danhSachMuon) {
			model = new DanhSachMuonModel();
			model.setLanhDaoDuyet(StringUtil.toString(object[0]));
			model.setSoHieuCBCS(StringUtil.toString(object[1]));
			model.setHoTenCBCS(StringUtil.toString(object[2]));
			model.setSoHieuVK(StringUtil.toString(object[3]));
			model.setNhanHieuVK(StringUtil.toString(object[4]));
			model.setSoLuong(Integer.parseInt(StringUtil.toString(object[5])));
			model.setMaMuon(Integer.parseInt(StringUtil.toString(object[6])));
			model.setMaDuyet(Integer.parseInt(StringUtil.toString(object[7])));
			outputList.add(model);
		}

		return outputList;
	}

	public List<DanhSachTraModel> getDanhSachTra(String timKiem) {

		List<DanhSachTraModel> outputList = new ArrayList<>();
		DanhSachTraModel model = null;
		List<Object[]> danhSachTra = rep.getDSTra(timKiem);
		for (Object[] object : danhSachTra) {
			model = new DanhSachTraModel();
			model.setSoHieuCBCS(StringUtil.toString(object[0]));
			model.setHoTenCBCS(StringUtil.toString(object[1]));
			model.setSoHieuVK(StringUtil.toString(object[2]));
			model.setNhanHieuVK(StringUtil.toString(object[3]));
			model.setSoLuong(Integer.parseInt(StringUtil.toString(object[4])));
			model.setNgayMuon(StringUtil.toString(object[5]));
			model.setSoHieuCBQL(StringUtil.toString(object[6]));
			model.setHoTenCBQL(StringUtil.toString(object[7]));
			model.setLanhDaoDuyet(StringUtil.toString(object[8]));
			outputList.add(model);
		}

		return outputList;
	}

	public Map<String, Object> addVK(DanhSachVKModel model) {
		Map<String, Object> out = new HashMap<>();
		if (vkRep.existsById(model.getSoHieu())) {
			out.put("statusCode", "500");
			out.put("messageError", "Số hiệu đã tồn tại");
			return out;
		}
		VkVlnCcht entity = new VkVlnCcht();
		entity.setSoHieuVkVlnCcht(model.getSoHieu());
		entity.setChungLoai(model.getChungLoai());
		entity.setNhanHieuVkVlnCcht(model.getNhanHieu());
		entity.setDonViTinh(model.getDonViTinh());
		entity.setNuocSanXuat(model.getNuocSX());
		entity.setTinhTrang(model.getTinhTrang());
		vkRep.save(entity);
		out.put("statusCode", "200");
		out.put("messageInfor", "Thêm mới thành công");
		return out;
	}

	public Map<String, Object> updateVK(DanhSachVKModel model) {
		Map<String, Object> out = new HashMap<>();
		VkVlnCcht entity = vkRep.getOne(model.getSoHieu());
		if (entity != null) {
			entity.setChungLoai(model.getChungLoai());
			entity.setNhanHieuVkVlnCcht(model.getNhanHieu());
			entity.setDonViTinh(model.getDonViTinh());
			entity.setNuocSanXuat(model.getNuocSX());
			entity.setTinhTrang(model.getTinhTrang());
			vkRep.save(entity);
			out.put("statusCode", "200");
			out.put("messageInfor", "Cập nhật thành công");
		} else {
			out.put("statusCode", "500");
			out.put("messageInfor", "Cập nhật thất bại");
		}
		return out;
	}

	public Map<String, Object> delVK(int soHieu) {
		Map<String, Object> out = new HashMap<>();
		VkVlnCcht entity = vkRep.getOne(soHieu);
		if (entity == null) {
			out.put("statusCode", "500");
			out.put("messageInfor", "Vũ khí không tồn tại");
		} else {
			vkRep.deleteById(soHieu);
			out.put("statusCode", "200");
			out.put("messageInfor", "Xóa thành công");
		}
		return out;
	}

	public List<String> getSoHieu(String nhanHieu) {
		List<Integer> listSoHieu = rep.getSoHieu(nhanHieu);
		List<String> out = new ArrayList<>();
		for (Integer soHieu : listSoHieu) {
			out.add(StringUtil.toString(soHieu));
		}
		return out;
	}

	public Map<String, Object> choMuon(String userId, int maMuon, int maDuyet, int soHieuVK) {
		Map<String, Object> data = new HashMap<>();
		DanhSachMuon dsMuon = dsMuonRep.getOne(maMuon);
		if (dsMuon == null) {
			data.put("statusCode", "500");
			data.put("messageError", "không tồn tại yêu cầu mượn");
			return data;
		}
		VkVlnCcht vk = vkRep.getOne(soHieuVK);
		if (vk == null) {
			data.put("statusCode", "500");
			data.put("messageError", "Không tồn tại vũ khí");
			return data;
		}
		// update tinh trang vk
		vk.setTinhTrang("1");
		vkRep.save(vk);
		// update tinh trang muon
		rep.updateTrangThaiMuon(maMuon);
		// update so hieu vu khi tai table duyet_muon
		rep.updateSohieuVK(maDuyet, maMuon, soHieuVK);
		// insert vao table bien_ban
		BienBan bienBan = new BienBan();
		bienBan.setMaDuyet(maDuyet);
		bienBan.setMaCbql(rep.getMaCBCSByUserID(userId));
		bienBan.setNgayMuon(new Date());
		bienBan.setDaXuatBienBan(0);
		bienBanRep.save(bienBan);
		data.put("statusCode", "200");
		data.put("messageInfo", "Tạo biên bản thành công");
		return data;
	}

	public Map<String, Object> choMuon2(String userId, int maMuon, int maDuyet, String nhanHieu, int soLuong) {

		Map<String, Object> data = new HashMap<>();
		DanhSachMuon dsMuon = dsMuonRep.getOne(maMuon);
		if (dsMuon == null) {
			data.put("statusCode", "500");
			data.put("messageError", "không tồn tại yêu cầu mượn");
			return data;
		}
		List<Integer> listSoHieu = rep.getSoHieu(nhanHieu);
		if (soLuong > listSoHieu.size()) {
			data.put("statusCode", "500");
			data.put("messageError", "Không đủ số lượng vũ khí");
			return data;
		}

		ChiTietMuon chiTietMuon = null;
		List<ChiTietMuon> listChiTiet = new ArrayList<>();
		for (int i = 0; i < soLuong; i++) {
			// update tinh trang vu khi
			rep.updateTinhTrangVK(listSoHieu.get(i));

			// insert chi_tiet_muon
			chiTietMuon = new ChiTietMuon();
			chiTietMuon.setMaDuyet(maDuyet);
			chiTietMuon.setMaMuon(maMuon);
			chiTietMuon.setSoHieuVkVlnCcht(listSoHieu.get(i));
			listChiTiet.add(chiTietMuon);
		}
		chiTietRep.saveAll(listChiTiet);
		// update tinh trang muon
		rep.updateTrangThaiMuon(maMuon);

		// insert vao table bien_ban
		BienBan bienBan = new BienBan();
		bienBan.setMaDuyet(maDuyet);
		bienBan.setMaCbql(rep.getMaCBCSByUserID(userId));
		bienBan.setNgayMuon(new Date());
		bienBan.setDaXuatBienBan(0);
		bienBanRep.save(bienBan);
		data.put("statusCode", "200");
		data.put("messageInfo", "Tạo biên bản thành công");
		return data;
	}

	public Map<String, Object> huyMuon(int maMuon, int maDuyet) {
		Map<String, Object> data = new HashMap<>();
		DuyetMuon duyetMuon = duyetMuonRep.getOne(maDuyet);
		if (duyetMuon == null) {
			data.put("error", message.getMessage("test", new Object[0], new Locale("vn")));
			return data;
		}
		// xoa tat ca trong duyet muon theo ma muon
		duyetMuonRep.deleteByMaMuon(maMuon);
		rep.updateTrangThaiHuy(maMuon);
		return data;
	}
}
