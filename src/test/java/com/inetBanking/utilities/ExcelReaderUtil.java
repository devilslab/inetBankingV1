package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {
	
	public static FileInputStream InputStream;
	public static FileOutputStream OutputStream;
	public static XSSFWorkbook Workbook;
	public static XSSFSheet Sheet;
	public static XSSFRow Row; 
	public static XSSFCell Cell;
	
	public static int getRowCount(String Xlfile, String Xlsheet) throws IOException
	{
		InputStream = new FileInputStream(Xlfile);
		Workbook = new XSSFWorkbook(InputStream);
		Sheet = Workbook.getSheet(Xlsheet);
		int rowcount = Sheet.getLastRowNum();
		Workbook.close();
		InputStream.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String Xlfile , String Xlsheet , int rownum) throws IOException
	{
		InputStream = new FileInputStream(Xlfile);
		Workbook = new XSSFWorkbook(InputStream);
		Sheet = Workbook.getSheet(Xlsheet);
		Row = Sheet.getRow(rownum);
		int Cellcount = Row.getLastCellNum();
		Workbook.close();
		InputStream.close();
		return Cellcount;
		
		
	}
	
	public static String getCellData(String Xlfile , String Xlsheet , int rownum , int cellnum ) 
			throws IOException
	{
		InputStream = new FileInputStream(Xlfile);
		Workbook = new XSSFWorkbook(InputStream);
		Sheet = Workbook.getSheet(Xlsheet);
		Row = Sheet.getRow(rownum);
		Cell = Row.getCell(cellnum);
		String Data = null;
		try
		{
			DataFormatter formatter  = new DataFormatter();
			String cellData = formatter.formatCellValue(Cell);
			return cellData;
		}
		catch (Exception e)
		{
			Data="";
			
			
		}
		Workbook.close();
	    InputStream.close();
	    return Data;
		
	}
	
	public static void SetCellData(String Xlfile , String Xlsheet , int rownum , int cellnum , String Data)
	throws IOException
	{
		InputStream = new FileInputStream(Xlfile);
		Workbook = new XSSFWorkbook(InputStream);
		Sheet = Workbook.getSheet(Xlfile);
		Row = Sheet.getRow(rownum);
		Cell = Row.createCell(cellnum);
		Cell.setCellValue(Data);
		OutputStream = new FileOutputStream(Xlfile);
		Workbook.write(OutputStream);
		Workbook.close();
		InputStream.close();
		OutputStream.close();
			
	}

}
