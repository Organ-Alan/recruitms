package com.hgl.recruitms.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: CommonUtil <br/>
 * date: 2018年3月6日 下午2:04:07 <br/>
 * Description：TODO
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public class CommonUtil {

	static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	public static String ERROR = "error";
	public static String SUCCESS = "success";

	public static Integer getNextVersion(Integer version) {
		Integer nextVersion = new Integer(1);
		try {
			if (version != null) {
				nextVersion = version + 1;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return nextVersion;
	}

	private static Pattern p = Pattern.compile("_(\\w)");

	public static String toCamelCase(String name) {
		if (name != null && !"".equals(name)) {
			name = name.toLowerCase();

			Matcher m = p.matcher(name);
			StringBuffer sb = new StringBuffer("");

			int start = 1;
			int end = 0;
			while (m.find()) {
				end = m.start();
				if (m.start() == 1 && start == 1) {
					sb.append(name.substring(0, 1).toUpperCase());
				} else if (m.start() > 1 && start == 1) {
					sb.append(name.substring(0, 1));
				}
				sb.append(name.subSequence(start, end));
				sb.append(m.group(1).toUpperCase());
				start = m.end();
			}
			sb.append(name.substring(start));

			return sb.toString();
		}
		return name;
	}

	public static String toUnderScore(String name) {
		StringBuilder result = new StringBuilder();
		if (name != null && name.length() > 0) {
			// 将第一个字符处理成大写
			result.append(name.substring(0, 1).toUpperCase());
			// 循环处理其余字符
			for (int i = 1; i < name.length(); i++) {
				String s = name.substring(i, i + 1);
				// 在大写字母前添加下划线
				if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
					result.append("_");
				}
				// 其他字符直接转成大写
				result.append(s.toUpperCase());
			}
		}
		return result.toString();
	}

	public static String listToString(List<String> list) {
		String resultStr = "";
		if (list != null && list.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (String str : list) {
				sb.append(str);
				sb.append(",");
			}
			resultStr = sb.toString();
			if (resultStr.startsWith(",")) {
				resultStr = resultStr.substring(1);
			}
			if (resultStr.endsWith(",")) {
				resultStr = resultStr.substring(0, resultStr.length() - 1);
			}
		}
		return resultStr;
	}

	public static Integer stringToInteger(String str) {
		Integer result = new Integer(0);
		if (str != null && !"".equals(str)) {
			if (isNumeric(str)) {
				result = Integer.valueOf(str);
			}
		}
		return result;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?([0-9]+)?[.]?[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static String adjustFileName(String userAgent, String origionFileName) {
		String fileName = null;
		try {
			if (userAgent != null && userAgent.toUpperCase().indexOf("MSIE") > -1) {
				fileName = URLEncoder.encode(origionFileName, "UTF-8");

			} else {
				fileName = new String(origionFileName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
		return fileName;
	}

	public static void createExcelFromList(List<List<String>> list, String sheetName, OutputStream os)
			throws IOException {

		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(sheetName);
		int rownum = 0;
		for (List<String> rowData : list) {
			HSSFRow row = sheet.createRow(rownum);
			int cellnumb = 0;
			for (String value : rowData) {
				HSSFCell cell = row.createCell(cellnumb);
				cell.setCellValue(value);
				cellnumb++;
			}
			rownum++;
		}
		workBook.write(os);
		workBook.close();
	}

	/**  
	 * numberToThousands:转换成千分位. <br/>  
	 * @author huanggl
	 * @param number
	 * @return  
	 */
	public static String numberToThousands(BigDecimal number) {
		DecimalFormat df = new DecimalFormat(",###,##0"); // 没有小数
//		DecimalFormat decimal = new DecimalFormat(",###,##0.0"); // 保留一位小数
		String result = df.format(number);
		return result;
	}
}
