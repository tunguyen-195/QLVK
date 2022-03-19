package com.qlvk.common.base;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlvk.common.util.AuditorAwareImpl;
import com.qlvk.common.util.WebUtils;
import com.qlvk.common.validate.Validate;
import com.qlvk.entity.AppUser;
import com.qlvk.model.User;
import com.qlvk.repository.AppUserRepository;
import com.qlvk.repository.IAppRoleRepository;

public class BaseService {

	private AuditorAwareImpl auditorAwareImpl = new AuditorAwareImpl();
	private static final ThreadLocal<Validate> validate = new ThreadLocal<>();
	private static final ThreadLocal<User> user = new ThreadLocal<>();
	@Autowired
	private AppUserRepository appUserRepo;
	@Autowired
	private IAppRoleRepository appRole;
	public User getUser() {
		
		AppUser entity = appUserRepo.findUserAccount(auditorAwareImpl.getCurrentAuditor().get());
		User user = new User();
		user.setUserId(entity.getUserName());
		user.setLocale(new Locale(entity.getLocale()));
		user.setName(entity.getName());

		user.setRole(WebUtils.getUserRole());
		if (StringUtils.equals(user.getRole(), "ROLE_THU_KHO")) {
			user.setRoleName("Thủ kho");
		}
		if (StringUtils.equals(user.getRole(), "ROLE_ADMIN")) {
			user.setRoleName("Admin (Người quản lý hệ thống)");
		}
		if (StringUtils.equals(user.getRole(), "ROLE_CBPN")) {
			user.setRoleName("Cán bộ phòng nhập");
		}
		user.setRoleId(String.valueOf(appRole.getOneByRoleName(WebUtils.getUserRole()).getRoleId()));

		return user;
	}

	public Validate getValidate() {
		if (validate.get() == null) {
			validate.set(new Validate());
		}
		return validate.get();
	}

	public void remove() {
		validate.remove();
		user.remove();
	}
}