package com.qlvk.common.component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class FileComponent {
	
	//@Autowired
	//private ICgVersionTemplateRepository versionRepo;
	public List<String> searchDirectory(File directory, String str) {
		List<String> result = new ArrayList<String>();
		if (directory.isDirectory()) {
			search(directory, result, str);
		} else {
		}
		return result;
	}

	private void search(File file, List<String> result, String str) {

		if (file.isDirectory()) {

			// do you have permission to read this directory?
			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp, result, str);
					} else {
						if (StringUtils.isNotEmpty(str)) {
							if (temp.getName().contains(str)) {
								result.add(temp.getAbsoluteFile().toString());
							}
						} else {
							result.add(temp.getAbsoluteFile().toString());
						}
					}
				}
			} else {
				//"Permission Denied"
			}
		}
	}
}
