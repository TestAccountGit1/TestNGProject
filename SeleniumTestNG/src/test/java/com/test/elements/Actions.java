package com.test.elements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Actions extends BaseClass{
	
	public static void implicitWait(WebDriver driver , int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		
	}
	
	public static void scrollDown(WebDriver driver) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 300);");
	}

}
