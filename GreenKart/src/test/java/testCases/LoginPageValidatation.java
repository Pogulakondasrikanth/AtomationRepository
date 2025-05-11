package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.LoginPage;

public class LoginPageValidatation extends BaseTest {
	LoginPage loginpage;
	
	@BeforeMethod
	public void loginpageSetup() {
		loginpage = new LoginPage(getDriver());
	}
	// Login page validations with different credentials 
	@Test (dataProvider = "readExcelData", enabled = false)
	public void login_page_validations(String username, String password) throws InterruptedException {
	
		if(username == null)
			username = "";
		if(password == null) 
			password = "";
		loginpage.login(username,password);

		if(username.isEmpty()) {
			Assert.assertEquals(loginpage.email_error_message(), "*Email is required");
		}

		if(password.isEmpty()) {
			Assert.assertEquals(loginpage.password_error_message(), "*Password is required");
		}
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		if(!username.isEmpty() && !password.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Incorrect email or password. ']")));
			String error_message = loginpage.invalid_error_message();

			System.out.println(error_message);
			Assert.assertEquals(error_message, "Incorrect email or password.");
		}
	}
	
	@Test
	public void validate_title() {
		Assert.assertEquals(getDriver().getTitle(), "Let's Sh");
	}
	
	@Test
	public void validate_login_text() {
		
		Assert.assertTrue(loginpage.login_text().isDisplayed());	
		}
	
	@Test
	public void validate_register_button() {
		Assert.assertTrue(loginpage.register_button().isEnabled());
	}
	
	@Test
	public void validate_email_address() {
		Assert.assertTrue(loginpage.email_address().isDisplayed());
	}
	
	@Test
	public void validate_forgot_password_link() {
		Assert.assertTrue(loginpage.forgot_password_link().isDisplayed());
	}
	
	@Test
	public void validate_register_link() {
		Assert.assertTrue(loginpage.register_link().isDisplayed());
	}
	
	@DataProvider(name ="readExcelData", parallel = false)
	public Object[][] login_data() throws  IOException {
		Object data[][] = read_data_from_excel();
		return data;
	}
}
