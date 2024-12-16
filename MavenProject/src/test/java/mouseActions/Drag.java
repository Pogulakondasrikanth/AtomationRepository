package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/draggable/");
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	WebElement targetElement=driver.findElement(By.xpath("//div[@id='draggable']"));
	Actions a=new Actions(driver);
	a.dragAndDropBy(targetElement, 90, 10).perform();
	Thread.sleep(5000);
	driver.close();
}}
