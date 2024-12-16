package mouseActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/context-menu");
		Actions action=new Actions(driver);
		
		WebElement mouse=driver.findElement(By.id("hot-spot"));
		action.contextClick(mouse).perform();
		Alert a=driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(a.getText());
		a.accept();
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.close();
	}

}
