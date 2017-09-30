package com.Sakiv.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.Sakiv.Base.TestBase;


public class TestUtils extends TestBase {
	
	public static String screenshotPath;
	public static String screenshotName;
	public static void captureScreenshot() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\screencap.jpg"));
	}
	
	@DataProvider(name="dp")
	public Object [][] getData(Method m){
		
		log.debug("Reading data from excel using Data provider");
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		log.debug("Reading data into Data object");
		Object[][] data = new Object[rows-1][1];
		Hashtable<String, String> table = new Hashtable<String, String>();
		
		for(int rowNum = 2; rowNum <= rows; rowNum++){
			
			for (int colNum = 0; colNum < cols; colNum++){
				table.put(excel.getCellData(sheetName, colNum , 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0] = table;
				
			}
			
		}
		
		return data;
				
	}

}
