package com.qlvk.model;

import org.springframework.web.multipart.MultipartFile;

public class CommonUploadModel {
	private MultipartFile fileUpload;

	public MultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
}