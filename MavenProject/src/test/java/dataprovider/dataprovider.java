package dataprovider;

import java.io.FileReader;

import org.testng.annotations.DataProvider;

import com.google.gson.JsonParser;


public class dataprovider {
	
	@DataProvider(name="userlogindetails")
	public String[] data() {
		JsonParser jsonparser=new  ;
		FileReader filereader=new FileReader("C:\\Users\\spogulak\\git\\Automation\\MavenProject\\Testdata\\LoginCredentialsTestData.json");
		Object obj=
		
	}

}
