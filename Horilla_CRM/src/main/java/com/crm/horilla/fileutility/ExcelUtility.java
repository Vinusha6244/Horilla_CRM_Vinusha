package com.crm.horilla.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String  getDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		String data=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		Thread.sleep(2000);
		workbook.close();
		return data;
	}
	
	public int  getRowCount(String sheet) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		int data=workbook.getSheet(sheet).getLastRowNum();
		workbook.close();
		return data;
	}
	
	public int  getCellCount(String sheet) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		int data=workbook.getSheet(sheet).getRow(1).getLastCellNum();
		workbook.close();
		return data;
	}
	
	public void  setDataIntoExcelWithNewRow(String sheet,int row,int cell,String value) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		workbook.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./TestData/HorillaTestscriptData.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}
	
	public void  setDataIntoExcel(String sheet,int row,int cell,String value) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		workbook.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./TestData/HorillaTestscriptData.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}
	
	public void  setDataIntoExcelWithNewCell(String sheet,int row,int cell,String value) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		workbook.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./TestData/HorillaTestscriptData.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}
	
	public String[][] readMultipleDataFromExcel(String sheetName) throws Throwable
	{
		FileInputStream excelfis=new FileInputStream("./TestData/HorillaTestscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		
		Sheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(1).getLastCellNum();
		String[][] data=new String[rowCount][cellCount];
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
			System.out.println();
		}
		return data;
	}

}