package com.qlvk.common.base;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.util.AuditorAwareImpl;
import com.qlvk.common.util.WebUtils;
import com.qlvk.entity.AppUser;
import com.qlvk.model.User;
import com.qlvk.repository.AppUserRepository;
import com.qlvk.repository.IAppRoleRepository;

public abstract class BaseController {

	@Autowired
	private AppUserRepository appUserRepo;
	@Autowired
	private IAppRoleRepository appRole;
	@Autowired
	private HttpServletRequest request;

	private AuditorAwareImpl auditorAwareImpl = new AuditorAwareImpl();

	public void initial(Model model) {

		AppUser entity = appUserRepo.findUserAccount(auditorAwareImpl.getCurrentAuditor().get());
		if (entity == null) {
			return;
		}
		User user = new User();
		user.setUserId(entity.getUserName());
		user.setLocale(new Locale(entity.getLocale()));
		user.setName(entity.getName());

		user.setRole(entity.getUserRoles().get(0).getAppRole().getRoleName());
		if (StringUtils.equals(user.getRole(), "ROLE_ADMIN")) {
			user.setRoleName("Admin");
		} else if (StringUtils.equals(user.getRole(), "ROLE_CBQL")) {
			user.setRoleName("CBQL");
		} else if (StringUtils.equals(user.getRole(), "ROLE_LANH_DAO")) {
			user.setRoleName("Lãnh Đạo");
		} else if (StringUtils.equals(user.getRole(), "ROLE_CBCS")) {
			user.setRoleName("CBCS");
		}
		user.setRoleId(String.valueOf(appRole.getOneByRoleName(WebUtils.getUserRole()).getRoleId()));
		model.addAttribute(CommonConstant.USER_INFO, user);
		request.getSession().setAttribute(CommonConstant.USER_INFO, user);
		model.addAttribute("modSub", null);
	}

	public boolean isAuthen() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof AnonymousAuthenticationToken) {
			return false;

		}
		return true;
	}
}
