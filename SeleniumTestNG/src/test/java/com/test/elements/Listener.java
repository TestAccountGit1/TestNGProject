package com.test.elements;

import java.io.File;

import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	File location = null;
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
		File imageLocation = Screenshot.takeScreenshot();
		location = new File("Screenshot/Success_Screenshot/"+result.getName()+".png");
		FileHandler.copy(imageLocation, location);
		ITestListener.super.onTestSuccess(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
		File imageLocation = Screenshot.takeScreenshot();
		location = new File("Screenshot/Failure_Screenshot/"+result.getName()+".png");
		FileHandler.copy(imageLocation, location);
		ITestListener.super.onTestFailure(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	

}
