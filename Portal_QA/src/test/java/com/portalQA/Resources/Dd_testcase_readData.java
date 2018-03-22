package com.portalQA.Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dd_testcase_readData {
	
	public void readExcel(String filepath, String fileName, String sheetName) throws IOException{
		
		//open Excel file
		File file=new File(filepath+"//"+fileName);
		
		//read excel file
		FileInputStream fis=new FileInputStream(file);
		
		//initialise Workbook variable
		Workbook wb=null;
		
		//splitting the file name and extension
		
		String fileExtName=fileName.substring(fileName.indexOf("."));
		
		if(fileExtName.equals(".xlsx")){
			wb=new XSSFWorkbook(fis);
		}
		else if(fileExtName.equals(".xls")){
			wb=new HSSFWorkbook(fis);
		}
		
		//read excel file by its name
		
		Sheet sheet=wb.getSheet(sheetName);
		
		
		//find number of rows in excel file. We exclude the first row.. this is the column name
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rowCount);
		
		//create a loop for rows of excel file to read it
		for (int i=0; i<rowCount+1; i++){
			
			Row row=sheet.getRow(i);
		
			//create a loop to print cell values in a row
			
		for (int j=0; j<row.getLastCellNum(); j++){
			
			//print excel data in console window
			System.out.print(row.getCell(j).getStringCellValue()+"  -   ");
	
		}
		
		System.out.println();
		
		}
	}
		

		 public static void main(String[] args) throws IOException{
		 			  
			 Dd_testcase_readData readExcelFile = new Dd_testcase_readData();

			    //Prepare the path of excel file

			    String filePath = "//home//mobiroo//Downloads//datadriven//src//test//java//Framework//datadriven//";

			    //Call read file method of the class to read data

			    readExcelFile.readExcel(filePath,"testdata.xlsx","LoginTest");

		 }
		
	}


