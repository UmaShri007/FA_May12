package ai.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ai.ineuron.util.JDBCUtil;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/db")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection connection = null;
    
    public void init() throws ServletException{
    	
    	System.out.println("Config object created and and got the values from config object...\n\n");
    	
    	try {
    		System.out.println("to get the connection");
			connection = JDBCUtil.getJdbcConnection();
			System.out.println("hi");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Request type is :: "+request.getMethod());
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		System.out.println();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select `sid`,`sname`,`sage`,`saddress` from student");
			System.out.println("ID\tNAME\tAGE\tADDESS");
			out.println("<html><body>");
			out.println("<br/><br/><br/>");
			out.println("<center>");
			out.println("<h2 style='text-align:center;color:blue'>Student Details</h2>");
			out.println("<table border = '1'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>NAME</th>");
			out.println("<th>AGE</th>");
			out.println("<th>ADDRESS</th>");
			out.println("</tr>");
			
			
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name    = resultSet.getString(2);
				Integer age    = resultSet.getInt(3);
				String address = resultSet.getString(4);
				
//				System.out.println(id+"\t"+name+"\t"+age+"\t"+address);
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+age+"</td>");
				out.println("<td>"+address+"</td>");
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</body></html>");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				out.close();
				JDBCUtil.closeResources(connection, statement, resultSet);
				System.out.println("Closing the resources...");
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
