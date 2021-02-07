package com.mind.Exercise31;

import java.util.Scanner;

public class FeedBack {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		CoffeeShop feedBack = new CoffeeShop();
		display(feedBack);
		CoffeeShop feedBack1 = new CoffeeShop("Praveen", "955038", 3.5);
		display(feedBack1);

		System.out.println("Enter the number of customers");
		int customers = intValidate();
		customers = checkIfPositive(customers);
		CoffeeShop details[] = new CoffeeShop[customers];
		for (int customer = 0; customer < customers; customer++) {
			details[customer] = new CoffeeShop();
			System.out.println("Enter Customer" + (customer + 1) + " name");
			String name = s.nextLine();
			name = stringValidate(name);
			System.out.println("Enter Customer" + (customer + 1) + " Mobile numbe");
			String phno = s.nextLine();
			phno = phnoValidate(phno);
			System.out.println("Give Customer" + (customer + 1) + " feedback on scale of 1-5");
			Double feedback = doubleValidate();
			feedback = checkIfPositive(feedback);

			details[customer].setName(name);
			details[customer].setMobileNo(phno);
			while (feedback > 5) {
				System.out.println("Pleas Give Customer" + (customer + 1) + "'s feedback on scale of 1-5");
				feedback = doubleValidate();
			}
			details[customer].setFeedbackRating(feedback);
		}
		for (int customer = 0; customer < customers; customer++) {

			System.out.println("Name: " + details[customer].getName());
			System.out.println("MobileNo: " + details[customer].getMobileNo());
			System.out.println("Rating: " + details[customer].getFeedbackRating() + " out of  5");
			System.out.println();
		}
		/* s.close(); */
	}

	public static void display(CoffeeShop feedBack) {
		System.out.println("Name: " + feedBack.getName());
		System.out.println("MobileNo: " + feedBack.getMobileNo());
		System.out.println("Rating: " + feedBack.getFeedbackRating() + " out of  5");
		System.out.println();
	}

	private static double doubleValidate() {

		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (s.hasNextDouble()) {
				data = s.nextDouble();
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

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the name");
			}
			data = s.nextLine();
		}
		return data;
	}

	private static String phnoValidate(String data) {

		while (!data.matches("[0-9 ]+")) {
			System.out.println("Please retype the Phone Number");
			data = s.next();
		}
		return data;
	}

	private static double checkIfPositive(double integer) {
		while (integer < 0) {
			System.out.println("you didn't type positive value ! please type positive integer");
			integer = s.nextDouble();
		}
		return integer;
	}

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type positive value ! please type positive integer");
			integer = s.nextInt();
		}
		return integer;
	}

}
