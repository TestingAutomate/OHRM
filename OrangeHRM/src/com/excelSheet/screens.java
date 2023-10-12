package com.excelSheet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screens {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		//Automate the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(6000);
		//navigate to the  Orange Hrm URL address
		driver.get(applicationURLAddress);
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(file, new File("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Screenshots\\ScreenShot.jpg"));
		
	driver.quit();
	}

}
