package com.mind.Exercise27;

import java.util.Scanner;

public class EmployeeDetails {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int empId = 0;
		String empName = "";
		// taking input from the user and validating the input
		Employee details1 = new Employee();
		System.out.println("Enter Empid");
		empId = intValidate();
		empId = checkIfPositive(empId);
		details1.setEmpId(empId);
		System.out.println("Enter EmpName");
		empName = s.nextLine();
		empName = stringValidate(empName);
		details1.setEmpName(empName);
		System.out.println("Enter EmpDesig");
		String empDesig = s.nextLine();
		empDesig = stringValidate(empDesig);
		empDesig=desigValidate(empDesig);
		details1.setEmpDesig(empDesig);
		System.out.println("Enter EmpDept");
		String empDept = s.nextLine();
		empDept = stringValidate(empDept);
		empDept=deptValidate(empDept);
		details1.setEmpDept(empDept);

		System.out.println();
		System.out.println("EmpId: " + details1.getEmpId());
		System.out.println("EmpName: " + details1.getEmpName());
		System.out.println("EmpDesig: " + details1.getEmpDesig());
		System.out.println("EmpDept: " + details1.getEmpDept());
		// details.display();
	}

	private static String deptValidate(String empDept) {
		
      boolean temp=true;
		
		while(temp)
		{
			if(empDept.equals("TTH")||empDept.equals("RCM")|| empDept.equals("Digital")||empDept.equals("DevOps"))
			{
				temp=false;
			}
			else
			{
				System.out.println("Enter valid dept ::");
				empDept=s.nextLine();
			}
		}
		return empDept;
		
	}

	private static String desigValidate(String empDesig) {
		boolean temp=true;
		
		while(temp)
		{
			if(empDesig.equals("Doveloper")||empDesig.equals("Tester")|| empDesig.equals("Lead")||empDesig.equals("Manager"))
			{
				temp=false;
			}
			else
			{
				System.out.println("Enter valid disg ::");
				
				empDesig=s.nextLine();
			}
		}
		return empDesig;
	}

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = s.nextInt();
		}
		return integer;
	}

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the input");
			}
			data = s.nextLine();
		}
		return data;
	}

	private static int intValidate() {

		int data = 0;
		boolean validation = false;
		while (validation == false) {
			if (s.hasNextInt()) {
				data = s.nextInt();
				validation = true;
			} else if (!s.hasNextInt()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				s.next();
			}
		}
		return data;
	}
}