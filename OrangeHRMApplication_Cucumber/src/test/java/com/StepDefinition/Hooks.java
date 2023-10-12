package com.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	//String Application_Url="http://127.0.0.1/orangehrm-4.2.0.1/"; 
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./BrowsersDriver/chromedriver.exe");
		driver=new ChromeDriver();
		// driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("browser launched");
	}
	@After
	public void tearDown() {
		 driver.close();
		    Log.info("closed the browser");
	}

}
