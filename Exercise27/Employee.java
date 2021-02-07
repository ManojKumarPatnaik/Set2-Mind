package com.mind.Exercise27;

import java.util.Scanner;

public class Employee {
	private int empId;
	private String empName;
	private String empDesig;
	private String empDept;
	static Scanner sc = new Scanner(System.in);

	public Employee(int empId2, String empName2, String empDesig2, String empDept2) {
		this.empId = empId2;
		this.empName = empName2;
		this.empDesig = empDesig2;
		this.empDept = empDept2;
	}

	public Employee() {

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		if (empName == null) {
			return null;
		}
		return empName;
	}

	public void setEmpName(String empName) {

		this.empName = empName;
	}

	public String getEmpDesig() {
		return empDesig;
	}

	public void setEmpDesig(String empDesig) {
		boolean value = false;
		while (value == false) {
			if (empDesig.equalsIgnoreCase("developer") || empDesig.equalsIgnoreCase("tester")
					|| empDesig.equalsIgnoreCase("lead") || empDesig.equalsIgnoreCase("manager")) {
				this.empDesig = empDesig;
				value = true;
			} else {
				System.out.println("Invalid Employee Designation \nEnter a Valid Designation : ");
				empDesig = sc.next();
			}
		}

	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		boolean value = false;
		while (value == false) {
			if (empDept.equalsIgnoreCase("TTH") || empDept.equalsIgnoreCase("RCM")
					|| empDept.equalsIgnoreCase("Digital") || empDept.equalsIgnoreCase("DevOps")) {
				this.empDept = empDept;
				value = true;
			} else {
				System.out.println("Invalid Employee Department \nEnter a Valid Department : ");
				empDept = sc.next();
			}

		}

	}

}