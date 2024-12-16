package browsercall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsercall {
	WebDriver driver;
//	public browsercall(WebDriver driver) {
//		this.driver=driver;
//	}
	public WebDriver browserinstance(String name) {
	switch (name) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
	default:
		System.out.println("You have entered incorrect browser name, please enter valid browser name");
		break;
	}	
	return driver;	
	}

}
