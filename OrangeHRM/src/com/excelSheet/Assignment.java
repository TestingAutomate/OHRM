package com.excelSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//Automate the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		//navigate to the  Orange Hrm URL address
		driver.get(applicationURLAddress);
		//Identify the Excel file in the system
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\src\\com\\excel\\AddEmployee.xlsx");
		//Identify the workbook in the excelfile 
		XSSFWorkbook excelWorkbook=new XSSFWorkbook(ExcelFile);
		//Identify the Sheet in the workbook
		XSSFSheet excelSheet =excelWorkbook.getSheet("TestData");
	
		// Validate LOGIN Panel Text 
		//Identify the Row in the sheet
		Row excelSheetRow=excelSheet.getRow(1);
		//Identify the cell of row which contains the expected data
		Cell cellOfRow_LOGINPanelText=excelSheetRow.getCell(0);
		String expectedLOGINPanelText=cellOfRow_LOGINPanelText.getStringCellValue();
		System.out.println("The Expected LOGINPanel Text -"+expectedLOGINPanelText);
		By LoginPaneltextproperty=By.id("logInPanelHeading");
		WebElement LoginpanelElement=driver.findElement(LoginPaneltextproperty);
		String actualLoginPaneltext = LoginpanelElement.getText();
		System.out.println("The Actual LOGINPanel Text -"+actualLoginPaneltext);
		
		Cell cellToSendActualValue=excelSheetRow.createCell(1);
		cellToSendActualValue.setCellValue(actualLoginPaneltext);
		
		if(actualLoginPaneltext.equals(expectedLOGINPanelText)) {
			System.out.println("The LOGIN Panel Text is Similar in both Expected and actual text data - Pass");
			Cell RowOfCellForResult=excelSheetRow.createCell(2);
			RowOfCellForResult.setCellValue("Pass");
		}else {
			System.out.println("The LOGIN Panel Text is not Similar in both Expected and actual text data - Fail");
			Cell RowOfCellForResult=excelSheetRow.createCell(2);
			RowOfCellForResult.setCellValue("Fail");
		}
		
		//Validate the login page Title
		Cell cell_LoginpageTitledata=excelSheetRow.getCell(3);
		String expected_LoginPageTitle=cell_LoginpageTitledata.getStringCellValue();
		System.out.println("The Expected LoginPage Title-"+expected_LoginPageTitle);
		String actualLoginPageTitle=driver.getTitle();
		System.out.println("The Expected LoginPage Title-"+actualLoginPageTitle);
		Cell cell_SetActualTitle=excelSheetRow.createCell(4);
		cell_SetActualTitle.setCellValue(actualLoginPageTitle);
		if(actualLoginPageTitle.equals(expected_LoginPageTitle)) {
			System.out.println("The Actual and Expected Login page title are similar-Pass");
		Cell cell_LoginTitleResult=excelSheetRow.createCell(5);
		cell_LoginTitleResult.setCellValue("Pass");
		
		}else {
			System.out.println("The Actual and Expected Login page title are not similar-Fail");
			Cell cell_LoginTitleResult=excelSheetRow.createCell(5);
			cell_LoginTitleResult.setCellValue("Fail");
		}
		//Verify Login With valid details 
		
		Cell cell_UserName=excelSheetRow.getCell(6);
		String Cell_UserName=cell_UserName.getStringCellValue();
		System.out.println("The Usernamedata in excel "+ Cell_UserName);
		
		By userNameProperty=By.id("txtUsername");
		WebElement userNameElement=driver.findElement(userNameProperty);
		userNameElement.sendKeys( Cell_UserName);
		
		Cell cell_PasswordInExcel=excelSheetRow.getCell(7);
		String Cell_PasswordData=cell_PasswordInExcel.getStringCellValue();
		System.out.println("The Password in excel "+ Cell_PasswordData);
		
		By passwordProperty=By.id("txtPassword");
		WebElement passwordElement=driver.findElement(passwordProperty);
		passwordElement.sendKeys( Cell_PasswordData);
		
		By loginButtonProperty=By.id("btnLogin");
		WebElement loginButton=driver.findElement(loginButtonProperty);
		loginButton.click();
		//Validate Admin homepage Text
		Cell adminTextInExcel=excelSheetRow.getCell(8);
		String Expected_AdminText=adminTextInExcel.getStringCellValue();
		System.out.println("The Expected text of OHRM App home page is-"+Expected_AdminText);
		By AdminTextProperty=By.id("welcome");
		WebElement actualAdminText=driver.findElement(AdminTextProperty);
		String actualTextOfAdminInHomePage=actualAdminText.getText();
		System.out.println("The Actual homepage text is-"+actualAdminText);
		Cell adminTextOfOHrmApp=excelSheetRow.createCell(9);
		adminTextOfOHrmApp.setCellValue(actualTextOfAdminInHomePage);
		if(actualTextOfAdminInHomePage.contains(Expected_AdminText)) {
			System.out.println("The Actual Hompepage Text contains Expected text then it's -Pass");
			Cell adminTextResult=excelSheetRow.createCell(10);
			adminTextResult.setCellValue("Pass");
		}
		else {
			System.out.println("The Actual Hompepage Text contains Expected text then it's -Pass");
			Cell adminTextResult=excelSheetRow.createCell(10);
			adminTextResult.setCellValue("Fail");
		}
			
		//Add Employee page with Full Name Validation
				By PIMProperty = By.id("menu_pim_viewPimModule");
				WebElement PIMmodule = driver.findElement(PIMProperty);
				Actions PIMactions = new Actions(driver);
				PIMactions.moveToElement(PIMmodule).build().perform();

				By AddEmployeeProperty = By.id("menu_pim_addEmployee");
				WebElement AddEmployee = driver.findElement(AddEmployeeProperty);
				AddEmployee.click();
			
				Cell testDataSheetRowOfCell11 = excelSheetRow.getCell(11);


				String ExpectedAddEmployeePageFullNameFromExcel = testDataSheetRowOfCell11.getStringCellValue();


				System.out.println("Welcome Text from Excel sheet is "+ExpectedAddEmployeePageFullNameFromExcel);
				By FullNameProperty = By.className("hasTopFieldHelp");
				WebElement FullName = driver.findElement(FullNameProperty);
				String ActualFullName = FullName.getText();

				System.out.println("Actual FullNametext is "+ActualFullName);

				Cell SheetRowOfCell12= excelSheetRow.createCell(12);

				SheetRowOfCell12.setCellValue(ActualFullName);

				if(ActualFullName.equals(ExpectedAddEmployeePageFullNameFromExcel))
				{
				System.out.println("Page succefully navigated to Add Employee details Page :- Pass");

				Cell SheetRowOfCell13Result= excelSheetRow.createCell(13);

				SheetRowOfCell13Result.setCellValue("Pass");
				}
				else
				{
				System.out.println("Failed to navigate to Add Employee Details page :- Fail");

				Cell SheetRowOfCell13Result= excelSheetRow.createCell(13);

				SheetRowOfCell13Result.setCellValue("Fail");
				}
		       
				
		
		
		
		
		
		
	FileOutputStream TestResultFile=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\src\\com\\excel\\AddEmployees.xlsx");
	excelWorkbook.write(TestResultFile);
	
	}

}
