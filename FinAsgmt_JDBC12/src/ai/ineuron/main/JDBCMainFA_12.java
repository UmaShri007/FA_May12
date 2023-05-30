package ai.ineuron.main;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import ai.ineuron.dao.EmployeeDao;
import ai.ineuron.dto.EmployeeFA;

public class JDBCMainFA_12 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome User!!");
		while (true) {
			System.out.println("Press 1 to Add an Employee Detail");
			System.out.println("Press 2 to Delete an Employee Detail");
			System.out.println("Press 3 to Display all Employee Detail");
			System.out.println("Press 4 to Update an Employee Detail");
			System.out.println("Press 5 to Exit");

			int option = Integer.parseInt(br.readLine());

			if (option == 1) { // Add employee detail

				System.out.println("Enter the employee name");
				String eName = br.readLine();
				System.out.println("Enter the employee mobile number");
				String eMobile = br.readLine();
				System.out.println("Enter the employee city");
				String eCity = br.readLine();

				// create employee object

				EmployeeFA employee = new EmployeeFA(eName, eMobile, eCity);
				boolean insFlag = EmployeeDao.insertEmployee(employee);

				if (insFlag) {
					System.out.println("Employee Record inserted successfully");
					System.out.println("Employee Record:" + employee);
				} else {
					System.out.println("Some error Occured while inserting...Please try Again!");
				}
			}

			else if (option == 2) {// delete an employee detail

				System.out.println("Enter the employee id to delete");
				int eId = Integer.parseInt(br.readLine());
				boolean delFlag = EmployeeDao.deleteEmployee(eId);

				if (delFlag) {
					System.out.println("Employee Record deleted successfully");

				} else {
					System.out.println("Some error occured while deleting...Please try Again!");
				}
			} else if (option == 3) {// show all the employees

				EmployeeDao.showAllEmpDetails();

			} else if (option == 4) {// update the employee details
				System.out.println("Press 1 to update Employee Name");
				System.out.println("Press 2 to update Employee Mobile number");
				System.out.println("Press 3 to update Employee City");
				
				int opt = Integer.parseInt(br.readLine());
				
				if(opt==1) {//update name
					
					System.out.println("Enter the employee id::");
					int id = Integer.parseInt(br.readLine())	;
					EmployeeFA emp  = EmployeeDao.getEmpDetail(id); 
					System.out.println(emp);
					EmployeeFA newEmp = new EmployeeFA();
					System.out.println("Employee old name is :: " + emp.geteName() +" Enter name to UPDATE...");
					String newName = br.readLine();
					if(newName.equals("")||newName == "") {
						newEmp.seteName(emp.geteName());
					}else {
						newEmp.seteName(newName);
					}
					boolean updFlag =EmployeeDao.updateStudentRecord(opt,newName,id,newEmp);
					if(updFlag) {
						System.out.println("Student Name Updated Successfully...");
					}else {
						System.out.println("Something went wrong Please try Again!");
					}
				}
				else if(opt==2) {//update mobile number
					
					System.out.println("Enter the employee id::");
					int id = Integer.parseInt(br.readLine())	;
					EmployeeFA emp  = EmployeeDao.getEmpDetail(id); 
					
					EmployeeFA newEmp = new EmployeeFA();
					System.out.println("Employee old mobile number is :: " + emp.geteMobile() +"Enter new mobile no: to UPDATE...");
					String newMobile = br.readLine();
					if(newMobile.equals("")||newMobile == "") {
						newEmp.seteName(emp.geteName());
					}else {
						newEmp.seteName(newMobile);
					}
					boolean updFlag =EmployeeDao.updateStudentRecord(opt,newMobile,id,newEmp);
					if(updFlag) {
						System.out.println("Employee Mobile number Updated Successfully...");
					}else {
						System.out.println("Something went wrong Please try Again!");
					}
				}
				else if(opt==3) {//update city
					
					System.out.println("Enter the employee id::");
					int id = Integer.parseInt(br.readLine())	;
					EmployeeFA emp  = EmployeeDao.getEmpDetail(id); 
					
					EmployeeFA newEmp = new EmployeeFA();
					System.out.println("Employee city is :: " + emp.geteCity() +"Enter new city name to UPDATE...");
					String newCity = br.readLine();
					if(newCity.equals("")||newCity == "") {
						newEmp.seteName(emp.geteName());
					}else {
						newEmp.seteName(newCity);
					}
					boolean updFlag =EmployeeDao.updateStudentRecord(opt,newCity,id,newEmp);
					if(updFlag) {
						System.out.println("Employee's city Updated Successfully...");
					}else {
						System.out.println("Something went wrong Please try Again!");
					}
				}
				else {
					System.out.println("You have not updated Anything... Please choose option Correctly!");
				}
			} else if (option == 5) {// Exit
				System.out.println("Thank you for using the Application!!");
				System.exit(0);
			} else {
				System.out.println("Invalid options entered");
				break;

			}
		}
	}
}
