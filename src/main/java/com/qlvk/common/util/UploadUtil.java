package com.qlvk.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.qlvk.common.component.Messages;
import com.qlvk.common.constant.CommonConstant;
import com.qlvk.common.validate.Validate;
import com.qlvk.model.User;

public class UploadUtil {
	private static Logger logger = LoggerFactory.getLogger(UploadUtil.class);

	public static String uploadFile(MultipartFile fileUpload, String dir, User user) {
		try {
			String idFileUpload = null;
			if (user != null) {
				idFileUpload = GenerateUtil.generateID(user.getUserId());
			} else {
				idFileUpload = GenerateUtil.generateID();
			}
			String pathBug = Config.get("common.dir." + dir);

			InputStream in = fileUpload.getInputStream();
			String[] file = fileUpload.getOriginalFilename().split(Pattern.quote("."));
			String fileLocation = pathBug + idFileUpload + "." + file[file.length - 1];
			try (FileOutputStream f = new FileOutputStream(fileLocation);) {
				int ch = 0;
				while ((ch = in.read()) != -1) {
					f.write(ch);
				}
				f.flush();
			}
			return idFileUpload;
		} catch (Exception e) {
			logger.error("Exception", e);
			return null;
		}
	}

	public static String uploadFile(MultipartFile fileUpload) {
		return uploadFile(fileUpload, "upload", null);
	}

	public static boolean checkFile(MultipartFile fileUpload) {
		String[] file = fileUpload.getOriginalFilename().split(Pattern.quote("."));
		if (file.length < 2 || !file[file.length - 1].equals(CommonConstant.EXTENSIONS_EXCEL)) {
			return false;
		}
		return true;
	}

	public static Map<String, Object> getDataFile(String idFile) {
		return getDataFile(idFile, "upload");
	}

	public static Map<String, Object> getDataFile(String idFile, String dir) {

		try (FileInputStream inputStream = new FileInputStream(
				new File(Config.get("common.dir." + dir) + idFile + CommonConstant.EXTENSIONS_EXCEL_DOT));
				Workbook workbook = new XSSFWorkbook(inputStream);) {
			Sheet sheet = null;
			List<String[]> listData = new ArrayList<>();
			Map<String, Object> data = new HashMap<>();
			sheet = workbook.getSheetAt(0);
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

			boolean isFirst = true;
			Iterator<Row> rowIterator = sheet.rowIterator();
			int columnCount = 0;
			Row row = null;
			String[] arrValue = null;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (isFirst) {
					isFirst = false;
					// count column
					while (row.getCell(columnCount) != null) {
						columnCount++;
					}
					continue;
				}
				arrValue = new String[columnCount];
				for (int i = 0; i < columnCount; i++) {
					arrValue[i] = ExcelUtil.getValue(row.getCell(i), evaluator);
				}
				listData.add(arrValue);
			}
			data.put(CommonConstant.UPLOAD_LIST_DATA, listData);
			data.put(CommonConstant.UPLOAD_COUNT_COLUMN, columnCount);
			return data;
		} catch (Exception e) {
			logger.error("Exception", e);
			return null;
		}
	}

	public static void createErrorFile(Map<String, Object> data, String idFile, Validate validate) {
		idFile = idFile + "_ERROR";
		try (XSSFWorkbook workbook = new XSSFWorkbook();
				FileOutputStream out = new FileOutputStream(
						new File(Config.get("common.dir.download") + idFile + CommonConstant.EXTENSIONS_EXCEL_DOT));) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet("ERROR");

			int rownum = 0;
			Row row = null;
			Cell cell = null;
			if (CollectionUtils.isNotEmpty(validate.getListItemError())) {
				for (Map<String, String> map : validate.getListItemError()) {
					row = sheet.createRow(rownum++);
					cell = row.createCell(0);
					cell.setCellValue(Messages.getMessage("common.validate.commonLine", map.get("line"), map.get("message")));
				}
			}

			// Write the workbook in file system
			workbook.write(out);
			data.put(CommonConstant.ID_FILE_DOWNLOAD, idFile);
			validate.addError(data, Messages.getMessage("common.message.uploadFileFormat"));
			data.put(CommonConstant.LIST_ITEM_ERROR, null);
			data.put(CommonConstant.STATUS_CODE, CommonConstant.STATUS_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
	}
}