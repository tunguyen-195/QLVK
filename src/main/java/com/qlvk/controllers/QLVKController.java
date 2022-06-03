package com.qlvk.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlvk.common.base.BaseController;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.service.impl.QLVKService;

@Controller
public class QLVKController extends BaseController {

	@Autowired
	QLVKService service;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String initIndex(HttpServletRequest request, Model model) {
		initial(model);
		com.qlvk.model.User user = (com.qlvk.model.User) request.getSession().getAttribute(CommonConstant.USER_INFO);
		if (user != null && user.getRole().equals("ROLE_CBQL")) {
			return initCBQL(request, model);
		}
		if (user != null && user.getRole().equals("ROLE_CBCS")) {
			return initCBCS(request, model);
		}
		if (user != null && user.getRole().equals("ROLE_LANH_DAO")) {
			return initLanhDao(request, model);
		}
		return "app/index";
	}

	@RequestMapping(value = { "/CBQL" }, method = RequestMethod.GET)
	public String initCBQL(HttpServletRequest request, Model model) {
		initial(model);
		model.addAttribute("listChungLoai", service.getAllChungLoai());
		model.addAttribute("listNhanHieu", service.getAllNhanHieu());
		return "app/CBQL";
	}
	
	@RequestMapping(value = { "/CBCS" }, method = RequestMethod.GET)
	public String initCBCS(HttpServletRequest request, Model model) {
		initial(model);
		model.addAttribute("listChungLoai", service.getAllChungLoai());
		model.addAttribute("listNhanHieu", service.getAllNhanHieu());
		return "app/cbcs";
	}
	@RequestMapping(value = { "/LanhDao" }, method = RequestMethod.GET)
	public String initLanhDao(HttpServletRequest request, Model model) {
		initial(model);
		return "app/lanhdao";
	}
}