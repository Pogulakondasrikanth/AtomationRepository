package calendar;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalCalenderProgram {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("enter the date to select in calender in the below formate \n dd/mm/yyyy:\n");
		Scanner sc=new Scanner(System.in);
		String date=sc.nextLine();
		String[] dateformat=date.split("/");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/datepicker/");
		String inputmonth=dateformat[1];
		String inputdate=dateformat[0];
		String inputyear=dateformat[2];
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='datepicker'])[1]")).click();
		while(true) {
			String currentmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
			String currentyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			if(currentmonth.equals(inputmonth)&&currentyear.equals(inputyear)){
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td/a[text()="+inputdate+"]")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
