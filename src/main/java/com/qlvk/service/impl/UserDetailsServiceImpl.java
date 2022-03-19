package com.qlvk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qlvk.entity.AppUser;
import com.qlvk.repository.AppRoleRepository;
import com.qlvk.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private AppUserRepository appUserRepo;

	@Autowired
	private AppRoleRepository appRoleRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser appUser = this.appUserRepo.findUserAccount(userName);

		if (appUser == null) {
			logger.error("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		// [ROLE_USER, ROLE_ADMIN,..]
		List<String> roleNames = this.appRoleRepo.getRoleNames(String.valueOf(appUser.getUserId()));

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
				appUser.getEncrytedPassword(), grantList);

		return userDetails;
	}
}