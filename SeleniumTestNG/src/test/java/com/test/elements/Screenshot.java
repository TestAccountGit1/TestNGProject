package com.test.elements;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends BaseClass {
	 
	static File imageLocation = null;
	public static File takeScreenshot() {
		try {
		TakesScreenshot ss = (TakesScreenshot) driver;
		 imageLocation = ss.getScreenshotAs(OutputType.FILE);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return imageLocation;
	}
	

}
