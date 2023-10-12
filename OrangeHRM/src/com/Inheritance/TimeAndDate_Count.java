package com.Inheritance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeAndDate_Count extends BaseTest {
	public void changesInTable() {
		By trProperty=By.tagName("tr");
	List<WebElement> tableElements=driver.findElements(trProperty);
	int trCount=tableElements.size();
	
	for(int trIndex=1;trIndex<trCount;trIndex++) {
	WebElement tableTrCount	=tableElements.get(trIndex);
	By tdProperty=By.tagName("td");
	List<WebElement> tableTdElement=driver.findElements(trProperty);
	int tdCount=tableElements.size();
	for(int tdIndex=1;tdIndex<tdCount;tdIndex++) {
		
		
		
		
	}
		
	}
	
		}

	public static void main(String[] args) {
		TimeAndDate_Count tc=new TimeAndDate_Count();
		tc.ApplicationLaunch();
		tc.applicationClose();
		
	}
}
