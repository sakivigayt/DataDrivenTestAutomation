package com.Sakiv.TestCases;

import java.util.Hashtable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Sakiv.Base.TestBase;
import com.Sakiv.Utils.TestUtils;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void addCustomer(Hashtable<String, String> testdata) {
		log.debug("Adding Customer");
		driver.findElement(By.xpath(prop.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(prop.getProperty("fName"))).sendKeys(testdata.get("firstName"));
		driver.findElement(By.xpath(prop.getProperty("lName"))).sendKeys(testdata.get("lastName"));
		driver.findElement(By.xpath(prop.getProperty("pCode"))).sendKeys(testdata.get("postCode"));
		driver.findElement(By.xpath(prop.getProperty("addCust"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains("Customer added"));
		alert.accept();
		log.debug("Customer Added");
		Reporter.log("Customer Added");
		Reporter.log("<a target=\"_blank\"href=\"C:\\Users\\vtyag2\\Desktop\\WIP\\Capture.png\"><img src=\"C:\\Users\\vtyag2\\Desktop\\WIP\\Capture.png\"></img></a>");
		
	}

}
