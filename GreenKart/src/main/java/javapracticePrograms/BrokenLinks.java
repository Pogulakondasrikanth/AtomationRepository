package javapracticePrograms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenLinks {
	public static void main(String[] args) throws MalformedURLException, IOException {
		
	String url="ljadfj";
	@SuppressWarnings("deprecation")
	HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
	conn.setRequestMethod("HEAD");
	conn.connect();
	int responseCode=conn.getResponseCode();
	System.out.println(responseCode);

}}
