package calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import browsercall.browsercall;

public class CurrentMonthDate {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		browsercall bc=new browsercall();
		driver=bc.browserinstance("edge");
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.id("first_date_picker")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	
	

}
