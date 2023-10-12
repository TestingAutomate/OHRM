package com.excelSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginText {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		   String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		   
		   //Automating the browser
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\user\\\\eclipse-workspace\\\\OrangeHRM\\\\Browsers\\\\chromedriver.exe");
		driver = new ChromeDriver();

		  //Navigating to the application URL address
		driver.get(applicationUrlAddress);
		    FileInputStream testDataFile = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\src\\com\\excel\\LogInTest.xlsx");

		//Identify the WorkBook of the file
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);

		//Identify a particular sheet in the WorkBook
		XSSFSheet TestDataSheet = workBook.getSheet("Sheet1");

		//Identify a Row in the sheet
		Row testDataSheetRowURL = TestDataSheet.getRow(1);

		//Identify the row of cell in a row
		Cell testDataSheetRowOfCellUrl = testDataSheetRowURL.getCell(6);

		//Get the data from a Row of cell
		String ExpectedApplicationUrlAddress = testDataSheetRowOfCellUrl.getStringCellValue();
		     System.out.println("Expected Current url address is " +ExpectedApplicationUrlAddress);
		 


		//Current URL Validation
		     
		String actualCurrentUrlAddress=driver.getCurrentUrl();
		    Row testDataSheetRowUrl= TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell7= testDataSheetRowUrl.createCell(7);

		testDataSheetRowOfCell7.setCellValue(actualCurrentUrlAddress);

		System.out.println("actual Current url address is  " +actualCurrentUrlAddress);

		if(actualCurrentUrlAddress.contains(ExpectedApplicationUrlAddress))
		{
		System.out.println("Actual and expected url addresses are same:-Pass");
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell8Result= testDataSheetRow1Result.createCell(8);

		testDataSheetRowOfCell8Result.setCellValue("Pass");

		}
		else
		{
		System.out.println("Actual and expected url addresses are not same:-Fail");
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell8Result= testDataSheetRow1Result.createCell(8);

		testDataSheetRowOfCell8Result.setCellValue("Fail");
		     }

		  //Login Panel Text Validation

		Row testDataSheetRow = TestDataSheet.getRow(1);

		//Identify the row of cell in a row
		Cell testDataSheetRowOfCell = testDataSheetRow.getCell(0);

		//Get the data from a Row of cell
		String ExpectedloginPanelText = testDataSheetRowOfCell.getStringCellValue();

		System.out.println("Expected Login Panel Text from Excel sheet is "+ExpectedloginPanelText);


		By LoginPanelProperty = By.id("logInPanelHeading");


		   WebElement LoginPanelText = driver.findElement(LoginPanelProperty);
		String ActualLoginPanelText = LoginPanelText.getText();

		System.out.println("Actual login panel text is " + ActualLoginPanelText);

		Row testDataSheetRow1 = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell1= testDataSheetRow1.createCell(1);

		testDataSheetRowOfCell1.setCellValue(ActualLoginPanelText);

		if(ActualLoginPanelText.equals(ExpectedloginPanelText))
		{
		System.out.println("Successfully navigated to Login Panel page :- Pass");
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell1Result= testDataSheetRow1Result.createCell(2);

		testDataSheetRowOfCell1Result.setCellValue("Pass");

		}
		else {
		          Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell1Result= testDataSheetRow1Result.createCell(2);

		testDataSheetRowOfCell1Result.setCellValue("Fail");
		}

		//Login Page Title Validation

		Row testDataSheetRowTitleExpected = TestDataSheet.getRow(1);
		    Cell testDataSheetRowOfCellTitle = testDataSheetRowTitleExpected.getCell(3);


		String ExpectedloginPageTitle = testDataSheetRowOfCellTitle.getStringCellValue();


		System.out.println("Expected Login Page Title from Excel sheet is "+ExpectedloginPageTitle);

		String ActualPageTitle = driver.getTitle();
		System.out.println("Actual Page Title is " +ActualPageTitle);
		    Row testDataSheetRowTitleActual = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell4= testDataSheetRowTitleActual.createCell(4);

		testDataSheetRowOfCell4.setCellValue(ActualPageTitle);
		if(ActualPageTitle.equals(ExpectedloginPageTitle))
		{
		 System.out.println("Expected and actual page title matched :-Pass");
		 Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell5Result= testDataSheetRow1Result.createCell(5);

		testDataSheetRowOfCell5Result.setCellValue("Pass");

		}
		else
		{
		System.out.println("Expected and actual page title not matched :-Fail");
		       Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell5Result= testDataSheetRow1Result.createCell(5);

		testDataSheetRowOfCell5Result.setCellValue("Fail");
		}

		//Login Validation
		    Row testDataSheetRowUserName = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell9 = testDataSheetRowUserName.getCell(9);

		String userNameTestData = testDataSheetRowOfCell9.getStringCellValue();

		System.out.println("Login User Name from Excel sheet is "+userNameTestData);

		By UserNameProperty = By.id("txtUsername");
		WebElement userName = driver.findElement(UserNameProperty);
		userName.sendKeys(userNameTestData);

		Row testDataSheetRowPassWord = TestDataSheet.getRow(1);


		Cell testDataSheetRowOfCell10 = testDataSheetRowPassWord.getCell(10);


		String PassWordTestData = testDataSheetRowOfCell10.getStringCellValue();


		System.out.println("Login Password from Excel sheet is "+PassWordTestData);
		// String PasswordTestData = "Livetech@123";
		By PasswordProperty = By.id("txtPassword");
		WebElement password = driver.findElement(PasswordProperty);
		password.sendKeys(PassWordTestData);

		By LoginButtonProperty = By.id("btnLogin");
		WebElement LoginButton = driver.findElement(LoginButtonProperty);
		LoginButton.click();
		Row testDataSheetRowWelcomeText = TestDataSheet.getRow(1);


		Cell testDataSheetRowOfCell11 = testDataSheetRowWelcomeText.getCell(11);


		String ExpectedloginWelcomeText = testDataSheetRowOfCell11.getStringCellValue();


		System.out.println("Welcome Text from Excel sheet is "+ExpectedloginWelcomeText);
		By WelcomeAdminProperty = By.id("welcome");
		WebElement WelcomeAdminText = driver.findElement(WelcomeAdminProperty);
		String ActualWelcomeAdmin = WelcomeAdminText.getText();

		System.out.println("Actual Welcome Text message is " +ActualWelcomeAdmin);
		Row testDataSheetRowWelcomeTextActual = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell12= testDataSheetRowWelcomeTextActual.createCell(12);

		testDataSheetRowOfCell12.setCellValue(ActualWelcomeAdmin);
		if(ActualWelcomeAdmin.contains(ExpectedloginWelcomeText))
		{
		System.out.println("Welcome admin message displayed: - Pass");
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell13Result= testDataSheetRow1Result.createCell(13);

		testDataSheetRowOfCell13Result.setCellValue("Pass");
		}
		else
		{
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell13Result= testDataSheetRow1Result.createCell(13);

		testDataSheetRowOfCell13Result.setCellValue("Fail");

		System.out.println("Welcome admin message not displayed: - Fail");
		}
		WelcomeAdminText.click();
		Thread.sleep(5000);

		 By logoutButtonPtoperty = By.linkText("Logout");
		 WebElement LogoutButton = driver.findElement(logoutButtonPtoperty);
		 LogoutButton.click();
		 
		 //Login Panel Validation After Logout
		 
		 Row testDataSheetRowLoginPanel = TestDataSheet.getRow(1);


		Cell testDataSheetRowOfCell14 = testDataSheetRowLoginPanel.getCell(14);


		String ExpectedloginPanelTextAfterLogout = testDataSheetRowOfCell14.getStringCellValue();

		System.out.println("Expected Login Panel Text After Logout from Excel sheet is "+ExpectedloginPanelTextAfterLogout);


		By LoginPanelPropertyAfterLogout = By.id("logInPanelHeading");


		  WebElement LoginPanelTextAfterLogout = driver.findElement(LoginPanelPropertyAfterLogout);
		String ActualLoginPanelTextAfterLogout = LoginPanelTextAfterLogout.getText();

		System.out.println("Actual login panel text After Logout is " + ActualLoginPanelTextAfterLogout);

		Row testDataSheetRow1Actual = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell15= testDataSheetRow1Actual.createCell(15);

		testDataSheetRowOfCell15.setCellValue(ActualLoginPanelTextAfterLogout);

		if(ActualLoginPanelText.equals(ExpectedloginPanelText))
		{
		System.out.println("Successfully navigated to Login Panel page :- Pass");
		Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell16Result= testDataSheetRow1Result.createCell(16);

		testDataSheetRowOfCell16Result.setCellValue("Pass");

		}
		else {
		System.out.println("Failed to navigated to Login Panel page :- Fail");
		         Row testDataSheetRow1Result = TestDataSheet.getRow(1);

		Cell testDataSheetRowOfCell16Result= testDataSheetRow1Result.createCell(16);

		testDataSheetRowOfCell16Result.setCellValue("Fail");
		}

		FileOutputStream excelActulaLoginPageText = new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\src\\com\\excel\\LogInTest.xlsx");
		workBook.write(excelActulaLoginPageText);

		 
		driver.quit();
	}

}
