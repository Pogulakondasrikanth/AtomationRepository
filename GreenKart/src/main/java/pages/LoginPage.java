package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	private By userNameField = By.id("userEmail");
	private By passwordField = By.id("userPassword");
	private By loginButton	= By.id("login");
	
	By passwordinputField = By.xpath("//input[contains(@class,'ng-valid') and @id='userPassword']");
	By userNameinputField = By.xpath("//input[contains(@class,'ng-valid') and @id='userEmail']");
	By invalidErrorMessage =By.xpath("//div[text()=' Incorrect email or password. ']");
	By emailErrorMessage = By.xpath("//div[text()='*Email is required']");
	By passwordErrorMerssage = By.xpath("//div[text()='*Password is required']");
	By loginText = By.xpath("//h1[@class='login-title']");
	By registerButton = By.xpath("//a[@class='btn1']");
	By emailAddress = By.xpath("//a[@href='emailto:dummywebsite@rahulshettyacademy.com']");
	By registerLink = By.cssSelector("p.login-wrapper-footer-text");
	By forgotPasswordLink = By.cssSelector("a.forgot-password-link:nth-of-type(1)");
		
	public void enterUserName(String userName) {
		driver.findElement(userNameField).sendKeys(userName);	
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public Boolean user_name_field() {
		return driver.findElement(userNameinputField).isEnabled();
	}
	
	public Boolean password_field() {
		return driver.findElement(passwordinputField).isEnabled();
	}
	
	public String invalid_error_message() {
		return driver.findElement(invalidErrorMessage).getText();
		
	}
	
	public String email_error_message() {
		return driver.findElement(emailErrorMessage).getText();
	}
	
	public String password_error_message() {
		return driver.findElement(passwordErrorMerssage).getText();
	}
	
	public WebElement login_text() {
		return driver.findElement(loginText);
	}
	
	public WebElement login_button() {
		return driver.findElement(loginButton);
	}
	
	public WebElement register_button() {
		return driver.findElement(registerButton);
	}
	
	public WebElement email_address() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement register_link() {
		return driver.findElement(registerLink);
	}
	
	public WebElement forgot_password_link() {
		return driver.findElement(forgotPasswordLink);
	}
	 public void login(String username, String password) {
	        enterUserName(username);
	        enterPassword(password);
	        clickOnLoginButton();
	    }

}
