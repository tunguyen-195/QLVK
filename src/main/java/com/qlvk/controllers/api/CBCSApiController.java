package com.qlvk.controllers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/api/CBCS/getDetailVk", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getDetailVk(HttpServletRequest request,
			@RequestParam(value = "soHieuVK", defaultValue = "") String soHieuVK) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			CBCSModel detail = cbcsService.getDetailVK(soHieuVK);
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

	@RequestMapping(value = "/api/CBCS/getNhanHieu", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getNhanHieu(HttpServletRequest request,
			@RequestParam(value = "chungLoai", defaultValue = "") String chungLoai) {
		Map<String, Object> data = new HashMap<>();
		List<String> listNhanHieu = cbcsService.getNhanHieu(chungLoai);
		data.put("statusCode", "200");
		data.put(CommonConstant.DATA, listNhanHieu);
		return data;
	}

	@RequestMapping(value = "/api/CBCS/requestMuon", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> requestMuon(HttpServletRequest request,
			@RequestParam(value = "soLuong", defaultValue = "") String soLuong,
			@RequestParam(value = "soHieuVK", defaultValue = "") String soHieuVK) {

		User user = (User) request.getSession().getAttribute(CommonConstant.USER_INFO);

		Map<String, Object> data = cbcsService.requestMuon(user.getUserId(), Integer.parseInt(soHieuVK),
				Integer.parseInt(soLuong));

		return data;
	}
}
