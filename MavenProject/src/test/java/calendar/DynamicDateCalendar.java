package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import browsercall.browsercall;

public class DynamicDateCalendar {
	public static void main(String[] args) throws Exception {
		WebDriver driver ;
		browsercall bc=new browsercall();
		driver=bc.browserinstance("chrome");
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("second_date_picker")).click();
		selectdate(driver, "10/08/2025");
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(By.id("first_date_picker")).click();
		selectdate(driver, "10/10/2023");
		driver.close();
		
	}
	public static void selectdate( WebDriver driver,String Date)throws Exception {
		String inputdate=Date;
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar=Calendar.getInstance();
		try {
			Date inputdateformat=dateformat.parse(inputdate);
			
			calendar.setTime(inputdateformat);
			System.out.println(inputdateformat);
		} catch (ParseException e) {
			 throw new Exception("invalid date please enter the valid date");
			 
			}
			int inputmonth=calendar.get(Calendar.MONTH);
			int inputyear=calendar.get(Calendar.YEAR);
			int inputday=calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println(inputyear);
			System.out.println(inputmonth);
			System.out.println(inputday);
			
			System.out.println();
		
		String date=driver.findElement(By.className("ui-datepicker-title")).getText();
		SimpleDateFormat currentdateformat=new SimpleDateFormat("MMM yyyy");
		Date currentdate=currentdateformat.parse(date);
		calendar.setTime(currentdate);
		int currentmonth=calendar.get(Calendar.MONTH);
		int currentyear=calendar.get(Calendar.YEAR);
		while(currentmonth>inputmonth || currentyear>inputyear) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
			String currentDate=driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			 currentmonth=calendar.get(Calendar.MONTH);
			 currentyear=calendar.get(Calendar.YEAR);
			
		}
		while(currentmonth<inputmonth || currentyear<inputyear) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
			String currentDate=driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			 currentmonth=calendar.get(Calendar.MONTH);
			 currentyear=calendar.get(Calendar.YEAR);
			
		}
		if(currentmonth==inputmonth || currentyear==inputyear)
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not (contains(@class, ' ui-datepicker-other-month'))]/a[text()="+inputday+"]")).click();
		else
			throw new Exception("unable to select the date because of the target and current date missmatch");

		
		
		
	}}


