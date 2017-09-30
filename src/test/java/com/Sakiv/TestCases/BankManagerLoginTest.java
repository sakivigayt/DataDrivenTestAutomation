package com.Sakiv.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Sakiv.Base.TestBase;


public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void LoginAsBankManager() throws InterruptedException{
		driver.findElement(By.cssSelector(prop.getProperty("bmlbtn"))).click();
		Thread.sleep(1000);
		log.debug("navigated to bank manager page");
		Reporter.log("Navigated to bank manager home page");
		Assert.assertTrue(checkElementPresence(By.xpath(prop.getProperty("addCustBtn"))),"Login Not Successful");
	}
	

}
