package com.excelSheet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
   WebDriver driver;
	public void ApplicationLaunch(){
		String applicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		//Automate the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		//navigate to the  Orange Hrm URL address
		driver.get(applicationURLAddress);
		
	}
	public void headerProperty() throws InterruptedException, IOException {
		// identify Header block
					//<div class="menu"></div>
					By HeaderBlockProperty=By.className("menu");
					WebElement HeaderBlock=driver.findElement(HeaderBlockProperty);

					// identify the elements of the TSRTC Header Block
					// <a class="selectedtabcopy" href="/oprs-web/guest/home.do?h=1" target="_top" title="Home"> Home</a>
					// <a class="tabcopy blinking" href="/oprs-web/guest/specialHire.do" target="_top" title="Bus on Contract">Bus on Contract</a>
					// <a class="tabcopy" href="/oprs-web/guest/ticket/cancel.do" target="_top" title="Cancel Tickets">Cancel Tickets</a>

					By linksProperty=By.tagName("a");
					List<WebElement>HeaderBlockLinks =HeaderBlock.findElements(linksProperty);

					// finding the size of the ArrayList(tsrtc_HeaderBlockLinks)
					int HeaderBlockLinksCount=HeaderBlockLinks.size();
					System.out.println(" The number of elements of type links in the Header Block of TSRTC Application HomePage are :- "+HeaderBlockLinksCount);

					Thread.sleep(2000);
					for(int index=0;index<HeaderBlockLinksCount;index++)
					{
					String headerBlockLinkName=HeaderBlockLinks.get(index).getText();
					System.out.println(index+" "+headerBlockLinkName);
					HeaderBlockLinks.get(index).click();

					String expected_webPageCurrentUrlAddress=driver.getCurrentUrl();
					System.out.println("The Expected Url Address of the links of the WebPage is :- "+expected_webPageCurrentUrlAddress);

					
					
					
					String actual_webPageCurrentUrlAddress=driver.getCurrentUrl();
					System.out.println("The Actual Url Address of the links of the WebPage is :- "+actual_webPageCurrentUrlAddress);
					
					
					System.out.println();
				
					//comparing the Actual and Expected URLs
					if(expected_webPageCurrentUrlAddress.equals(actual_webPageCurrentUrlAddress)) {
					System.out.println("The Actual and the expected URLs of the TSRTC app is similar");
					}else {
					System.out.println("The Actual and the expected URLs of the TSRTC app is not similar");
					}
					//Thread.sleep(2000);
					File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(file, new File("C:\\Users\\user\\eclipse-workspace\\OrangeHRM\\Screenshots\\"+headerBlockLinkName+"screenshot3.png"));
					
					driver.navigate().back();
					
					HeaderBlock=driver.findElement(HeaderBlockProperty);
					HeaderBlockLinks=HeaderBlock.findElements(linksProperty);
								
					
	}
	
	}
	
		public static void main(String[] args) throws InterruptedException, IOException {
			
			Screenshot ss=new Screenshot();
			ss.ApplicationLaunch();
			ss.headerProperty();
			ss.applicationClose();
		}
		public void applicationClose() {
			driver.quit();
		}
			
	
		
	}


