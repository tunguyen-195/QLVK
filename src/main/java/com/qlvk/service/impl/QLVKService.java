package com.qlvk.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.component.Messages;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.DateUtil;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.Gpsd;
import com.qlvk.entity.VkVlnCcht;
import com.qlvk.model.TongLucModel;
import com.qlvk.model.VuKhiModel;
import com.qlvk.repository.IGpsdRepository;
import com.qlvk.repository.IQLVKRepository;
import com.qlvk.repository.IVkVlnCchtRepository;

@Service
public class QLVKService extends BaseService {

	@Autowired
	private IQLVKRepository qlvkRepo;

	@Autowired
	private IVkVlnCchtRepository vkVlnCChtRepo;

	@Autowired
	private IGpsdRepository gpsdRepo;

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
			tongLuc.setChungLoai(StringUtil.toString(object[0]));
			tongLuc.setNhanHieu(StringUtil.toString(object[1]));
			tongLuc.setNuocSanXuat(StringUtil.toString(object[2]));
			tongLuc.setSoHieu(StringUtil.toString(object[3]));
			tongLuc.setSoGiayPhep(StringUtil.toString(object[4]));
 			tongLuc.setNgayCapPhep(DateUtil.formatQLVK(object[5]));
			tongLuc.setCoGiaTriDen(DateUtil.formatQLVK((object[6])));
			tongLuc.setImgPath(StringUtil.toString(object[7]));
			tongLuc.setSoLuong(StringUtil.toString(object[8]));
			listData.add(tongLuc);
		}
		// Push data
		data.put(CommonConstant.DATA, listData);
		return data;
	}

	public Map<String, Object> maintenance(TongLucModel model, String method) {
		Map<String, Object> data = new HashMap<>();
		switch (method) {
		case CommonConstant.METHOD_POST:
			if (!create(model)) {
				getValidate().addError(data, Messages.getMessage("common.message.creatdFail"));
			} else {
				getValidate().addInfor(data, Messages.getMessage("common.message.creatdDone"));
			}
			break;
		case CommonConstant.METHOD_PUT:
			if (!update(model)) {
				getValidate().addError(data, Messages.getMessage("common.message.updateFail"));
			} else {
				getValidate().addInfor(data, Messages.getMessage("common.message.updateDone"));
			}
			break;

		case CommonConstant.METHOD_DELETE:
			if (!delete(model)) {
				getValidate().addError(data, Messages.getMessage("common.message.deleteFail"));
			} else {
				getValidate().addInfor(data, Messages.getMessage("common.message.deleteDone"));
			}
			break;
		default:
			break;
		}
		return data;
	}

	private boolean delete(TongLucModel model) {
		try {
			Optional<VkVlnCcht> optionalVk = vkVlnCChtRepo.findById(Integer.parseInt(model.getSoHieu()));
			Optional<Gpsd> optionalGp = gpsdRepo.findById(Integer.parseInt(model.getSoGiayPhep()));
			VkVlnCcht entityVk = null;
			Gpsd entityGp = null;
			if (!optionalVk.isPresent() || !optionalGp.isPresent()) {
				return false;
			} else {
				entityVk = optionalVk.get();
				entityGp = optionalGp.get();
			}
			// Delete vu khi - vat lieu no - cong cu ho tro
			vkVlnCChtRepo.delete(entityVk);

			// Delete giay phep su dung
			gpsdRepo.delete(entityGp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean update(TongLucModel model) {
		try {
			Optional<VkVlnCcht> optionalVk = vkVlnCChtRepo.findById(Integer.parseInt(model.getSoHieu()));
			Optional<Gpsd> optionalGp = gpsdRepo.findById(Integer.parseInt(model.getSoGiayPhep()));
			VkVlnCcht entityVk = null;
			Gpsd entityGp = null;
			if (!optionalVk.isPresent() || !optionalGp.isPresent()) {
				return false;
			} else {
				entityVk = optionalVk.get();
				entityGp = optionalGp.get();
			}
			// Update vu khi - vat lieu no - cong cu ho tro
			entityVk.setChungLoai(model.getChungLoai());
			entityVk.setDonViTinh(null);
			entityVk.setNhanHieuVkVlnCcht(model.getNhanHieu());
			entityVk.setNuocSanXuat(model.getNuocSanXuat());
			entityVk.setSoLuong(999);
			entityVk.setTinhTrang(null);
			vkVlnCChtRepo.save(entityVk);
			// Update giay phep su dung
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			entityGp.setChungLoaiGpsd(model.getChungLoai());
			entityGp.setNgayCap(format.parse(model.getNgayCapPhep()));
			entityGp.setNgayHetHan(format.parse(model.getCoGiaTriDen()));
			entityGp.setNguoiKy(null);
			entityGp.setSoHieuVkVlnCcht(Integer.parseInt(model.getSoHieu()));
			gpsdRepo.save(entityGp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean create(TongLucModel model) {
		try {
			Optional<VkVlnCcht> optionalVk = vkVlnCChtRepo.findById(Integer.parseInt(model.getSoHieu()));
			Optional<Gpsd> optionalGp = gpsdRepo.findById(Integer.parseInt(model.getSoGiayPhep()));
			VkVlnCcht entityVk = null;
			Gpsd entityGp = null;
			if (optionalVk.isPresent() || optionalGp.isPresent()) {
				return false;
			} else {
				entityVk = new VkVlnCcht();
				entityGp = new Gpsd();
			}
			// Add vu khi - vat lieu no - cong cu ho tro
			entityVk.setSoHieuVkVlnCcht(Integer.parseInt(model.getSoHieu()));
			entityVk.setChungLoai(model.getChungLoai());
			entityVk.setDonViTinh(null);
			entityVk.setNhanHieuVkVlnCcht(model.getNhanHieu());
			entityVk.setNuocSanXuat(model.getNuocSanXuat());
			entityVk.setSoLuong(999);
			entityVk.setTinhTrang(null);
			vkVlnCChtRepo.save(entityVk);
			// Add giay phep su dung
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			entityGp.setSoGpsd(Integer.parseInt(model.getSoGiayPhep()));
			entityGp.setChungLoaiGpsd(model.getChungLoai());
			entityGp.setNgayCap(format.parse(model.getNgayCapPhep()));
			entityGp.setNgayHetHan(format.parse(model.getCoGiaTriDen()));
			entityGp.setNguoiKy(null);
			entityGp.setSoHieuVkVlnCcht(Integer.parseInt(model.getSoHieu()));
			gpsdRepo.save(entityGp);
			return true;
		} catch (Exception e) {
			return false;
		}
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