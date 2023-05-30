package ai.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	private JDBCUtil() {}
	
	public static Connection getJdbcConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("src\\ai\\ineuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		// Establish the connection
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
								properties.getProperty("userName"),
								properties.getProperty("password"));
		System.out.println("Connection Object created...");
		return connection;
		
	}
	//close all the resourcces
	
public static void closeResources(Connection con,Statement stmt,ResultSet rs) throws SQLException	{
		
		if(con != null) {
			con.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(rs != null) {
			rs.close();
		}
		
	}
}



