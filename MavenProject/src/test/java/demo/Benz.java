package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Benz {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://supplier.mercedes-benz.com/portal/en");
		Thread.sleep(5000);
		WebElement shadowHost = driver.findElement(By.cssSelector("#usercentrics-root"));
		SearchContext shadowRoot = ((Object) shadowHost).getShadowRoot();
		WebElement shadowContent = shadowRoot.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(3)"));
		shadowContent.click();
		

		driver.findElement(By.cssSelector("button[role='button'][data-testid='uc-accept-all-button']")).click();
		Thread.sleep(2000);
		driver.close()	;
		
	}

}
