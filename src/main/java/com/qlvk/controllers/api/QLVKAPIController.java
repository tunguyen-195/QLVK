package com.qlvk.controllers.api;

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

import com.qlvk.service.impl.QLVKService;

@RestController
public class QLVKAPIController {
	private static Logger logger = LoggerFactory.getLogger(QLVKAPIController.class);

	@Autowired
	QLVKService qlvkService;

	@RequestMapping(value = "/api/QLVK/searchTongLuc", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> searchTongLuc(HttpServletRequest request,
			@RequestParam(value = "type", defaultValue = "1") int type,
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
}