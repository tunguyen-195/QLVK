package com.qlvk.common.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qlvk.repository.ICommonRepository;

@Component
public class GenerateComponent {

	@Autowired
	private ICommonRepository commonRepo;

	/**
	 * 
	 * @param table [Entity].class.getSimpleName()
	 * @return
	 */
	public String generateID(String table) {
		if (StringUtils.isEmpty(table)) {
			return null;
		}
		StringBuilder tableDB = new StringBuilder();
		for (int i = 0; i < table.length(); i++) {
			if (i > 0 && Character.isUpperCase(table.charAt(i))) {
				tableDB.append("_").append(StringUtils.lowerCase(String.valueOf(table.charAt(i))));
			} else {
				tableDB.append(StringUtils.lowerCase(String.valueOf(table.charAt(i))));
			}
		}
		String sequenceId = tableDB.toString();
		String nextSequence = commonRepo.nextVal(sequenceId).toString();
		String default0 = "6";
		if (nextSequence.length() >= 6) {
			default0 = String.valueOf(nextSequence.length());
		}
		return String.format("%0" + default0 + "d", Integer.parseInt(nextSequence));
	}
}