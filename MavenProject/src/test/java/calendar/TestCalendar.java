package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalendar {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		driver.findElement(By.id("first_date_picker")).click();
		selectDate(driver, "05/10/2025");

		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "05/09/2020");
	}

	public static void selectDate(WebDriver driver, String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			Date formattedTargetDate = targetDateFormat.parse(date);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!!");
		}
		
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

		String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		while(currentMonth < targetMonth || currentYear < targetYear) {
			driver.findElement(By.className("ui-datepicker-next")).click();
			currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}

		while(currentMonth > targetMonth || currentYear > targetYear) {
			driver.findElement(By.className("ui-datepicker-prev")).click();
			currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}

		if(currentMonth == targetMonth && currentYear == targetYear)
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="+targetDay+"]")).click();
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
	}
}
