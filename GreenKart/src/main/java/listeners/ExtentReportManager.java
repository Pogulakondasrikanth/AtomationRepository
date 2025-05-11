package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;
import utilities.Utility;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter  sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter("E:\\Automation\\GreenKart\\reports\\loginpage.html");
		sparkReporter.config().setDocumentTitle("GreenKart");
		sparkReporter.config().setReportName("LoginPage");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "Local");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Tester","Sri");
		extent.setSystemInfo("environment", "Test");
		extent.setSystemInfo("browserName", "chrome");
	
	}
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,"Test case Passed"+result.getName());
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		String Screenshot_path = null;
		try {
			 Screenshot_path = Utility.get_screenshot(result.getName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(Screenshot_path);
	}
	public void onTestSkip(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case Skipped"+ result.getName());
		
	}
	
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed"+result.getThrowable());
//		Object testClass = result.getInstance();
//		WebDriver driver = ((BaseTest) testClass).getDriver();
//		String Screenshot_path = null;
//		try {
//			 Screenshot_path = Utility.get_screenshot(result.getName(), driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		test.addScreenCaptureFromPath(Screenshot_path);
	
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	}

