package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Utility {
	
	public static String get_screenshot(String name, WebDriver driver) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir")+ "/reports/Screenshots/" + name +"_"+timestamp+".jpg";
		File fis = new File(path);
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src =ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, fis);
				return "Screenshots/" +name+"_"+timestamp+".jpg"; 
	}
	
	

}
