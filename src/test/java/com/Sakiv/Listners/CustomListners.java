package com.Sakiv.Listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Sakiv.Base.TestBase;
import com.Sakiv.Utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log("Suite executed");
		System.setProperty("org.uncommons.reporting.escape-output", "false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("Suite execution started");
		System.setProperty("org.uncommons.reporting.escape-output", "false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test started");
		test = rep.startTest(arg0.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.setProperty("org.uncommons.reporting.escape-output", "false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Capturing screenshot");
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+ " Pass");
		rep.endTest(test);
		rep.flush();
	}

}
