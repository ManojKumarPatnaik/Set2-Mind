package com.mind.Exercise30;

import java.util.Scanner;

public class BankDetails {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int accountNum = 0, intrestRate = 0;
		double blc = 0, withdraw = 0;

		System.out.println("Enter Account Number");
		accountNum = intValidate();
		accountNum = checkIfPositive(accountNum);
		System.out.println("Enter Intrest Rate");
		intrestRate = intValidate();
		intrestRate = checkIfPositive(intrestRate);
		System.out.println("Enter Balance");
		blc = doubleValidate();
		blc = checkIfPositive(blc);
		Bank bankDetails = new Bank(accountNum, intrestRate, blc);

		bankDetails.display();
		System.out.println("Enter amount to withdraw");
		withdraw = doubleValidate();
		withdraw = checkIfPositive(withdraw);
		double balance = bankDetails.withDraw(withdraw);
		if (balance != -1) {
			System.out.println("Successfully Withdrawn: " + balance);
			System.out.println("Available Balance: " + (blc - withdraw));

			System.out.println("Enter the time in years to calculate the intrest rate");
			int time = intValidate();
			int intrest = bankDetails.calculateIntrest(blc, intrestRate, time);
			System.out.println("Intrest for the amount " + blc + " for " + time + " years is " + intrest);
		} else {
			System.out.println("Low Balance please enter the amount to withdraw within the balance " + blc);
		}

	}

	private static double doubleValidate() {

		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (s.hasNextDouble()) {
				data = s.nextInt();
				validation = true;
			} else if (!s.hasNextDouble()) {
				System.out.println("you didn't type an Double value ! please type an integer");
				s.next();
			}
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

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type positive value ! please type positive integer");
			integer = s.nextInt();
		}
		return integer;
	}

	private static double checkIfPositive(double integer) {
		while (integer < 0) {
			System.out.println("you didn't type positive value ! please type positive integer");
			integer = s.nextDouble();
		}
		return integer;
	}

}