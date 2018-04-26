package com.lang.java2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	/**
	 * 对外提供读取不同版本excel
	 */
	public static List<List<Object>> readExcel(File file) throws IOException {
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(file);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(file);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}

	/**
	 * 读取 office 2003 excel
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<List<Object>> read2003Excel(File file) throws IOException {
		System.out.println("读取office 2007 excel内容如下");
		List<List<Object>> list = new LinkedList<List<Object>>();
		/**
		 * Excel文件
		 */
		HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
		/**
		 * 第一个工作簿
		 */
		HSSFSheet sheet = hwb.getSheetAt(0);
		/**
		 * 临时存放对象
		 */
		Object value = null;
		/**
		 * 单行
		 */
		HSSFRow row = null;
		/**
		 * 单元格
		 */
		HSSFCell cell = null;
		for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// 格式�? number String
				// 字符
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
				DecimalFormat nf = new DecimalFormat("0.00");// 格式化数�?
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());

					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = nf.format(cell.getNumericCellValue());
					} else {
						value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					value = "";
					System.out.print("  " + value + "  ");
					break;
				default:
					value = cell.toString();
					System.out.print("  " + value + "  ");
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				linked.add(value);

			}
			System.out.println("");
			list.add(linked);
		}

		return list;
	}

	/**
	 * 读取 Excel 2007
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static List<List<Object>> read2007Excel(File file) throws IOException {

		List<List<Object>> list = new LinkedList<List<Object>>();
		/**
		 * Excel2007
		 */
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		/**
		 * 工作簿
		 */
		XSSFSheet sheet = xwb.getSheetAt(0);
		/**
		 * 临时存放对象
		 */
		Object value = null;
		/**
		 * 单行
		 */
		XSSFRow row = null;
		/**
		 * 单个单元格
		 */
		XSSFCell cell = null;
		System.out.println("读取office 2007 excel内容如下");
		for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// 格式�? number String
				// 字符
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
				DecimalFormat nf = new DecimalFormat("0.00");// 格式化数�?

				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());

					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = nf.format(cell.getNumericCellValue());
					} else {
						value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					System.out.print("  " + value + "  ");
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					value = "";
					System.out.print("  " + value + "  ");
					break;
				default:
					value = cell.toString();
					System.out.print("  " + value + "  ");
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				linked.add(value);
			}
			System.out.println("");
			list.add(linked);
		}
		return list;
	}

	public static void main(String[] args) {
		try {
			readExcel(new File("C:\\Users\\旭金科技\\Desktop\\Excel2db.xlsx"));
			// readExcel(new File("D:\\test.xls"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
