package com.mind.Exercise29;

import java.util.Scanner;

public class BankDetails {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("1.Create customer with(Id,Name,Address,Account Type,Balance)");
		System.out.println("2.Create customer with(Id,Name,Address)");
		System.out.println("3.Create customer with(Id,Name)");
		System.out.println("4.Exit ");
		int custId;
		String custName;
		String custAddress;
		String accType;
		Double custBalance;
		boolean exit=false;
		
		do {
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter Customer Id : ");
			custId =intValidate();
            
			System.out.println("Enter Customer Name : ");
			custName = stringValidate();

			System.out.println("Enter Customer Address : ");
			custAddress = stringValidate();

			System.out.println("Enter Customer Account Type : ");
			accType = stringValidate();

			System.out.println("Enter Customer Balance : ");
			custBalance = doubleValidate();
			Bank details = new Bank(custId, custName, custAddress, accType, custBalance);
			System.out.println("CustId: " + details.getCustId() + "\nCustName: " + details.getCustName()
					+ "\nCustAddress: " + details.getCustAddress() + "\nAccType: " + details.getAccType()
					+ "\nAccBalance: " + details.getCustBalance());
			System.out.println();
		}
			break;
		case 2: {
			System.out.println("Enter Customer Id : ");
			custId = sc.nextInt();

			System.out.println("Enter Customer Name : ");
			custName = sc.next();

			System.out.println("Enter Customer Address : ");
			custAddress = sc.next();

			Bank details = new Bank(custId, custName, custAddress);
			System.out.println("CustId: " + details.getCustId() + "\nCustName: " + details.getCustName()
			+ "\nCustAddress: " + details.getCustAddress() + "\nAccType: " + details.getAccType()
			+ "\nAccBalance: " + details.getCustBalance());
	System.out.println();
		}
			break;
		case 3: {
			System.out.println("Enter Customer Id : ");
			custId = sc.nextInt();

			System.out.println("Enter Customer Name : ");
			custName = sc.next();
			Bank details = new Bank(custId, custName);
			System.out.println("CustId: " + details.getCustId() + "\nCustName: " + details.getCustName()
			+ "\nCustAddress: " + details.getCustAddress() + "\nAccType: " + details.getAccType()
			+ "\nAccBalance: " + details.getCustBalance());
	System.out.println();
		}
			break;
		case 4:
		{
			System.out.println("Thank You");
			exit=true;
		}
		break;
		default :
		{
			System.out.println("Invalid Input");
		}
		}
		}while(exit!=true);

	}

	private static String stringValidate() {
		String data ="";
		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the input");
			}
			data = sc.nextLine();
		}
		return data;
	}

	private static int intValidate() {
		int data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextInt()) {
				data = sc.nextInt();
				validation = true;
			} else if (!sc.hasNextInt()) {
				System.out.println("you didn't type an integer value ! please type an integer");
				sc.next();
			}
		}
		return data;
	}

	private static Double doubleValidate() {
		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextDouble()) {
				data = sc.nextInt();
				validation = true;
			} else if (!sc.hasNextDouble()) {
				System.out.println("you didn't type an double value ! please type an double");
				sc.next();
			}
		}
		return data;
	}

}