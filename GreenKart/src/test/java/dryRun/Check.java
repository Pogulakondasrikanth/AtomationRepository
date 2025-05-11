package dryRun;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.investing.com/indices/india-indices");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		List<WebElement> sharesNames=driver.findElements(By.xpath("//td[contains(@class,'datatable-v2_cell__IwP1U')]//span[2]"));
		for(WebElement n:sharesNames) {
			System.out.println(n.getText());
		
		}
		WebElement HighValue= driver.findElement(By.xpath("//span[text()='NIfty smallcap 50']/ancestor::td/following-sibling:: td[2]"));
		System.out.println(HighValue.getText());
		WebElement LowValue= driver.findElement(By.xpath("//span[text()='NIfty smallcap 50']/ancestor::td/following-sibling:: td[3]"));
		System.out.println(LowValue.getText());
		
		
	
	}
}
