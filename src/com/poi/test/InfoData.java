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
		String filePath = "";// 文件路径
		String prefix=filePath.substring(filePath.lastIndexOf('.')+1);	//获取文件路径的后缀
//		FileOutputStream out = new FileOutputStream(filePath);
//		HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel文件(Workbook)
//		/**
//		 * 创建Excel里面的内容
//		 */
//		HSSFSheet sheet1 = workbook.createSheet(); // 创建工作簿		
//		HSSFSheet sheet12 = workbook.createSheet(); // 创建工作簿		
//		HSSFRow row = sheet1.createRow(0);// 创建行,从0开始
//		HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
//		cell.setCellValue("姓名");// 设置单元格内容
//		row.createCell(1).setCellValue("年龄");// 设置单元格内容,重载
//		row.createCell(2).setCellValue("手机号");// 设置单元格内容,重载
//		row.createCell(3).setCellValue("性别");// 设置单元格内容,重载
//		
//		HSSFRow row1 = sheet1.createRow(1);// 创建行,从1开始
//		HSSFCell cell1 = row1.createCell(0);// 创建行的单元格,也是从1开始
//		cell1.setCellValue("wyk");// 设置单元格内容
//		row1.createCell(1).setCellValue(24);// 设置单元格内容,重载
//		row1.createCell(2).setCellValue(123456);// 设置单元格内容,重载
//		row1.createCell(3).setCellValue("男");// 设置单元格内容,重载
//		
//		HSSFRow row12 = sheet1.createRow(2);// 创建行,从1开始
//		HSSFCell cell12 = row12.createCell(0);// 创建行的单元格,也是从1开始
//		cell12.setCellValue("w11yk");// 设置单元格内容
//		row12.createCell(1).setCellValue(214);// 设置单元格内容,重载
//		row12.createCell(2).setCellValue(1123456);// 设置单元格内容,重载
//		row12.createCell(3).setCellValue("1男");// 设置单元格内容,重载
//		/**
//		 * 进行抒写
//		 */
//		workbook.write(out);// 保存Excel文件
//		out.close();// 关闭文件流
		FileInputStream fileinput = new FileInputStream(filePath); // 读取内容
		Workbook workbookred = null;
		if(prefix.equals("xls"))
		{
			System.out.println("1");
			workbookred=new HSSFWorkbook(fileinput); //2003版读取
		}
		else if(prefix.equals("xlsx"))
		{
			workbookred=new XSSFWorkbook(fileinput); //2007版读取
		}
		
		/**
		 * 获取指定excel的数据
		 */
		Sheet sheet = workbookred.getSheetAt(0); // 获取工作簿
		int firstrow = sheet.getFirstRowNum(); // 起始行  从0开始
		int lastrow = sheet.getLastRowNum(); // 末行
		//追加

		// 循环输出
		for (int i = firstrow+1; i <=lastrow; i++) {
			// 创建行对象
			Row row2 = sheet.getRow(i);
			// 判断行row2对象是否为空
			if (row2 != null) {
				int physicalNumberOfCells = row2.getPhysicalNumberOfCells(); // 获取总列数
				short firstCellNum = row2.getFirstCellNum(); 	//第一行的第一个单元格 0起步
				for (int j = firstCellNum; j < physicalNumberOfCells; j++) {
					// 在获取单元格对象 row2.getCell(int cell)返回单元格对象
					Cell cell2 = row2.getCell(j);
					//Cannot get a STRING value from a NUMERIC cell 无法从numeric获取字符串值,进行修改一下类型即可
					//进行更改表格类型
					//cell2.setCellType(CellType.STRING);
					//获取当前表格值的类型
					//System.out.println(cell2.getCellTypeEnum());
					// 进行表头
					//System.out.println(cell2.getStringCellValue().toString());
				}
			}
		}

	}
}
