package com.autoIt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Log;

public class OrangeHRMApplicationAutoIt extends BaseTest {
	FileInputStream file;
	Properties properties;
	Log log=new Log();
	@Test(priority=1)
	public void applicationLogin() throws IOException{
		
		//Identify the file in the system
		file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Properties\\ApplicationProperties.properties");
		//getting the properties by creating the object for  properties class
		properties = new Properties();
		//loading the properties
		properties.load(file);
		By userNameProperty=By.id(properties.getProperty("ApplicationLogin_UserNameProperty"));
		WebElement	userName=driver.findElement(userNameProperty);
		userName.sendKeys("Admin");
		
		By passwordProperty=By.name(properties.getProperty("ApplicationLogin_PasswordProperty"));
		WebElement	passWord=driver.findElement(passwordProperty);
		passWord.sendKeys("Livetech@123");
		
		By loginButtonProperty=By.id(properties.getProperty("ApplicationLoginbtn_Click"));
		WebElement	loginButton=driver.findElement(loginButtonProperty);
		loginButton.click();
	}
	@Test(priority=2)
	public void validateWelcom() {
		By welcomeProperty=By.linkText(properties.getProperty("WelcomeAdmin_LinkText"));
		WebElement	welcome_Admin=driver.findElement(welcomeProperty);
		
		String expectedWelcomeAdminText="Admin";
		System.out.println("The Expected text="+expectedWelcomeAdminText);
		
		String ActualWelcomeAdminText=welcome_Admin.getText();
		//System.out.println("The Actual text="+ActualWelcomeAdminText);
		log.info("The Actual text="+ActualWelcomeAdminText);
		if(ActualWelcomeAdminText.contains(expectedWelcomeAdminText)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
	}
	@Test(priority=3)
	public void pim() {
		By pimProperty=By.id(properties.getProperty("PIMProperty"));
		WebElement	pim=driver.findElement(pimProperty);
		Actions action = new Actions(driver);
		action.moveToElement(pim).build().perform();		
	}
	@Test(priority=4)
	public void addEmployee() throws IOException, InterruptedException {
		By addEmployeeProperty=By.id(properties.getProperty("AddEmployeeProperty"));
		WebElement	addEmployee=driver.findElement(addEmployeeProperty);
		addEmployee.click();
		By firstNameProperty=By.id(properties.getProperty("FirstNameProperty"));
		WebElement	firstName=driver.findElement(firstNameProperty);
		firstName.sendKeys("hello01");
		
		Actions keyBoardactions =new Actions(driver);
		//perform tab keyboard operation
		keyBoardactions.sendKeys(Keys.TAB).build().perform();
		//send middlename data
		keyBoardactions.sendKeys("chello").build().perform();
		keyBoardactions.sendKeys(Keys.TAB).build().perform();
		//send last name data
		keyBoardactions.sendKeys("Bye").build().perform();
		keyBoardactions.sendKeys(Keys.TAB).build().perform();
		keyBoardactions.sendKeys(Keys.TAB).build().perform();
		keyBoardactions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		java.lang.Runtime.getRuntime().exec("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\AutoIt\\EmployeePhotograph.exe");
	
		//System.out.println("successfully uploaded the photo");
		log.info("successfully uploaded the photo");
		Thread.sleep(5000);
		//WebElement saveButton=driver.findElement(By.id("btnSave"));
		
		By saveButtonProperty =By.id("btnSave");
		WebElement  saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
		///html/body/div[1]/div[3]/div/div[1]/div/div/a/img
		WebElement EmployeeImg=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/div/a/img"));
		
		boolean flag=EmployeeImg.isDisplayed();
		if(flag) {
			//System.out.println("image uploaded");
			log.info("image uploaded");
		}else
		{
			//System.out.println("image not uploaded");
			log.info("image not uploaded");
		}
		
		}
	//Validate Logout
	@Test(priority=5,description="logout")
			public void logOut() throws InterruptedException {
			WebElement welcomeAdmin=driver.findElement(By.linkText("Welcome Admin"));
			welcomeAdmin.click();
			Thread.sleep(3000);
			WebElement	logOut=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[3]/a"));
			logOut.click();
			log.info("Successfully Logout");
	}
	

}
