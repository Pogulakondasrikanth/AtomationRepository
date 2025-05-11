package dryRun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/qadatabase";
		String username="root";
		String password="Sri@188#";
		//To load JDBC driver
		Class.forName("com.mysql.cj.jdbc.driver");
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement st=conn.createStatement();
		ResultSet set=st.executeQuery("select * from CustomerCredentials where customerName='Mahesh'");
		while(set.next()) {
			System.out.println(set.getString("username"));
			System.out.println(set.getString("password"));
			System.out.println(set.getString("id"));
		}
	}

}
