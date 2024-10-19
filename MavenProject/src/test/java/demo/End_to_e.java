package demo;


	

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class End_to_e {

		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Login to Login page
			driver.findElement(By.xpath("//a[@title='My Account']")).click();

			driver.findElement(By.linkText("Login")).click();

			// Login to the application with valid credentials

			driver.findElement(By.id("input-email")).sendKeys("varunc9391@gmail.com");

			driver.findElement(By.id("input-password")).sendKeys("Varunkumar@123");

			driver.findElement(By.xpath("//input[@value='Login']")).click();

			System.out.println(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

			// Searching for iphone

			driver.findElement(By.name("search")).sendKeys("hp");

			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

			System.out.println(driver.findElement(By.linkText("HP LP3065")).isDisplayed()); // True

			// Adding the item product display page to cart

			driver.findElement(By.linkText("HP LP3065")).click();

			System.out.println(driver.findElement(By.linkText("HP LP3065")).getText()); // True

			WebElement quantity = driver.findElement(By.id("input-quantity"));

			quantity.clear();
			quantity.sendKeys("2");

			driver.findElement(By.id("button-cart")).click();

			Thread.sleep(2000);
			// Navigating to shopping page

			driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

			// Navigating to checkout page
			Thread.sleep(2000);

			driver.findElement(By.linkText("Checkout")).click();

			driver.findElement(By.id("input-payment-firstname")).sendKeys("Varunkumar");
			driver.findElement(By.id("input-payment-lastname")).sendKeys("Thoutam");
			driver.findElement(By.id("input-payment-address-1")).sendKeys("Flat No 1,Street No 2");
			driver.findElement(By.id("input-payment-city")).sendKeys("New York");
			driver.findElement(By.id("input-payment-postcode")).sendKeys("10001");

			WebElement country = driver.findElement(By.id("input-payment-country"));

			Select select = new Select(country);

			select.selectByVisibleText("United States");

			WebElement state = driver.findElement(By.id("input-payment-zone"));

			Select select2 = new Select(state);

			select2.selectByVisibleText("New York");

			driver.findElement(By.id("button-payment-address")).click();

			Thread.sleep(2000);

			driver.findElement(By.id("button-shipping-address")).click();

			Thread.sleep(2000);

			driver.findElement(By.id("button-shipping-method")).click();

			Thread.sleep(2000);

			driver.findElement(By.name("agree")).click();

			Thread.sleep(2000);

			driver.findElement(By.id("button-payment-method")).click();

			Thread.sleep(2000);

			driver.findElement(By.id("button-confirm")).click();

			Thread.sleep(2000);

			System.out.println(driver.findElement(By.xpath("//h1[text()='Your order has been placed!']")).isDisplayed());

		}

	}


