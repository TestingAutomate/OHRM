package com.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods {
	/*WebDriver driver;
	String Application_Url="http://127.0.0.1/orangehrm-4.2.0.1/"; 

	@Given("^User should open the ChromeBrowser$")
	
	public void user_should_open_the_ChromeBrowser()  {
		System.setProperty("webdriver.chrome.driver", "./BrowsersDriver/chromedriver.exe");
		driver=new ChromeDriver();
		// driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("browser launched");
	}*/
	WebDriver driver;
	String Application_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

	public OrangeHRMApplicationMethods(Hooks hook) {
	driver	=hook.driver;
	}
	@When("^User should Navigate to  OHRM Url Address$")
	public void user_should_Navigate_to_OHRM_Url_Address() throws Throwable {
		driver.get(Application_Url);
	Log.info("navigated to url");
	}

	@Then("^User should validate the Login Page Text$")
	public void user_should_validate_the_Login_Page_Text() throws Throwable {
		String Expected="LOGIN Panel";
		
		By loginTextProperty=By.id("logInPanelHeading");
		WebElement logintext	=driver.findElement(loginTextProperty);
		
		String actual_Text=logintext.getText();
		if(actual_Text.equals(Expected)) {
			//System.out.println("Pass");
			Log.info("Pass");
		
		}else {
			//System.out.println("Fail");
			Log.info("Fail");
		
		}
	}

	/*@Then("^User should close the Browser$")
	public void user_should_close_the_Browser() throws Throwable {
	    driver.close();
	    Log.info("closed the browser");
	 
	}*/

	
	

	


	

}
