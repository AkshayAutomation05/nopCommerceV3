package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sht;
	public static Cell cel;
	
	public static int getRowNumber(String path,String sheetName) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sht=wb.getSheet(sheetName);
		int row=sht.getLastRowNum();
		wb.close();
		fis.close();
		return row;		
	}
	
	public static int getColNumber(String path,String sheetName,int row) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sht=wb.getSheet(sheetName);
		int col=sht.getRow(row).getLastCellNum();
		wb.close();
		fis.close();
		return col;
		
	}
	
	public static String getCellData(String path,String sheetName,int i,int j) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sht=wb.getSheet(sheetName);
		cel=sht.getRow(i).getCell(j);
		
		String str="";
		if(cel.getCellType()==CellType.STRING)
		{
			str=cel.getStringCellValue();
		}else if(cel.getCellType()==CellType.NUMERIC)
		{
			str=String.valueOf(cel.getNumericCellValue());
		}
		return str;
	}
	
	public static void setCellData(String path,String sheetName,int i,int j,String val) throws Exception
	{
		
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sht=wb.getSheet(sheetName);
		cel=sht.getRow(i).createCell(j);
		cel.setCellValue(val);
		fos=new FileOutputStream(path);
		wb.write(fos);
		fis.close();
		wb.close();
		fos.close();
		
		
	}
	

}
