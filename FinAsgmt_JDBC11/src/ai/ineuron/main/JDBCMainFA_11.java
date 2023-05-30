package ai.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import ai.ineuron.util.JDBCUtil;

public class JDBCMainFA_11 {

	public static void main(String[] args) throws Exception {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = JDBCUtil.getJdbcConnection();
			System.out.println("connection established..");
			String selectQuery = "Select sid,sname,scapital,sCM from IndianStates";

			if (connection != null) {
				statement = connection.createStatement();
				System.out.println("statement object created....");
			}
			
			if (statement != null) {
				resultSet = statement.executeQuery(selectQuery);
				System.out.println("reultSet object created....");
			}

			// process the result set

			if (resultSet != null) {
				System.out.println("ID\tSTATE\tCAPITAL\t\tCM");
				System.out.println("==================================");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
							+ resultSet.getString(3) + "\t" + resultSet.getString(4));
				} 
				}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JDBCUtil.closeResources(connection, statement, resultSet);
				System.out.println("Closing the resources...");
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
