package com.qlvk.controllers.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.CBCSModel;
import com.qlvk.model.User;
import com.qlvk.service.impl.CBCSService;

@RestController
public class CBCSApiController {
	private static Logger logger = LoggerFactory.getLogger(CBCSApiController.class);
	@Autowired
	CBCSService cbcsService;

	@RequestMapping(value = "/api/CBCS/searchImgVK", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> searchImgVK(HttpServletRequest request,
			@RequestParam(value = "chungLoai", defaultValue = "") String chungLoai,
			@RequestParam(value = "nhanHieu", defaultValue = "") String nhanHieu) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			List<CBCSModel> listImg = cbcsService.getListImgVK(chungLoai, nhanHieu);
			Map<String, Object> data = new HashMap<>();
			data.put("statusCode", "200");
			data.put(CommonConstant.DATA, listImg);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			cbcsService.remove();
		}
	}

	@RequestMapping(value = "/api/CBCS/getSoLuong", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getSoLuong(HttpServletRequest request,
			@RequestParam(value = "nhanHieuVK", defaultValue = "") String nhanHieuVK) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			CBCSModel detail = cbcsService.getSoLuong(nhanHieuVK);
			Map<String, Object> data = new HashMap<>();
			data.put("statusCode", "200");
			data.put(CommonConstant.DATA, detail);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			cbcsService.remove();
		}
	}

	@RequestMapping(value = "/api/CBCS/requestMuon", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> requestMuon(HttpServletRequest request, @RequestParam(value = "soLuong") String soLuong,
			@RequestParam(value = "nhanHieuVK") String nhanHieuVK, @RequestParam(value = "lyDo") String lyDo) {
		try {
			User user = (User) request.getSession().getAttribute(CommonConstant.USER_INFO);
			Map<String, Object> data = cbcsService.requestMuon(user.getUserId(), nhanHieuVK, Integer.parseInt(soLuong),
					lyDo);
			return data;
		} finally {
			cbcsService.remove();
		}
	}

	@RequestMapping(value = "/api/CBCS/kiemTra", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> kiemTra(HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute(CommonConstant.USER_INFO);
			Map<String, Object> data = cbcsService.kiemTraYeuCauBiTuChoi(user.getUserId());
			return data;
		} finally {
			cbcsService.remove();
		}
	}

	@RequestMapping(value = "/api/CBCS/xacNhanHuy", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> xacNhanHuy(HttpServletRequest request, @RequestBody String[] listMaMuon) {
		try {
			Map<String, Object> data = cbcsService.xacNhanDaTuChoi(Arrays.asList(listMaMuon));
			return data;
		} finally {
			cbcsService.remove();
		}
	}
}
