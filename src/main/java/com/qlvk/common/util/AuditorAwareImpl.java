package com.qlvk.common.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * AuditorAwareImpl<BR>
 * <BR>
 * AuditorAware Implementation<BR>
 * 
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	/** Anonymous User Name */
	private static final String ANONYMOUS_USER_NAME = "anonymousUser";

	@Override
	public Optional<String> getCurrentAuditor() {

		// get Authentication object
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()
				|| authentication.getPrincipal().equals(ANONYMOUS_USER_NAME)) {
			return Optional.of(ANONYMOUS_USER_NAME);
		}

		// get user name of current logged user
		String userName = ((User) (authentication.getPrincipal())).getUsername();
		return Optional.of(userName);
	}

}
