package com.qlvk.common.tag;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseTag {

	@Autowired
	private HttpServletRequest request;


	// get message by key
	public String message(String key) throws Exception {
		MessageTag tag = new MessageTag();
		return tag.message(key, request);
	}

	// get message by key
	public String message(String key, String... args) throws Exception {
		MessageTag tag = new MessageTag();
		return tag.message(key, request, args);
	}
}