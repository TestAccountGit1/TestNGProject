package com.test.elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ReadInput {
	static String value;
	
	public static String readData(String key) {
		try {
		FileInputStream fis = new FileInputStream("src/test/resources/Configuration/Setup.properties");
		Properties prob = new Properties();
		prob.load(fis);
		 value = prob.getProperty(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	@DataProvider(name = "dp")
	public Object[][] getData() {
	    Object[][] data = null;
	    try (FileInputStream fis = new FileInputStream("src/test/resources/Excel sheet/Data.xlsx");
	         XSSFWorkbook wb = new XSSFWorkbook(fis)) {
	        XSSFSheet sheet = wb.getSheet(readData("Sheet"));
	        int totalRow = sheet.getLastRowNum() + 1; // Adding 1 to include the last row
	        int totalCol = sheet.getRow(0).getLastCellNum();
	        data = new Object[totalRow - 1][totalCol]; // Adjusted the row count to exclude header row
	        DataFormatter format = new DataFormatter();
	        for (int i = 1; i < totalRow; i++) { // Start from index 1 to skip header row
	            XSSFRow row = sheet.getRow(i);
	            for (int j = 0; j < totalCol; j++) {
	                XSSFCell cell = row.getCell(j);
	                data[i - 1][j] = format.formatCellValue(cell);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return data != null ? data : new Object[0][0]; // Return empty array if data is null
	}
	}
	


