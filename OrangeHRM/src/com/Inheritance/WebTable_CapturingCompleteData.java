package com.Inheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable_CapturingCompleteData  extends BaseTest{
	//first row of first cell property-xpath
	//html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
	//Last row of last cell property-xpath
	///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
	
	public void captureTableData() throws IOException, InterruptedException {
		FileInputStream file=new FileInputStream("./src/com/excel/WebTableData1.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		for(int rowIndex=1;rowIndex<=36;rowIndex++) {
			Row rows=sheet.createRow(rowIndex);
			for(int rowOfCellIndex=1;rowOfCellIndex<8;rowOfCellIndex++){
				String xpath1="html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
				String xpath2="]/td[";
			    String xpath3="]";
			By	cityNamesProperty=By.xpath(xpath1+rowIndex+xpath2+rowOfCellIndex+xpath3);
			Thread.sleep(2000);
			WebElement cityName=driver.findElement(cityNamesProperty);
			String tableData=cityName.getText();
			System.out.print(tableData+"");
			Cell rowOfCells=rows.createCell(rowOfCellIndex);
			rowOfCells.setCellValue(tableData);
			FileOutputStream newFile=new FileOutputStream("./src/com/excel/WebTableData1.xlsx");
			workbook.write(newFile);
			
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		WebTable_CapturingCompleteData captureComplete_TableData=new WebTable_CapturingCompleteData();
		captureComplete_TableData.ApplicationLaunch();
		captureComplete_TableData.captureTableData();
		captureComplete_TableData.applicationClose();
	}

}
