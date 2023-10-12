package com.Inheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest{
		 public static WebDriver driver;
			public void ApplicationLaunch(){
				String applicationURLAddress="https://www.timeanddate.com/worldclock/";
				//Automate the browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Browsers\\chromedriver.exe");
				driver=new ChromeDriver();
				//navigate to the  Orange Hrm URL address
				driver.get(applicationURLAddress);
				
			}
			public void applicationClose() {
				driver.quit();
			}
	}

////for(WebElement ele:linksNames) {
//	System.out.println(ele.getText());

