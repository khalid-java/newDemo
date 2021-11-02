package khalid.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Registering {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fis=new FileInputStream("/adv_java/main/resources/Application.properties");
		Properties pr=new Properties();
		pr.load(fis);
		String driver=pr.getProperty("driver");
		String url=pr.getProperty("url");
		String user=pr.getProperty("username");
		String pass=pr.getProperty("password");
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pass);
		Statement st=con.createStatement();
		st.executeUpdate("insert into test5 values(122,'ddd','gaya')");
		con.close();
		System.out.println("record............");

	}
}
