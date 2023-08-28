package com.jdbc.main;

public class MainClass {
	
	public static void main(String[] args) {
			
			 System.out.println("--------------------------------");
			 System.out.println("           MAIN MENU");
	         System.out.println("--------------------------------");
	         System.out.println("  1. Insert ");
	         System.out.println("  2. Select_All ");
	         System.out.println("  3. Select Employee by an Id");
	         System.out.println("  4. Delete Employee ");
	         System.out.println("  5. Update Employee");
	         System.out.println("  6. Exists ");
	         System.out.println("--------------------------------");
	         
	        boolean flag = false;
			
			boolean isRunning = true;
			
		    Details.details(flag,isRunning);
		
	}
	
}
