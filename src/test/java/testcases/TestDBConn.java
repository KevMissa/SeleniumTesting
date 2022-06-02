package testcases;

import java.sql.SQLException;

public class TestDBConn {

	public static void main(String[] args) throws SQLException {
		DbManager.setMySqlDbConnection(); 
	}

}
