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
 * ������
 * 
 * @author thin
 *
 */
public class InfoData {

	public static void main(String[] args) throws IOException {
		/**
		 * ����Excel���
		 */
		String filePath = "";// �ļ�·��
		String prefix=filePath.substring(filePath.lastIndexOf('.')+1);	//��ȡ�ļ�·���ĺ�׺
//		FileOutputStream out = new FileOutputStream(filePath);
//		HSSFWorkbook workbook = new HSSFWorkbook();// ����Excel�ļ�(Workbook)
//		/**
//		 * ����Excel���������
//		 */
//		HSSFSheet sheet1 = workbook.createSheet(); // ����������		
//		HSSFSheet sheet12 = workbook.createSheet(); // ����������		
//		HSSFRow row = sheet1.createRow(0);// ������,��0��ʼ
//		HSSFCell cell = row.createCell(0);// �����еĵ�Ԫ��,Ҳ�Ǵ�0��ʼ
//		cell.setCellValue("����");// ���õ�Ԫ������
//		row.createCell(1).setCellValue("����");// ���õ�Ԫ������,����
//		row.createCell(2).setCellValue("�ֻ���");// ���õ�Ԫ������,����
//		row.createCell(3).setCellValue("�Ա�");// ���õ�Ԫ������,����
//		
//		HSSFRow row1 = sheet1.createRow(1);// ������,��1��ʼ
//		HSSFCell cell1 = row1.createCell(0);// �����еĵ�Ԫ��,Ҳ�Ǵ�1��ʼ
//		cell1.setCellValue("wyk");// ���õ�Ԫ������
//		row1.createCell(1).setCellValue(24);// ���õ�Ԫ������,����
//		row1.createCell(2).setCellValue(123456);// ���õ�Ԫ������,����
//		row1.createCell(3).setCellValue("��");// ���õ�Ԫ������,����
//		
//		HSSFRow row12 = sheet1.createRow(2);// ������,��1��ʼ
//		HSSFCell cell12 = row12.createCell(0);// �����еĵ�Ԫ��,Ҳ�Ǵ�1��ʼ
//		cell12.setCellValue("w11yk");// ���õ�Ԫ������
//		row12.createCell(1).setCellValue(214);// ���õ�Ԫ������,����
//		row12.createCell(2).setCellValue(1123456);// ���õ�Ԫ������,����
//		row12.createCell(3).setCellValue("1��");// ���õ�Ԫ������,����
//		/**
//		 * ������д
//		 */
//		workbook.write(out);// ����Excel�ļ�
//		out.close();// �ر��ļ���
		FileInputStream fileinput = new FileInputStream(filePath); // ��ȡ����
		Workbook workbookred = null;
		if(prefix.equals("xls"))
		{
			System.out.println("1");
			workbookred=new HSSFWorkbook(fileinput); //2003���ȡ
		}
		else if(prefix.equals("xlsx"))
		{
			workbookred=new XSSFWorkbook(fileinput); //2007���ȡ
		}
		
		/**
		 * ��ȡָ��excel������
		 */
		Sheet sheet = workbookred.getSheetAt(0); // ��ȡ������
		int firstrow = sheet.getFirstRowNum(); // ��ʼ��  ��0��ʼ
		int lastrow = sheet.getLastRowNum(); // ĩ��
		//׷��

		// ѭ�����
		for (int i = firstrow+1; i <=lastrow; i++) {
			// �����ж���
			Row row2 = sheet.getRow(i);
			// �ж���row2�����Ƿ�Ϊ��
			if (row2 != null) {
				int physicalNumberOfCells = row2.getPhysicalNumberOfCells(); // ��ȡ������
				short firstCellNum = row2.getFirstCellNum(); 	//��һ�еĵ�һ����Ԫ�� 0��
				for (int j = firstCellNum; j < physicalNumberOfCells; j++) {
					// �ڻ�ȡ��Ԫ����� row2.getCell(int cell)���ص�Ԫ�����
					Cell cell2 = row2.getCell(j);
					//Cannot get a STRING value from a NUMERIC cell �޷���numeric��ȡ�ַ���ֵ,�����޸�һ�����ͼ���
					//���и��ı������
					//cell2.setCellType(CellType.STRING);
					//��ȡ��ǰ���ֵ������
					//System.out.println(cell2.getCellTypeEnum());
					// ���б�ͷ
					//System.out.println(cell2.getStringCellValue().toString());
				}
			}
		}

	}
}
