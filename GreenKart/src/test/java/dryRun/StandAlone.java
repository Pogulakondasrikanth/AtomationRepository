package dryRun;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StandAlone {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/");
		System.out.println("Scroll actions");
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 500).perform();
		Thread.sleep(4000);
		WebElement element=driver.findElement(By.xpath("//div[@id='Feed1_feedItemListDisplay']//a[contains(text(),'Content Creation in 2025')]"));
		action.scrollToElement(element).perform();
		Thread.sleep(2000);
		Robot robot=new Robot(); 
		robot.mouseWheel(5);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0);"); // Scroll down by 500 pixels
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 500);");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}

}
