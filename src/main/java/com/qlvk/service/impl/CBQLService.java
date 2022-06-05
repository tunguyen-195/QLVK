package com.qlvk.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.qlvk.common.base.BaseService;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.Config;
import com.qlvk.common.util.DateUtil;
import com.qlvk.common.util.GenerateUtil;
import com.qlvk.common.util.StringUtil;
import com.qlvk.entity.BienBan;
import com.qlvk.entity.ChiTietMuon;
import com.qlvk.entity.DanhSachMuon;
import com.qlvk.entity.DuyetMuon;
import com.qlvk.entity.PhieuTra;
import com.qlvk.entity.VkVlnCcht;
import com.qlvk.model.DanhSachMuonModel;
import com.qlvk.model.DanhSachTraModel;
import com.qlvk.model.DanhSachVKModel;
import com.qlvk.repository.IBienBanRepository;
import com.qlvk.repository.ICBQLRepository;
import com.qlvk.repository.IChiTietMuonRepository;
import com.qlvk.repository.IDanhSachMuonRepository;
import com.qlvk.repository.IDuyetMuonRepository;
import com.qlvk.repository.IPhieuTraRepository;
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
	@Autowired
	IPhieuTraRepository phieuTraRep;

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
			model.setNhanHieuVK(StringUtil.toString(object[2]));
			model.setSoLuong(Integer.parseInt(StringUtil.toString(object[3])));
			model.setNgayMuon(StringUtil.toString(object[4]));
			model.setSoHieuCBQL(StringUtil.toString(object[5]));
			model.setHoTenCBQL(StringUtil.toString(object[6]));
			model.setLanhDaoDuyet(StringUtil.toString(object[7]));
			model.setDonVi(StringUtil.toString(object[8]));
			model.setMaMuon(Integer.parseInt(StringUtil.toString(object[9])));
			model.setSoBienBan(Integer.parseInt(StringUtil.toString(object[10])));
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

	public List<Integer> getDsSoHieu(int maMuon) {
		return rep.getDsSoHieu(maMuon);
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
		rep.updateTrangThaiMuon(maMuon, 2);
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
		List<Integer> listSoHieu = rep.getSoHieuVK(nhanHieu);
		if (soLuong > listSoHieu.size()) {
			data.put("statusCode", "500");
			data.put("messageError", "Không đủ số lượng vũ khí");
			return data;
		}

		ChiTietMuon chiTietMuon = null;
		List<ChiTietMuon> listChiTiet = new ArrayList<>();
		for (int i = 0; i < soLuong; i++) {
			// update tinh trang vu khi
			rep.updateTinhTrangVK(listSoHieu.get(i), 1);

			// insert chi_tiet_muon
			chiTietMuon = new ChiTietMuon();
			chiTietMuon.setMaDuyet(maDuyet);
			chiTietMuon.setMaMuon(maMuon);
			chiTietMuon.setSoHieuVkVlnCcht(listSoHieu.get(i));
			listChiTiet.add(chiTietMuon);
		}
		chiTietRep.saveAll(listChiTiet);
		// update tinh trang muon
		rep.updateTrangThaiMuon(maMuon, 2);

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
			data.put("statusCode", "500");
			data.put("messageError", "Không tồn tại yêu cầu mượn");
			return data;
		}
		// xoa tat ca trong duyet muon theo ma muon
		duyetMuonRep.deleteByMaMuon(maMuon);
		// update trạng thái ở danh sách mượn
		rep.updateTrangThaiMuon(maMuon, 3);
		data.put("statusCode", "200");
		data.put("messageInfo", "Đã từ chối yêu cầu thành công");
		return data;
	}

	public Map<String, Object> download(String chungLoai, String nhanHieu, String tinhTrang) throws Exception {
		List<Object[]> danhSachVK = rep.getDSVuKhiDownload(chungLoai, nhanHieu, tinhTrang);
		Map<String, Object> data = new HashMap<>();
		data.put(CommonConstant.ID_FILE_DOWNLOAD, createFileDownload(danhSachVK));
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_OK);
		return data;
	}

	public Map<String, Object> downloadBaocao(String ngayBatDau, String ngayKetThuc) throws Exception {
		List<Object[]> danhSachVK = rep.getDSBaocao();
		Map<String, Object> data = new HashMap<>();
		data.put(CommonConstant.ID_FILE_DOWNLOAD, createFileDownloadBaoCao(danhSachVK, ngayBatDau, ngayKetThuc));
		data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_OK);
		return data;
	}
	private String createFileDownload(List<Object[]> dataExport) throws Exception {
		String idFile = GenerateUtil.generateID();
		try (FileInputStream excelFile = new FileInputStream(
				new File(this.getClass().getResource("/report/BCVK-template.xlsx").getFile()));
				XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
				FileOutputStream out = new FileOutputStream(
						new File(Config.get("common.dir.download") + idFile + CommonConstant.EXTENSIONS_EXCEL_DOT));) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			CellStyle style = workbook.createCellStyle();
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			int rownum = 8;
			Row row = null;
			Cell cell = null;
			int cellnum = 0;
			int index = 1;
			if (CollectionUtils.isNotEmpty(dataExport)) {
				for (Object[] objArr : dataExport) {
					sheet.shiftRows(rownum, rownum + 10, 1, true, true);
					row = sheet.createRow(rownum++);
					cellnum = 0;
					cell = row.createCell(cellnum++);
					cell.setCellValue(String.valueOf(index));
					cell.setCellStyle(style);
					cellnum = 1;
					for (Object obj : objArr) {
						cell = row.createCell(cellnum++);
						cell.setCellStyle(style);
						if (obj != null && obj instanceof Date) {
							cell.setCellValue(DateUtil.formatQLVK(obj));
						} else {
							if (cellnum == 6 && obj != null ) {
								obj = obj + "/GP";
							}
							cell.setCellValue("'" + obj == null ? "" : String.valueOf(obj));
						}
					}
					cell = row.createCell(cellnum++);
					cell.setCellValue("");
					cell.setCellStyle(style);
					index++;
				}
			}

			row = sheet.createRow(rownum+6);
			cell = row.createCell(0);
			cell.setCellValue(getUser().getName());
			CellStyle style2 = workbook.createCellStyle();
			style2.setAlignment(HorizontalAlignment.CENTER);
			cell.setCellStyle(style2);
			// Write the workbook in file system
			workbook.write(out);
		} catch (Exception e) {
			throw e;
		}
		return idFile;
	}

	private String createFileDownloadBaoCao(List<Object[]> dataExport, String ngayBatDau, String ngayKetThuc) throws Exception {
		String idFile = GenerateUtil.generateID();
		try (FileInputStream excelFile = new FileInputStream(
				new File(this.getClass().getResource("/report/Muon_Tamplate.xlsx").getFile()));
				XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
				FileOutputStream out = new FileOutputStream(
						new File(Config.get("common.dir.download") + idFile + CommonConstant.EXTENSIONS_EXCEL_DOT));) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			CellStyle style = workbook.createCellStyle();
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			
			Row rowT = sheet.getRow(4);
			Cell cellT = rowT.getCell(0);
			if (StringUtils.isEmpty(ngayBatDau)) {
				ngayBatDau = "30/04/1945";
			}
			if (StringUtils.isEmpty(ngayKetThuc)) {
				ngayKetThuc = "99/99/9999";
			}
			cellT.setCellValue("Từ " +ngayBatDau+" đến "+ngayKetThuc+"");
			//CellStyle styleT = workbook.createCellStyle();
			//styleT.setAlignment(HorizontalAlignment.CENTER);
			//cellT.setCellStyle(styleT);
			int rownum = 8;
			Row row = null;
			Cell cell = null;
			int cellnum = 0;
			int index = 1;
			if (CollectionUtils.isNotEmpty(dataExport)) {
				for (Object[] objArr : dataExport) {
					sheet.shiftRows(rownum, rownum + 8, 1, true, true);
					row = sheet.createRow(rownum++);
					cellnum = 0;
					cell = row.createCell(cellnum++);
					cell.setCellValue(String.valueOf(index));
					cell.setCellStyle(style);
					cellnum = 1;
					for (Object obj : objArr) {
						cell = row.createCell(cellnum++);
						cell.setCellStyle(style);
						cell.setCellValue("'" + obj == null ? "" : String.valueOf(obj));
					}
					index++;
				}
			}

			row = sheet.createRow(rownum+6);
			cell = row.createCell(0);
			cell.setCellValue(getUser().getName());
			CellStyle style2 = workbook.createCellStyle();
			style2.setAlignment(HorizontalAlignment.CENTER);
			cell.setCellStyle(style2);
			// Write the workbook in file system
			workbook.write(out);
		} catch (Exception e) {
			throw e;
		}
		return idFile;
	}
	public Map<String, Object> thuHoi(int soBienBan, int maMuon, List<String> dsSoHieuVk) {
		Map<String, Object> data = new HashMap<>();
		try {
			// tao thong tin phieu tra
			PhieuTra phieuTra = new PhieuTra();
			phieuTra.setNgayTra(new Date());
			phieuTra.setSoBienBan(soBienBan);
			phieuTraRep.save(phieuTra);

			// update trang thai muon (hoan thanh)
			rep.updateTrangThaiMuon(maMuon, 4);

			// update tinh trang vu khi (con)
			for(String soHieuVK : dsSoHieuVk) {
				rep.updateTinhTrangVK(Integer.parseInt(soHieuVK), 0);
			}
			data.put("statusCode", "200");
			data.put("messageInfo", "Đã cập nhật thông tin thu hồi");
		} catch (Exception e) {
			data.put("statusCode", "500");
			data.put("messageError", "Cập nhật thông tin thu hồi thất bại");
		}
		return data;
	}
}