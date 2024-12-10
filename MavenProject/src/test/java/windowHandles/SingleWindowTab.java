package windowHandles;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleWindowTab {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentWindow=driver.getTitle();
		String parentTab=driver.getWindowHandle();
		WebElement textfield2=driver.findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
		textfield2.sendKeys("navigated to parent tab");
		System.out.println(textfield2.getAttribute("value"));
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windowHandle=driver.getWindowHandles();
		for(String window:windowHandle) {
			driver.switchTo().window(window);
			String title=driver.getTitle();
			if(!title.equals(parentWindow)) {
				driver.findElement(By.id("alertBox")).click();
				Alert a=driver.switchTo().alert();
				System.out.println(a.getText());
				a.accept();
				driver.findElement(By.id("confirmBox")).click();
				Alert b=driver.switchTo().alert();
				System.out.println(b.getText());
				b.accept();
				driver.findElement(By.id("promptBox")).click();
				Alert c=driver.switchTo().alert();
				System.out.println(c.getText());
				c.sendKeys("Srikanth");
				c.accept();
				Thread.sleep(3000);
				driver.close();
				
				
				}
		}
		Thread.sleep(2000);
		
		driver.switchTo().window(parentTab);
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		WebElement textfield3=driver.findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
		textfield3.clear();
		textfield3.sendKeys("succesfully navigated back to parent tab");
		System.out.println(textfield3.getAttribute("value"));
		driver.quit();
		
		
	}

}
