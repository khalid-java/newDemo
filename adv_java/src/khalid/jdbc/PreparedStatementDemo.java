package khalid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import oracle.jdbc.driver.OracleDriver;

public class PreparedStatementDemo {

	public static void main(String[] args) throws SQLException {
		// register the driver with the drivermanager.
			DriverManager.registerDriver(new OracleDriver());
			//Establish the connection the with database server
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","hussain");
			//create the statement by using PreparedStatement();
			PreparedStatement pst = con.prepareStatement("insert into khalid values(?,?,?)");
			//set the value with the position
			pst.setInt(1,45);
			pst.setString(2,"anish");
			pst.setDouble(3,33.3);
			pst.executeUpdate();
			System.out.println("Values Inserted");
			con.close();
		}

}
