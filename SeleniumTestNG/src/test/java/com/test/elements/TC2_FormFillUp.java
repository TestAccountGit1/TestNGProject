package com.test.elements;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC2_FormFillUp extends BaseClass{
	
	@Test(dataProvider="dp", dataProviderClass=ReadInput.class , priority =1,groups="smoke")
	public void fillForm(String name , String email, String mobile) {
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		Actions.scrollDown(driver);
		driver.findElement(By.xpath("//*[@type='radio']/following::label[2]")).click();
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		
		
		
	}
	
	@Test(priority=3,groups="smoke")
	public void sum(){
		int sum =0/0;
		
	}

}
