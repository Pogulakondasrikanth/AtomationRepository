package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilities.Utility;

public class Listeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass= result.getInstance();
		WebDriver driver=((BaseTest) currentClass).getDriver();
		try {
			Utility.get_screenshot(result.getName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	
}
