package nijeeshqwy.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nijeeshqwy.ShopMerchantOverAll;
import nijeeshqwy.resources.ExtentReporterNG;

public class Listerners extends ShopMerchantOverAll implements ITestListener{
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
	    // Code to be executed when a test method starts
		test= extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	    // Code to be executed on test method success
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
	    // Code to be executed on test method failure
		test.fail(result.getThrowable());
		String filepath = null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	    // Code to be executed when a test method is skipped
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // Code to be executed for a test method failed within success percentage
	}

//	@Override
//	public void onStart(ITestContext context) {
//	    // Code to be executed before any test method starts
//	}
	@Override
	public void onFinish(ITestContext context) {
	    // Code to be executed after all the test methods finish
		extent.flush();
	}


}
