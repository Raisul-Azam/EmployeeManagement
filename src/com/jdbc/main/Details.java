package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.employes.Employee;
import com.jdbc.services.DatabaseServices;

public class Details {
	
	static void details(boolean flag, boolean isRunning) {
		try(Scanner scanner=new Scanner(System.in);) {
		
		DatabaseServices databaseServices=new DatabaseServices();
		
		while (isRunning) {
			
			if(flag) {
				System.out.println("****************************************************************************************************");
                System.out.println(" 1. INSERT \t2. SELECT_ALL \t3. SELECT BY ID \t4. DELETE \t5. UPDATE \t6.EXISTS ");
                System.out.println("****************************************************************************************************");
			}
			flag = true;
	        System.out.print("Enter Choice: ");
			
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch (choice) {
			case 1:
				System.out.println("-----------------------------------------------");
                System.out.println("Name    \t Address \t Salary ");
                System.out.println("-----------------------------------------------");
				databaseServices.insertEmployee(new Employee(scanner.nextLine(),scanner.nextLine(), Double.parseDouble(scanner.nextLine())));
				break;
				
			case 2:
				System.out.println("-----------------------------------------------");
                System.out.println("Id \t Name    \t Address \t Salary ");
                System.out.println("-----------------------------------------------");
				databaseServices.getAllEmployees();
				break;
				
			case 3:
				System.out.print("Enter Id of an employee:- ");
				databaseServices.getEmployeeById(Integer.parseInt(scanner.nextLine()));
				break;
				
			case 4:
				System.out.println("Enter Id of an employee:- ");
				databaseServices.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
				break;
				
			case 5:
				System.out.print("Enter Id of an employee:- ");
				int updateId = Integer.parseInt(scanner.nextLine());
				Boolean isFound = databaseServices.getEmployeeById(updateId);
				if(isFound) {
					System.out.println("-----------------------------------------------");
                    System.out.println(" Name    \t Address \t Salary ");
                    System.out.println("-----------------------------------------------");
					Employee employee = new Employee(updateId, scanner.nextLine(), scanner.nextLine(), Double.parseDouble(scanner.nextLine()));
					databaseServices.updateEmployee(employee);
				}
				break;
			case 6:
				System.out.println("-----------------------------------------------");
				System.out.println("  \t Thank you, Visit again.");
				System.out.println("-----------------------------------------------");
				isRunning = false;
				break;
			default:
				System.out.println("Increct choice");
				break;
			}
			
		}
		
	}
	catch (Exception e) {
		throw new RuntimeException("Something went wrong "+e.getMessage());
	}
	
 }
}
