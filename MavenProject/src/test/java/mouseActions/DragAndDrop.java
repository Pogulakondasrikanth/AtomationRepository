package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/dropable");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement sourceelement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetelement=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions a=new Actions(driver);
		Thread.sleep(2000);
		a.dragAndDrop(sourceelement, targetelement).perform();
		Thread.sleep(2000);
		driver.close();
	}

}
