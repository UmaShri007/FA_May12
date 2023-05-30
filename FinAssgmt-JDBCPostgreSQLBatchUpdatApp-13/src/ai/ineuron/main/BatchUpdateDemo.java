package ai.ineuron.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateDemo {

	public static void main(String[] args) {
		  String jdbcUrl = "jdbc:postgresql://localhost:5432/mydb";
	        String username = "postgres";
	        String password = "root@2022";
//	        String inputFile = "jdbc:Text:///D:\\images\\players.csv"; 
	        String inputFile = "D:\\images\\players.csv"; 

	        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	             BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

	            String line;
	            String insertQuery = "INSERT INTO PLAYERS (id, name, address) VALUES (?, ?, ?)";
	            PreparedStatement pstmt = connection.prepareStatement(insertQuery);

	            int batchSize = 100; 
	            int count = 0;

	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(","); // comma-separated values

	                // Set the values for each parameter
	                pstmt.setString(1, data[0]);
	                pstmt.setString(2, data[1]);
	                pstmt.setString(3, data[2]);

	                pstmt.addBatch();
	                
	                count++;
	                if (count % batchSize == 0) {
	                	pstmt.executeBatch();
	                }
	            }

	            pstmt.executeBatch(); // Execute any remaining statements

	            System.out.println("Batch update completed successfully.");

	        } catch (SQLException e) {
	            System.out.println("Error connecting to the database: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error reading input file: " + e.getMessage());
	        }
	    }
	}

	


