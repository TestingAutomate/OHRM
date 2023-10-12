package com.POMExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver;
	String Application_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login"; 
@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./BrowsersDriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Application_Url);
		// driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
@AfterTest
	public void tearDown() {
		 driver.close();

	}
}
