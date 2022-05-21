package com.qlvk.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlvk.common.base.BaseController;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.service.impl.CBCSService;

@Controller
public class QLVKController extends BaseController {

	@Autowired
	CBCSService cBCSService;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String initIndex(HttpServletRequest request, Model model) {
		initial(model);
		com.qlvk.model.User user = (com.qlvk.model.User) request.getSession().getAttribute(CommonConstant.USER_INFO);
		if (user != null && user.getRole().equals("ROLE_CBQL")) {
			return initCBQL(request, model);
		}
		return "app/index";
	}

	@RequestMapping(value = { "/CBQL" }, method = RequestMethod.GET)
	public String initCBQL(HttpServletRequest request, Model model) {
		initial(model);
		return "app/CBQL";
	}
	
	@RequestMapping(value = { "/CBCS" }, method = RequestMethod.GET)
	public String initCBCS(HttpServletRequest request, Model model) {
		initial(model);
		model.addAttribute("listChungLoai", cBCSService.getAllChungLoai());
		model.addAttribute("listNhanHieu", cBCSService.getAllNhanHieu());
		return "app/cbcs";
	}
}