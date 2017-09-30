package com.Sakiv.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Sakiv.Utils.ExcelReader;
import com.Sakiv.Utils.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	
	/*
	 * WebDriver
	 * properties
	 * configuration
	 * OR
	 * TestNG
	 * runner
	 * data
	 * logs
	 * reports 
	 */
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream conffis;
	public static FileInputStream objfis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testData.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentReport.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException{
		
		if (driver==null){
			prop = new Properties();
			conffis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			objfis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\objects.properties");
			try {
				prop.load(conffis);
				log.debug("config loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				prop.load(objfis);
				log.debug("OR loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String browser;
			String appUrl;
			browser=prop.getProperty("browser");
			appUrl=prop.getProperty("appUrl");
			
			if (browser.toLowerCase().equals("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("chrome launched");
			}
			
			if (browser.toLowerCase().equals("firefox")){
				driver = new FirefoxDriver();
				log.debug("Firefox launched");
			}
			
			if (browser.toLowerCase().equals("ie")){
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("IE launched");
			}
			
			driver.get(appUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
			log.debug(appUrl+ " launched");
			wait = new WebDriverWait(driver, 5);
			
		}
		
			
	}
	
	
	public boolean checkElementPresence(By by){
		try{
			driver.findElement(by);
			log.debug(by + "element present");
			return true;
		}		
		
		catch(NoSuchElementException e){
			log.debug(by + "element not present");
			return false;
			
		}
		
				
	}
	
	
	@AfterSuite
	public void tearDown(){
		if (driver!=null){
			driver.quit();
		}
		log.debug("inside tear down -- driver quit");
		log.debug("Test suite Executed");
	}
	
}
