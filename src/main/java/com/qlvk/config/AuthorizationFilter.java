package com.qlvk.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

	private boolean isAcceptRequest(HttpServletRequest request) {

		List<String> excludeURLs = new ArrayList<>();
		excludeURLs.add("login");
		excludeURLs.add("index");
		excludeURLs.add("about");
		excludeURLs.add("register");
		excludeURLs.add("signup");
		excludeURLs.add("images");
		excludeURLs.add("css");
		excludeURLs.add("js");
		excludeURLs.add("assets");
		boolean accept = false;
		for (String string : excludeURLs) {
			if (request.getRequestURI().contains(string)) {
				accept = true;
				break;
			}
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (("anonymousUser").equals(auth.getPrincipal()) && !accept) {
			return false;
		}
		return true;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!isAcceptRequest(request)) {
			request.getSession().setAttribute("urlRedirect", request.getRequestURI());
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		filterChain.doFilter(request, response);
	}
}