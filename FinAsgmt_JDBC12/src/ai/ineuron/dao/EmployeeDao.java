package ai.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ai.ineuron.dto.EmployeeFA;
import ai.ineuron.util.JDBCUtil;

public class EmployeeDao {
	
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet resultSet = null;
	
	
	public static boolean insertEmployee(EmployeeFA employee) {
		
		String insertQuery = "Insert into EmployeeFA(`name`,`mobile`,`city`) values(?,?,?)";
		boolean insFlag = false;
		try {
		connection = JDBCUtil.getJdbcConnection();
		if(connection!=null) {
			pstmt = connection.prepareStatement(insertQuery);
		}
		//set the values from user i/p
		if(pstmt!=null) {
			pstmt.setString(1, employee.geteName());
			pstmt.setString(2, employee.geteMobile());
			pstmt.setString(3, employee.geteCity());
		}
		
		pstmt.executeUpdate();
		
		insFlag= true;
		
		}catch(SQLException |IOException  e) {
			e.printStackTrace();
		}
		return insFlag;
		
	}

	public static boolean deleteEmployee(int eId) {

		String delQuery = "Delete from EmployeeFA where id=?";
		boolean delFlag = false;
		try {
			connection = JDBCUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt=connection.prepareStatement(delQuery);
			}
			if(pstmt!=null) {
				//set the employee id
				pstmt.setInt(1, eId);
			}
			pstmt.executeUpdate();
			delFlag=true;
		}catch(SQLException |IOException  e) {
			e.printStackTrace();
		}
		return delFlag;
	}

	public static void showAllEmpDetails() {

		String selQuery = "Select * from EmployeeFA" ;
		
		try {
			connection = JDBCUtil.getJdbcConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(selQuery);
			}

			if(pstmt!=null) {
				resultSet = pstmt.executeQuery();
			}
			
			System.out.println("Employee ID:  Employee Name:  Employee Mobile Employee city: ");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4));
			}
			System.out.println("----------------------------------------------");
		}catch(SQLException |IOException  e) {
			e.printStackTrace();
		}
		
	}

	public static EmployeeFA getEmpDetail(int eid) {
		String selQuery = "Select * from EmployeeFA where id = ?";
		EmployeeFA employee = null;
		try {
			connection=JDBCUtil.getJdbcConnection();
			
			if(connection!=null) 
				pstmt = connection.prepareStatement(selQuery);
			
			if(pstmt!=null) 
				pstmt.setInt(1, eid);
			
			if(pstmt!=null) {
				resultSet = pstmt.executeQuery()	;
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					employee = new EmployeeFA();
					
					employee.seteId(resultSet.getInt(1));
					employee.seteName(resultSet.getString(2));
					employee.seteMobile(resultSet.getString(3));
					employee.seteCity(resultSet.getString(4));
				}
			}
		}catch(SQLException | IOException  e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	public static boolean updateStudentRecord(int opt, String colToUpdate, int id, EmployeeFA newEmp) {
		
		boolean updFlag = false;
		
		try {
			connection = JDBCUtil.getJdbcConnection();
			if(opt==1) { //updatee name
			String updQuery1 = "Update EmployeeFA set name = ? where id = ?";
			
			if(connection!=null) {
				pstmt = connection.prepareStatement(updQuery1);
			}
			if(pstmt!=null) {
				pstmt.setString(1,colToUpdate);
				pstmt.setInt(2,id);
				
				pstmt.executeUpdate();
				updFlag=true;
			}
			}
			else if(opt==2) { //updatee mobile number
				String updQuery2 = "Update EmployeeFA set mobile = ? where id = ?";
				
				if(connection!=null) {
					pstmt = connection.prepareStatement(updQuery2);
				}
				if(pstmt!=null) {
					pstmt.setString(1,colToUpdate);
					pstmt.setInt(2,id);
					
					pstmt.executeUpdate();
					updFlag=true;
				}
			}
			else if(opt==3) { //updatee city
				String updQuery3 = "Update EmployeeFA set city = ? where id = ?";
				
				if(connection!=null) {
					pstmt = connection.prepareStatement(updQuery3);
				}
				if(pstmt!=null) {
					pstmt.setString(1,colToUpdate);
					pstmt.setInt(2,id);
					
					pstmt.executeUpdate();
					updFlag=true;
				}
			}else
				System.out.println("Wrong option selected for updation");
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return updFlag;
	}
}
