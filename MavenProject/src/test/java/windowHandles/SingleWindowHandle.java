package windowHandles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleWindowHandle {
	@Test
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Creating a chrome driver instance
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigating to url
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		WebElement textfield=driver.findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
		textfield.sendKeys("succesfully login");
		System.out.println(textfield.getAttribute("value"));
		driver.findElement(By.id("newWindowBtn")).click();
		String parentWindow=driver.getWindowHandle();
		Set<String> windows= driver.getWindowHandles();
		for(String windowHandle:windows) {
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("Srikanth");
				driver.findElement(By.id("lastName")).sendKeys("Pogulakonda");
				driver.findElement(By.xpath("//input[@id='malerb']")).click();
				driver.findElement(By.id("englishchbx")).click();
				driver.findElement(By.id("hindichbx")).click();
				driver.findElement(By.id("email")).sendKeys("Srikanth@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Srikanth@123");
				Thread.sleep(2000);
				driver.findElement(By.id("registerbtn")).click();
				Thread.sleep(2000);
				WebElement registration=driver.findElement(By.id("msg"));
				String message=registration.getText();
				if(message.equals("Registration is Successful"));
				Thread.sleep(2000);
				driver.close();	
			}
		}
		driver.switchTo().window(parentWindow);
		driver.manage().window().maximize();
		Thread.sleep(7000);
		WebElement textfield2=driver.findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
		textfield2.sendKeys("succesfully navigated back to parent tab");
		System.out.println(textfield2.getAttribute("value"));
		Thread.sleep(7000);
		driver.quit();
		
		
		
	}

}
