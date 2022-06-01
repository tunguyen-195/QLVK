package com.qlvk.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qlvk.common.constant.CommonConstant;
import com.qlvk.service.impl.UserDetailsServiceImpl;

public class ExcelUtil {
	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	public static String createFileDownload(List<Object[]> dataExport) throws Exception {
		return createFileDownload(null, dataExport);
	}

	public static String createFileDownload(List<String> header, List<Object[]> dataExport) throws Exception {
		String idFile = GenerateUtil.generateID();
		// Blank workbook
		File directory = new File(Config.get("common.dir.download"));
		if (!directory.exists()) {
			directory.mkdir();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
		try (XSSFWorkbook workbook = new XSSFWorkbook();
				FileOutputStream out = new FileOutputStream(
						new File(Config.get("common.dir.download") + idFile + CommonConstant.EXTENSIONS_EXCEL_DOT));) {
			// Create a blank sheet
			XSSFSheet sheet = workbook.createSheet("Data");

			int rownum = 0;
			Row row = null;
			Cell cell = null;
			int cellnum = 0;
			if (CollectionUtils.isNotEmpty(header)) {
				row = sheet.createRow(rownum++);
				for (String str : header) {
					cell = row.createCell(cellnum++);
					cell.setCellValue(str);
				}
			}

			if (CollectionUtils.isNotEmpty(dataExport)) {
				for (Object[] objArr : dataExport) {
					row = sheet.createRow(rownum++);
					cellnum = 0;
					for (Object obj : objArr) {
						cell = row.createCell(cellnum++);
						cell.setCellValue(String.valueOf(obj));
					}
				}
			}
			// Setting auto width
			if (CollectionUtils.isNotEmpty(dataExport)) {
				Object[] objArr = dataExport.get(0);
				for (int i = 0; i < objArr.length; i++) {
					sheet.autoSizeColumn(i);
				}
			}

			// Write the workbook in file system
			workbook.write(out);
		} catch (Exception e) {
			logger.error("Exception", e);
			throw e;
		}
		return idFile;
	}

	public static String getValue(Cell cell, FormulaEvaluator evaluator) throws Exception {
		String val = null;
		if (cell == null) {
			return "";
		}
		// String formula = cell.getCellFormula();
		int formula = cell.getCellType();
		switch (formula) {
		case 0:
			val = String.valueOf(Math.round(cell.getNumericCellValue()));
			break;
		case 1:
			val = cell.getStringCellValue();
			break;

		case 2:
			try {
				val = String.valueOf((double) (evaluator.evaluate(cell)).getNumberValue());
			} catch (Exception e) {
				logger.error("Exception", e);
				val = cell.toString();
			}
			break;
		case 3:
			val = "";
			break;
		case 4:
			val = String.valueOf(cell.getBooleanCellValue());
			break;
		default:
			val = "";
			break;
		}
		return val;
	}
	public static String getStringValue(Cell cell, FormulaEvaluator evaluator) throws Exception {
		String val = null;
		if (cell == null) {
			return "";
		}
		// String formula = cell.getCellFormula();
		int formula = cell.getCellType();
		switch (formula) {
		case 0:
			val = String.valueOf(Math.round(cell.getNumericCellValue()));
			break;
		case 1:
			val = cell.getStringCellValue();
			break;

		case 2:
			val = evaluator.evaluate(cell).getStringValue();

			break;
		case 3:
			val = "";
			break;
		case 4:
			val = String.valueOf(cell.getBooleanCellValue());
			break;
		default:
			val = "";
			break;
		}
		return val;
	}
}
