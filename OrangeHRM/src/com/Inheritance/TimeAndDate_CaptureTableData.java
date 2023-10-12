package com.Inheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hpbf.model.MainContents;
import org.apache.poi.hwpf.model.FileInformationBlock;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeAndDate_CaptureTableData extends BaseTest {
	
	public void capture_TableData() throws IOException {
		
		for(int rowIndex=1;rowIndex<=36;rowIndex++) {
		    //locator-Xpath  of Accra 
			//html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
			By cityNameXpath=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td[1]");
			WebElement cityName=driver.findElement(cityNameXpath);
			String nameOfTheCity=cityName.getText();
			System.out.println(rowIndex+""+nameOfTheCity);
			
			FileInputStream file=new FileInputStream("./src/com/excel/WebTableData.xlsx");
			XSSFWorkbook workBook= new XSSFWorkbook(file);
		   XSSFSheet sheetInExcel=workBook.getSheet("TestData");
		   Row  row= sheetInExcel.createRow(rowIndex);
		   
		   Cell rowOfCell = row.createCell(0);
		   rowOfCell.setCellValue(nameOfTheCity);
		   FileOutputStream newFile=new FileOutputStream("./src/com/excel/WebTableData.xlsx");
		   workBook.write(newFile);
	
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		TimeAndDate_CaptureTableData tt=new TimeAndDate_CaptureTableData();
		tt.ApplicationLaunch();
		tt.capture_TableData();
		tt.applicationClose();
	}
}
