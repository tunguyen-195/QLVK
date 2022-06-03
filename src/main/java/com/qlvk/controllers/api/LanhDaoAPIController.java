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

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.model.User;
import com.qlvk.service.impl.LanhDaoService;

@RestController
public class LanhDaoAPIController {
	private static Logger logger = LoggerFactory.getLogger(CBQLApiController.class);
	@Autowired
	LanhDaoService service;

	@RequestMapping(value = "/api/LanhDao/search", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getDatatable(HttpServletRequest request,
			@RequestParam(value = "timKiem", defaultValue = "") String timKiem) throws Exception {
		try {
			logger.info("Start search");
			Map<String, Object> data = service.getDatatable(timKiem);

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}

	@RequestMapping(value = "/api/LanhDao/duyetMuon", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> duyetMuon(HttpServletRequest request,
			@RequestParam(value = "maMuon", defaultValue = "") String maMuon) throws Exception {
		try {
			logger.info("Start search");
			User user = (User) request.getSession().getAttribute(CommonConstant.USER_INFO);
			Map<String, Object> data = service.duyetMuon(Integer.parseInt(maMuon), user.getUserId());

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}

	@RequestMapping(value = "/api/LanhDao/tuChoi", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> tuChoi(HttpServletRequest request,
			@RequestParam(value = "maMuon", defaultValue = "") String maMuon) throws Exception {
		try {
			logger.info("Start search");
			Map<String, Object> data = service.tuChoi(Integer.parseInt(maMuon));

			// Return data
			logger.info("END search");
			return data;
		} finally {
			service.remove();
		}
	}
}
