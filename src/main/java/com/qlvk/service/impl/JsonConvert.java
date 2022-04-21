package com.qlvk.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.qlvk.model.TongLucModel;

public class JsonConvert {

	public static void main(String[] args) {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(new TongLucModel());
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
