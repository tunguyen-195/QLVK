package com.qlvk.controllers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.ChoMuonModel;
import com.qlvk.model.DanhSachMuonModel;
import com.qlvk.model.DanhSachTraModel;
import com.qlvk.model.DanhSachVKModel;
import com.qlvk.model.ThuHoiModel;
import com.qlvk.model.User;
import com.qlvk.service.impl.CBQLService;

@RestController
public class CBQLApiController {
	private static Logger logger = LoggerFactory.getLogger(CBQLApiController.class);
	@Autowired
	CBQLService service;

	@RequestMapping(value = "/api/CBQL/searchDsVK", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> seachDsVK(HttpServletRequest request,
			@RequestParam(value = "chungLoai", defaultValue = "") String chungLoai,
			@RequestParam(value = "nhanHieu", defaultValue = "") String nhanHieu,
			@RequestParam(value = "tinhTrang", defaultValue = "") String tinhTrang) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			List<DanhSachVKModel> listVK = service.getDanhSachVK(chungLoai, nhanHieu, tinhTrang);
			Map<String, Object> data = new HashMap<>();
			data.put("statusCode", "200");
			data.put(CommonConstant.DATA, listVK);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}

	@RequestMapping(value = "/api/CBQL/searchDsMuon", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> seachDsMuon(HttpServletRequest request,
			@RequestParam(value = "timKiem", defaultValue = "") String timKiem) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			List<DanhSachMuonModel> listMuon = service.getDanhSachMuon(timKiem);
			Map<String, Object> data = new HashMap<>();
			data.put("statusCode", "200");
			data.put(CommonConstant.DATA, listMuon);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}

	@RequestMapping(value = "/api/CBQL/searchDsTra", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> seachDsTra(HttpServletRequest request,
			@RequestParam(value = "timKiem", defaultValue = "") String timKiem) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			List<DanhSachTraModel> listTra = service.getDanhSachTra(timKiem);
			Map<String, Object> data = new HashMap<>();
			data.put("statusCode", "200");
			data.put(CommonConstant.DATA, listTra);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}

	@RequestMapping(value = "/api/CBQL/createVK", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> addVK(@Valid @RequestBody DanhSachVKModel model, HttpServletResponse response) {

		Map<String, Object> data = service.addVK(model);
		return data;
	}

	@RequestMapping(value = "/api/CBQL/updateVK", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> updateVK(@Valid @RequestBody DanhSachVKModel model, HttpServletResponse response) {

		Map<String, Object> data = service.updateVK(model);
		return data;
	}

	@RequestMapping(value = "/api/CBQL/delVK", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> delVK(@RequestBody DanhSachVKModel model, HttpServletResponse response) {
		Map<String, Object> data = service.delVK(model.getSoHieu());
		return data;
	}

	@RequestMapping(value = "/api/CBQL/getDsSoHieu", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getSoHieu(HttpServletRequest request, @RequestParam(value = "maMuon") String maMuon) {

		Map<String, Object> data = new HashMap<>();
		List<Integer> listData = service.getDsSoHieu(Integer.parseInt(maMuon));
		data.put("statusCode", "200");
		data.put(CommonConstant.DATA, listData);
		return data;
	}

	@RequestMapping(value = "/api/CBQL/choMuon", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> choMuon(@RequestBody ChoMuonModel model, HttpServletResponse response,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_INFO);
		Map<String, Object> data = service.choMuon(user.getUserId(), model.getMaMuon(), model.getMaDuyet(),
				model.getNhanHieuVK(), model.getSoLuong());
		return data;
	}

	@RequestMapping(value = "/api/CBQL/tuChoi", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> tuChoi(@RequestBody ChoMuonModel model, HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> data = service.huyMuon(model.getMaMuon(), model.getMaDuyet());
		return data;
	}

	@RequestMapping(value = "/api/CBQL/download", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> download(HttpServletRequest request,
			@RequestParam(value = "chungLoai", defaultValue = "") String chungLoai,
			@RequestParam(value = "nhanHieu", defaultValue = "") String nhanHieu,
			@RequestParam(value = "tinhTrang", defaultValue = "") String tinhTrang) throws Exception {
		return service.download(chungLoai, nhanHieu, tinhTrang);
	}

	@RequestMapping(value = "/api/CBQL/downloadBaoCao", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> downloadBaocao(HttpServletRequest request,
			@RequestParam(value = "ngayBatDau", defaultValue = "") String ngayBatDau,
			@RequestParam(value = "ngayKetThuc", defaultValue = "") String ngayKetThuc) throws Exception {
		return service.downloadBaocao(ngayBatDau, ngayKetThuc);
	}

	@RequestMapping(value = "/api/CBQL/downBienBan", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> downBienBan(HttpServletRequest request,
			@RequestParam(value = "maMuon", defaultValue = "") String maMuon) throws Exception {
		return service.downBienBan(Integer.parseInt(maMuon));
	}

	@RequestMapping(value = "/api/CBQL/thuHoi", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> thuHoi(@RequestBody ThuHoiModel model, HttpServletResponse response,
			HttpServletRequest request) {
		return service.thuHoi(model.getSoBienBan(), model.getMaMuon(), model.getSoHieuVK());
	}
}
