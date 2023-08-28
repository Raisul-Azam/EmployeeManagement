package com.jdbc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.employes.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

import java.sql.Statement;

public class DatabaseServices {
	
	DatabaseUtil databaseUtil = new DatabaseUtil(); 
	
	public void insertEmployee(Employee employee) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection(); 
				PreparedStatement preparedleStatement = connection.prepareStatement(QueryUtil.inserEmployeeQuery())){
			
			preparedleStatement.setString(1, employee.getEmpName());
			preparedleStatement.setString(2, employee.getEmpAdress());
			preparedleStatement.setDouble(3, employee.getEmpSalary());
			
			int row = preparedleStatement.executeUpdate();
			
			if(row > 0) {
				System.out.println("Record created successfully");
			}else {
				System.out.println("Insert Record fail...");
			}
		}
		
	} // End of insertEmployee()
	
	public void getAllEmployees() throws SQLException {
	    try (Connection connection = databaseUtil.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery())) {
	    	while(resultSet.next()) {
	    		printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
	    				              resultSet.getString("EMPLOYEE_NAME"),
	    			             	 resultSet.getString("employee_ADDRESS"),
	    				             resultSet.getDouble("EMPLOYEE_SALARY"))
	    				           );
	    	}
	    }
	} // End of getAllEmployees()
	
	private void printEmployee(Employee employee) {
		System.out.println(employee.getEmpId() + "\t" +employee.getEmpName()+ "       \t" + employee.getEmpAdress()+ " \t" + employee.getEmpSalary());
		System.out.println("-----------------------------------------------");
	} //End of printEmployees()
	
	public boolean getEmployeeById(int id) throws SQLException {
		boolean isFound = false;
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement(); 
			 	ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));
			 ){
			if(resultSet.next()) {
				System.out.println("-----------------------------------------------");
                System.out.println("Id \t Name    \t Address \t Salary ");
                System.out.println("-----------------------------------------------");
				isFound = true;
				printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
						resultSet.getString("EMPLOYEE_NAME"),
					    resultSet.getString("EMPLOYEE_ADDRESS"),
					    resultSet.getDouble("EMPLOYEE_SALARY")));
			}else {
				System.out.println("Record not found for id: "+id);
			}
		}
		return isFound;
		
	} //End of getEmployeeById()
	
	public void deleteEmployeeById(int id) throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
			 Statement statement = connection.createStatement(); ){
			int row = statement.executeUpdate(QueryUtil.deleteEmployeeById(id));
			
			if(row > 0) {
				System.out.println("Record deleted Successfully");
			}else {
				System.out.println("Something went wrong");
			}
		}
	} //End of deleteEmployeeById()
	
	public void updateEmployee(Employee employee)throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.
						prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmpId()))){
			 
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setString(2, employee.getEmpAdress());
			preparedStatement.setDouble(3, employee.getEmpSalary());
			
			int row = preparedStatement.executeUpdate();
			if(row > 0) {
				System.out.println("Record update successfully. ");
			} else {
				System.out.println("failed to update record. ");
			}
		}
	} //End of updateEmployeeById()

}
