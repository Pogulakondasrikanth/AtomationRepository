package ChromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserlaunch {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//		driver.findElement(By.className("search-keyword")).sendKeys("ca");
		driver.get("https://www.rajuniforms.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("laxman");
		//driver.findElement(By.)
	}
//	public void Homepage() {
		
	

}
