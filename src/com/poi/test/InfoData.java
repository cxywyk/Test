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
		String filePath = "C:/Users/thin/Desktop/ͩ��Դ������Ԥ��.xlsx";//��ȡ�ļ�·��
		String prefix = filePath.substring(filePath.lastIndexOf('.') + 1); // ��ȡ�ļ�·���ĺ�׺,�����ж���2003�Ļ���2007�� 
		/**
		 * ��ȡExcel���е�����
		 */
		FileInputStream fileinput = new FileInputStream(filePath); // ��ȡ����
		Workbook workbookred = null;
		if (prefix.equals("xls")) {
			workbookred = new HSSFWorkbook(fileinput); // 2003���ȡ
		} else if (prefix.equals("xlsx")) {
			workbookred = new XSSFWorkbook(fileinput); // 2007���ȡ
		}

		/**
		 * ��ȡָ��excel������
		 */
		Sheet sheet = workbookred.getSheetAt(0); // ��ȡ������
		int firstrow = sheet.getFirstRowNum(); // ��ʼ�� ��0��ʼ
		int lastrow = sheet.getLastRowNum(); // ĩ��
		
		/**
		 * �������� ����excel����ҽ���ȡ������д���ȥ
		 */
		String filename=filePath.substring(filePath.lastIndexOf("/")+1);			//��ȡ��ȡexcel��������
		FileOutputStream out = new FileOutputStream("C:/Users/thin/Desktop/"+filename+"-����"); // �����ļ���·��
		HSSFWorkbook workbook = new HSSFWorkbook();// ����Excel�ļ�(Workbook)
		HSSFSheet sheet1 = workbook.createSheet(); // ����������
		// ѭ�����
		for (int i = firstrow; i <= lastrow; i++) {
			HSSFRow row12 = sheet1.createRow(i);// ������,��1��ʼ
			// �����ж���
			Row row2 = sheet.getRow(i);
			// �ж���row2�����Ƿ�Ϊ��
			if (row2 != null) {
				int physicalNumberOfCells = row2.getPhysicalNumberOfCells(); // ��ȡ������
				short firstCellNum = row2.getFirstCellNum(); // ��һ�еĵ�һ����Ԫ�� 0��
				for (int j = firstCellNum; j < physicalNumberOfCells; j++) {
					Cell cell2 = row2.getCell(j); // ������Ԫ�����
					cell2.setCellType(CellType.STRING); // ���и��ı������
					// ��ȡ�е�����
					if (cell2.getStringCellValue().indexOf("\"") >= 0) {
						//�ж� ��������� �Ǵ���˫���ŵ� ��ô�ͽ����жϽ�ȡ˫�������������
						String name = cell2.getStringCellValue().substring(cell2.getStringCellValue().indexOf("\"") + 1,
								cell2.getStringCellValue().lastIndexOf("\""));
						row12.createCell(j).setCellValue(name);
					} else {
						//���û�еĻ��������
						row12.createCell(j).setCellValue(cell2.getStringCellValue().toString());
					}
				}
			}
		}
		/**
		 * ������д
		 */
		workbook.write(out);// ����Excel�ļ�
		out.close();// �ر��ļ���
	}
}
