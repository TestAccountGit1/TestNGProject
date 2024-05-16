package com.test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static WebDriver driver;
	@BeforeMethod(groups="smoke")
	public void launchBrowser() {
		 ChromeOptions option = new ChromeOptions();
		 option.addArguments("--disable-notifications");
		 option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		 option.setAcceptInsecureCerts(true);
		 
		 driver = new ChromeDriver(option);
		 driver.get(ReadInput.readData("URL"));
		 driver.manage().window().maximize();
		 Actions.implicitWait(driver, 6000);
		
		
	}
	
	@AfterMethod(groups="smoke")
	public void tearDown() {
		try {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
		}
		catch(Exception e)
		{
			e.toString();
		}
	}

}
