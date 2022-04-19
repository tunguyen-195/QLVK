package com.qlvk.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlvk.common.util.Config;

@Controller
public class ImageController {

	@RequestMapping(value = "myImage/imageDisplay", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(@RequestParam(value = "id") String id, HttpServletResponse response) {

		try {
			File initialFile = new File(Config.get("common.dir.upload") + id);
			InputStream targetStream = new FileInputStream(initialFile);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			StreamUtils.copy(targetStream, response.getOutputStream());
		} catch (IOException e) {
		}
	}
}