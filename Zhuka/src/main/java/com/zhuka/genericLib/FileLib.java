package com.zhuka.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib
{
	public String Readexceldata(String path, String sheetname, int Row, int Cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(path);
		 Workbook wb = WorkbookFactory.create(fis);
		 String excelvalue = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		 return excelvalue;
		}
	public String Readpropertydata(String proppath, String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(proppath);
		Properties prop =new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key, "Incorrect Key");
		return propValue;
		
	}
	public void Writeexceldata(String path, String sheetname,int row, int cell, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(path);
		 Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(data);
		 FileOutputStream fos = new FileOutputStream(path);
		 wb.write(fos);	
	}
	public int getRowcount(String path,String sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb =WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheet).getLastRowNum();
		return rowcount;
	}



}
