package ai.ineuron.main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestPostgresql {

	public static void main(String[] args) {
		try {
			// Load the PostgreSQL JDBC driver
			Class.forName("org.postgresql.Driver");

			// Create a connection to the database
			String url = "jdbc:postgresql://localhost:5432/mydb";
			String username = "postgres";
			String password = "root@2022";
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection  establishd....");
			// Create a statement
			Statement statement = connection.createStatement();
			System.out.println("statementt obj created....");
			// Execute a query
			String sql = "SELECT * FROM mytable";
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println(resultSet);
			// Process the result set
			while (resultSet.next()) {
				// Retrieve data from the result set
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				System.out.println(id+" "+name);
			}

			// Close the resources
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
