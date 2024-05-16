package com.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC1_LoginDetails extends BaseClass{
	
	@Test(priority =0, groups="smoke")
	public void checkLoginDetails() {
		try {
		driver.findElement(By.xpath("//a[contains(text(),' Login')]")).click();
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(ReadInput.readData("Email"));
		WebElement psw = driver.findElement(By.xpath("//input[@id='password']"));
		psw.sendKeys(ReadInput.readData("Password"));
		
		Thread.sleep(30);
		email.clear();
		psw.clear();
		driver.navigate().refresh();
		
		for(int i=0;i<2 ;i++) {
			if(i==0) {
				try {
					System.out.println("<----------TC1 first time---------->");
				email.sendKeys(ReadInput.readData("Email"));
				psw.sendKeys(ReadInput.readData("Password"));
				}
				catch(StaleElementReferenceException e) {
					System.err.println("Thread interrupted: " + e.getMessage());
					e.printStackTrace();
				}
			}
			if(i==1) {
				try {
				System.out.println("<----------TC1 second time---------->");
				email = driver.findElement(By.xpath("//input[@id='email']"));
				 psw = driver.findElement(By.xpath("//input[@id='password']"));
				 email.sendKeys(ReadInput.readData("Email"));
			     psw.sendKeys(ReadInput.readData("Password"));
				}
				catch(Exception e) {
					System.err.println("Thread interrupted: " + e.getMessage());
					e.printStackTrace();
				}
			}
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
