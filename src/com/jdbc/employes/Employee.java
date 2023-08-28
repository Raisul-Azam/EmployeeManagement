package com.jdbc.employes;

public class Employee {
	
	private int empId;
	private String empName;
	private String empAdress;
	private double empSalary;
	
	public Employee(String empName, String empAdress, double empSalary) {
		super();
		this.empName = empName;
		this.empAdress = empAdress;
		this.empSalary = empSalary;
	}
	
	
	
	public Employee(int empId, String empName, String empAdress, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAdress = empAdress;
		this.empSalary = empSalary;
	}



	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAdress() {
		return empAdress;
	}
	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	@Override
	public String toString() {
		return "Emplyee [empId=" + empId + ", empName=" + empName + ", empAdress=" + empAdress + ", empSalary=" + empSalary + "]";
	}
	
	
	
}
