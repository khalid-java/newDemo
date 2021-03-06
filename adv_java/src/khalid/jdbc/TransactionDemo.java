package khalid.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//class name
public class TransactionDemo {
	// main method
	public static void main(String... ar) throws Exception {
		// enter the account for the keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the account no: ");
		int faccno = Integer.parseInt(br.readLine());
		System.out.println("Enter the account no to transfer amount");
		int taccno = Integer.parseInt(br.readLine());
		System.out.println("enter the amount");
		int amt = Integer.parseInt(br.readLine());

		// registring the driver manager
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// Establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hussain");
		// create the statement
		Statement st = con.createStatement();
		// execute the query
		ResultSet rs = st.executeQuery("select * from sbibank");
		// balance inquery variable
		int bal1 = 0, bal2 = 0;

		while(rs.next()) {
			if(rs.getInt(1)==faccno) {
				bal1 = rs.getInt(2);
			}
			else {
				System.out.println("invalid faccno");
			}
				
			if(rs.getInt(1)==taccno) {
				bal2 = rs.getInt(2);
			}
			else {
				System.out.println("invalid taccno no");
			}
				
		}
		con.setAutoCommit(false);
		System.out.println(faccno+" "+bal1);
		System.out.println(taccno+" "+bal2);
		st.executeUpdate("update sbibank set bal="+(bal1-amt)+"where accno="+faccno);
		st.executeUpdate("update sbibank set bal="+(bal2+amt)+"where accno="+taccno);
		con.commit();
		System.out.println("amount is transfered..");
		// close the conncetion
		con.close();

	}

}
