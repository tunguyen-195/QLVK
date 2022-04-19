package com.qlvk.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlvk.common.base.BaseController;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.WebUtils;
import com.qlvk.service.impl.MainService;

@Controller
public class MainController extends BaseController {

	@Autowired
	private MainService baseService;

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(HttpServletRequest request, Model model) {

		if (request.getSession().getAttribute("urlRedirect") != null) {
			String urlRedirect = ((String) request.getSession().getAttribute("urlRedirect"))
					.replace(request.getContextPath(), "");
			request.getSession().setAttribute("urlRedirect", null);
			return "redirect:" + urlRedirect;
		}
		return "auths/homePage";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String init(HttpServletRequest request) {

		return "app/index";
	}

	@RequestMapping(value = { "/main" }, method = RequestMethod.GET)
	public String main(HttpServletRequest request) {

		return "menu/main";
	}

	@RequestMapping(value = { "/menu" }, method = RequestMethod.GET)
	public String menu(HttpServletRequest request, Model model) {
		initial(model);
		model.addAttribute("listScreen", baseService.getListScreen());
		return "menu/menu";
	}

	@RequestMapping(value = { "/header" }, method = RequestMethod.GET)
	public String header(HttpServletRequest request, Model model) {
		initial(model);
		model.addAttribute("listScreen", baseService.getListScreen());
		return "menu/header";
	}

	@RequestMapping(value = { "/footer" }, method = RequestMethod.GET)
	public String footer(HttpServletRequest request, Model model) {
		initial(model);
		return "menu/footer";
	}

	@RequestMapping(value = { "/screen", "/home" }, method = RequestMethod.GET)
	public String screen(HttpServletRequest request) {

		return "menu/screen";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "auths/adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request) {
		model.addAttribute(CommonConstant.USER_INFO, null);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "auths/login";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model, HttpServletRequest request) {
		return "auths/error";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "auths/userInfoPage";
	}
}