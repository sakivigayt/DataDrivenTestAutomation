package com.Sakiv.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Sakiv.Base.TestBase;
import com.Sakiv.Utils.TestUtils;


public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void openAccount(Hashtable<String, String> data) {
		log.debug("Opening Account");
		driver.findElement(By.xpath(prop.getProperty("openAcctBtn"))).click();
		Select selectCustomer = new Select(driver.findElement(By.xpath(prop.getProperty("customerCombo"))));
		selectCustomer.selectByVisibleText(data.get("customer"));
		Select selectCurrency = new Select(driver.findElement(By.xpath(prop.getProperty("currencyCombo"))));
		selectCurrency.selectByValue(data.get("currency"));
		driver.findElement(By.xpath(prop.getProperty("processBtn"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains("Account created"));
		alert.accept();
		log.debug("Account Open");
		Reporter.log("Account Open");
	
	}

}
