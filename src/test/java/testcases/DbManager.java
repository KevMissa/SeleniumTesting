package testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

	 private static Connection conn = null; //mysql
	 
	 public static void setMySqlDbConnection() throws SQLException{
		 try {
			 Class.forName(TestConfig.mysqldriver);
			 conn = DriverManager.getConnection (TestConfig.mysqlurl, TestConfig.mysqlusername, TestConfig.mysqlpassword);
			 if(!conn.isClosed())
				 System.out.println("Succesfully connected to Mysql");
		 }
		 catch (Exception e)
		 {
			 System.err.println("Cannot connect to database server");
		 }
	 }
}
