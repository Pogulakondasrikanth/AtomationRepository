package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public Properties prop;
    
    @BeforeMethod(dependsOnMethods = "setup")
    public WebDriver getDriver() {
    	return driver.get();
    	
    } 

    @BeforeMethod
    public void setup() throws IOException {
        // Load properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

        // Launch browser
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver.set(new ChromeDriver(options));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get().manage().window().maximize();
        driver.get().get(prop.getProperty("url")); // URL from config.properties
    }
    @SuppressWarnings("deprecation")
	public Object[][] read_data_from_excel() throws IOException {
        FileInputStream file = new FileInputStream("src/test/resources/LoginTestData.xlsx"); 
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();       
        int colCount = sheet.getRow(0).getLastCellNum();      

        Object[][] data = new Object[rowCount - 1][colCount]; 

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    cell.setCellType(CellType.STRING);
                    data[i - 1][j] = cell.getStringCellValue();
                } else {
                    data[i - 1][j] = ""; // fallback to empty string if cell is missing
                }
            }
        }

        workbook.close();
        file.close();

        return data;
    }

    	
    
    
    @AfterMethod
    public void teardown() {
    	driver.get().quit();
    	driver.remove();
    }
}
