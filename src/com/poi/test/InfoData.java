package com.poi.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 测试类
 * 
 * @author thin
 *
 */
public class InfoData {

	public static void main(String[] args) throws IOException {
		/**
		 * 创建Excel表格
		 */
		String filePath = "C:/Users/thin/Desktop/桐和源周销售预估.xlsx";//读取文件路径
		String prefix = filePath.substring(filePath.lastIndexOf('.') + 1); // 获取文件路径的后缀,下面判断是2003的还是2007的 
		/**
		 * 读取Excel表中的内容
		 */
		FileInputStream fileinput = new FileInputStream(filePath); // 读取内容
		Workbook workbookred = null;
		if (prefix.equals("xls")) {
			workbookred = new HSSFWorkbook(fileinput); // 2003版读取
		} else if (prefix.equals("xlsx")) {
			workbookred = new XSSFWorkbook(fileinput); // 2007版读取
		}

		/**
		 * 获取指定excel的数据
		 */
		Sheet sheet = workbookred.getSheetAt(0); // 获取工作簿
		int firstrow = sheet.getFirstRowNum(); // 起始行 从0开始
		int lastrow = sheet.getLastRowNum(); // 末行
		
		/**
		 * 导出功能 创建excel表格并且将读取的内容写入进去
		 */
		String filename=filePath.substring(filePath.lastIndexOf("/")+1);			//获取读取excel表格的名称
		FileOutputStream out = new FileOutputStream("C:/Users/thin/Desktop/"+filename+"-副本"); // 创建文件夹路径
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件(Workbook)
		HSSFSheet sheet1 = workbook.createSheet(); // 创建工作簿
		// 循环输出
		for (int i = firstrow; i <= lastrow; i++) {
			HSSFRow row12 = sheet1.createRow(i);// 创建行,从1开始
			// 创建行对象
			Row row2 = sheet.getRow(i);
			// 判断行row2对象是否为空
			if (row2 != null) {
				int physicalNumberOfCells = row2.getPhysicalNumberOfCells(); // 获取总列数
				short firstCellNum = row2.getFirstCellNum(); // 第一行的第一个单元格 0起步
				for (int j = firstCellNum; j < physicalNumberOfCells; j++) {
					Cell cell2 = row2.getCell(j); // 创建单元格对象
					cell2.setCellType(CellType.STRING); // 进行更改表格类型
					// 获取列的数据
					if (cell2.getStringCellValue().indexOf("\"") >= 0) {
						//判断 如果有数据 是带有双引号的 那么就进入判断截取双引号里面的内容
						String name = cell2.getStringCellValue().substring(cell2.getStringCellValue().indexOf("\"") + 1,
								cell2.getStringCellValue().lastIndexOf("\""));
						row12.createCell(j).setCellValue(name);
					} else {
						//如果没有的话继续添加
						row12.createCell(j).setCellValue(cell2.getStringCellValue().toString());
					}
				}
			}
		}
		/**
		 * 进行抒写
		 */
		workbook.write(out);// 保存Excel文件
		out.close();// 关闭文件流
	}
}
