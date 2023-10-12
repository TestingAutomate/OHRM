package com.autoIt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	public static WebDriver driver;
	String Application="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	@BeforeTest
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","./Browsers/chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.get(Application);
	driver.manage().window().maximize();
	
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
