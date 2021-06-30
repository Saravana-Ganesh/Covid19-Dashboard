package com.covid.utils;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	
	public static XSSFWorkbook createExcel(List list) throws Exception
	{
		// workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet
			= workbook.createSheet(" Student Data ");

		// creating a row object
		XSSFRow row;
		int rowid = 0;
		for(Object objectArr:list) {
			row = spreadsheet.createRow(rowid++);
			Object[] arr = (Object[]) objectArr;
			int cellid = 0;
			
			for (Object obj : arr) {
				Cell cell = row.createCell(cellid++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				if(obj instanceof BigDecimal) {
					BigDecimal bigDecimal = (BigDecimal)obj;
					cell.setCellValue(bigDecimal.toString());					
				}
			}
		}
		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		/*File f = new File("sheet.xlsx");
		FileOutputStream out = new FileOutputStream(f);*/

		/*workbook.write(out);
		out.close();*/
		return workbook;
	}
  
}
