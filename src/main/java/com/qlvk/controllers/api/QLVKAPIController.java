package com.qlvk.controllers.api;

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
import com.qlvk.model.TongLucModel;
import com.qlvk.service.impl.QLVKService;

@RestController
public class QLVKAPIController {
	private static Logger logger = LoggerFactory.getLogger(QLVKAPIController.class);

	@Autowired
	QLVKService qlvkService;

	@RequestMapping(value = "/api/QLVK/searchTongLuc", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> searchTongLuc(HttpServletRequest request,
			@RequestParam(value = "type", defaultValue = "3") int type,
			@RequestParam(value = "allSearch", defaultValue = "") String allSearch) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			Map<String, Object> data = qlvkService.getListTongLuc(allSearch, type);
			data.put("statusCode", "200");

			// Return data
			logger.info("END search");
			return data;
		} finally {
			qlvkService.remove();
		}
	}

	@RequestMapping(value = "/api/QLVK/searchVuKhi", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> searchVuKhi(HttpServletRequest request,
			@RequestParam(value = "allSearch", defaultValue = "") String allSearch) throws Exception {
		try {
			logger.info("Start search");
			// Get List Food
			Map<String, Object> data = qlvkService.getListVuKhi(allSearch);
			data.put("statusCode", "200");

			// Return data
			logger.info("END search");
			return data;
		} finally {
			qlvkService.remove();
		}
	}

	@RequestMapping(value = "/api/QLVK/maintenance", method = { RequestMethod.GET, RequestMethod.POST,
			RequestMethod.PUT, RequestMethod.DELETE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> maintenance(HttpServletRequest request, @RequestBody TongLucModel model)
			throws Exception {
		try {
			return qlvkService.maintenance(model, request.getMethod());
		} finally {
			qlvkService.remove();
		}
	}

	@RequestMapping(value = "/api/QLVK/getNhanHieu", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getNhanHieu(HttpServletRequest request,
			@RequestParam(value = "chungLoai", defaultValue = "") String chungLoai) {
		Map<String, Object> data = new HashMap<>();
		List<String> listNhanHieu = qlvkService.getNhanHieu(chungLoai);
		data.put("statusCode", "200");
		data.put(CommonConstant.DATA, listNhanHieu);
		return data;
	}
}