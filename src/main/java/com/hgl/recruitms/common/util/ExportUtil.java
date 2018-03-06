package com.hgl.recruitms.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class ExportUtil {
	static Logger logger = LogManager.getLogger(ExportUtil.class);
		
	/**  
	 * setSheetColumnWidth:设置xls列宽. <br/>  
	 * @author huanggl
	  * @param sheet
	 *            工作表
	 * @param widthList
	 *            列宽 
	 */
	public static void setSheetColumnWidth(HSSFSheet sheet, int[] widthList) {

		// 增加序列
		sheet.setColumnWidth(0, 2000);
		for (int i = 0; i < widthList.length; i++) {
			sheet.setColumnWidth((i + 1), widthList[i]);
		}
	}

	/**
	 * createTitle:设置xls标题列. <br/>  
	 * @author huanggl
	 * @param row
	 *            行
	 * @param style
	 *            样式
	 * @param titleStr
	 *            标题
	 */
	public static void createTitle(HSSFRow row, HSSFCellStyle style, List<String> titleList) {

		// 增加序列
		createCell(row, 0, style, CellType.STRING, "序号");

		for (int i = 0; i < titleList.size(); i++) {
			createCell(row, (i + 1), style, CellType.STRING, titleList.get(i));
		}
	}

	/**  
	 * createTitleStyle:设置标题样式. <br/>  
	 * @author huanggl
	 * @param wb
	 * 			工作簿
	 * @return  
	 */
	public static HSSFCellStyle createTitleStyle(HSSFWorkbook wb) {
		HSSFFont boldFont = wb.createFont();
		boldFont.setFontName("黑体");// 字体
		//boldFont.setFontHeightInPoints((short) 20);// 字体大小
        boldFont.setFontHeight((short) 250);// 设置字体大小
		boldFont.setBold(true);//加粗

		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(boldFont);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);//設置背景填充模式
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());//設置單元格背景
		// style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00")); 
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat(""));
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setWrapText(true);// 自动换行
		return style;
	}

	/**  
	 * createCellStyle:设置数据样式. <br/>  
	 * @author huanggl
	 * @param wb
	 * 			工作簿
	 * @return  
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook wb) {
		HSSFFont boldFont = wb.createFont();
		//boldFont.setFontHeightInPoints((short) 16);// 设置字体大小
        boldFont.setFontHeight((short) 210);  // 设置字体大小

		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(boldFont);
		// style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00"));
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat(""));
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setWrapText(true);// 设置自动换行
		return style;
	}

	/**  
	 * createCell:创建单元格. <br/>  
	 * @author huanggl
	 * @param row
	 *            行
	 * @param column
	 *            列
	 * @param style
	 *            样式
	 * @param cellType
	 *            数据类型
	 * @param value
	 *            数据 
	 */
	public static void createCell(HSSFRow row, int column, HSSFCellStyle style, CellType cellType, Object value) {
		HSSFCell cell = row.createCell(column);
		if (style != null) {
			cell.setCellStyle(style);
		}

		if (value != null) {
			if(cellType == CellType.STRING){
				cell.setCellValue(value.toString());
			}else if(cellType == CellType.NUMERIC){
				cell.setCellType(CellType.NUMERIC); //
				cell.setCellValue(Double.parseDouble(value.toString()));
			}else{
				cell.setCellValue(value.toString());
			}
		}
	}
	
	/**  
	 * setResponseAttribute:设置Response中xls属性. <br/>  
	 * @author huanggl
	 * @param response
	 * @param xlsName
	 * 			xls表名
	 * @throws UnsupportedEncodingException  
	 */
	public static void setResponseAttribute(HttpServletResponse response, String xlsName) {
		try {
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(xlsName, "UTF-8"));
			response.setContentType("application/msexcel; charset=utf-8");		
		} catch (Exception e) {
			logger.error("设置Reesponse中xls属性异常！" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**  
	 * export:(excel导出). <br/>  
	 * @author huanggl
	 * @param list
	 * 			导出的数据
	 * @param fileName
	 * 			文件名
	 * @param os
	 * @param response  
	 */
	public static void export(List<List<String>> list, String fileName, HttpServletResponse response){
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(fileName);

		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			if(i == 0){
				HSSFCellStyle titleStyle = createTitleStyle(workBook);
				createTitle(row, titleStyle, list.get(i));
			}else{
				HSSFCellStyle cellStyle = createCellStyle(workBook);
				// 增加序列
				createCell(row, 0, cellStyle, CellType.STRING, i);
				
				int cellnumb = 1;
				for (String value : list.get(i)) {
					createCell(row, cellnumb, cellStyle, CellType.STRING, value);
					cellnumb++;
				}
			}
		}
		
		String date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		fileName = fileName + "-" + date + ".xls";
		setResponseAttribute(response, fileName);
		
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			workBook.write(os);
			workBook.close();
		} catch (IOException e1) {
			logger.error("excel导出出错！", e1);
		}
			
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (Exception e) {
				logger.info("close os error");
			}
		}
	}
	
	public static void export(List<List<String>> list, String fileName, HttpServletResponse response, int[] sheetWidth){
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(fileName);
		setSheetColumnWidth(sheet, sheetWidth);

		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			if(i == 0){
				HSSFCellStyle titleStyle = createTitleStyle(workBook);
				createTitle(row, titleStyle, list.get(i));
			}else{
				HSSFCellStyle cellStyle = createCellStyle(workBook);
				// 增加序列
				createCell(row, 0, cellStyle, CellType.STRING, i);
				
				int cellnumb = 1;
				for (String value : list.get(i)) {
					createCell(row, cellnumb, cellStyle, CellType.STRING, value);
					cellnumb++;
				}
			}
		}
		
		String date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		fileName = fileName + "-" + date + ".xls";
		setResponseAttribute(response, fileName);
		
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			workBook.write(os);
			workBook.close();
		} catch (IOException e1) {
			logger.error("excel导出出错！", e1);
		}
			
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (Exception e) {
				logger.info("close os error");
			}
		}
	}

}
