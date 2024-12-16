package mouseActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-down.php");
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		driver.close();
	}

}
