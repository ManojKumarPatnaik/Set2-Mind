package com.mind.Exercise46;

import java.text.ParseException;
import java.util.Scanner;

public class Ticket {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

		String customerName, phoneNumber, dateOfBirth, address;
		int customerAge, customerId;

		TicketBookingApp details[] = {};
		boolean exit = false;
		do {
			TicketBookingApp obj1 = new TicketBookingApp();
			int ch;
			System.out.println(
					"enter your choice \n 1. Add Customer Details \n 2. Book a Ticket \n 3. Display Customers \n 4. exit ");
			ch = intValidate();
			switch (ch) {
			case 1: {
				System.out.println("Enter number of customers");
				int customers = intValidate();
				customers = checkIfPositive(customers);

				for (int i = 0; i < customers; i++) {
					System.out.println("enter id of the customer ");
					customerId = intValidate();
					customerId = checkIfPositive(customerId);
					System.out.println("enter name of the customer ");
					customerName = sc.nextLine();
					customerName = stringValidate(customerName);
					System.out.println("enter age of the customer ");
					customerAge = intValidate();
					customerAge = ageValidate(customerAge);
					System.out.println("enter Mobile Number of the customer ");
					phoneNumber = sc.next();
					phoneNumber = phnoValidate(phoneNumber);
					System.out.println("enter Date of Birth of the customer ");
					dateOfBirth = sc.next();
					dateOfBirth = dobValidate(dateOfBirth);
					System.out.println("enter Address  of the customer ");
					address = sc.nextLine();
					address = stringValidate(address);
					details = addDetails(customerId, customerName, customerAge, phoneNumber, dateOfBirth, address, details);
				}

				break;
			}
			case 2: {
				if (details.length > 0) {
					System.out.println("Enter the CustomerId");
					int id1 = intValidate();
					System.out.println("Enter the Mobile Number");
					String phn = sc.next();
					phn = phnoValidate(phn);
					String receipt = obj1.bookTicket(details, id1, phn);
					System.out.println(receipt);
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 3: {
				if(details.length>0) {
				boolean exit1 = false;
				do {
					System.out.println(
							"1.Display customer based on city \n2.Display customer based on ID \n3.Display customer Names in sorted order \n4.Exit");
					int choice2;
					System.out.println("Choose an option");
					choice2 = intValidate();
					switch (choice2) {
					case 1: {
						System.out.println("Enter the Customer City");
						String city = sc.next();
						city = stringValidate(city);
						int index = obj1.basedCity(details, city);
						if (index != -1) {

							System.out.println("Customer Name: " + details[index].getName());
							System.out.println("Customer Mobile Number: " + details[index].getMobileNumber());
							System.out.println("Customer Age: " + details[index].getAge());
							System.out.println("Customer DOB: " + details[index].getDob());
							System.out.println("Customer Address: " + details[index].getAddress());

						} else {
							System.out.println("Customer not found");
						}
					}
						break;
					case 2: {
						System.out.println("Enter the Customer ID");
						int id2 = intValidate();
						int index = obj1.basedId(details, id2);
						if (index != -1) {

							System.out.println("Customer Name: " + details[index].getName());
							System.out.println("Customer Mobile Number: " + details[index].getMobileNumber());
							System.out.println("Customer Age: " + details[index].getAge());
							System.out.println("Customer DOB: " + details[index].getDob());
							System.out.println("Customer Address: " + details[index].getAddress());

						} else {
							System.out.println("Customer not found");
						}
					}
						break;
					case 3: {
						TicketBookingApp[] namesSorted = obj1.names(details);
						for (int index = 0; index < namesSorted.length; index++) {
							System.out.println(namesSorted[index].getName());
						}

					}
						break;
					case 4: {
						System.out.println("Thank you!");
						exit1 = true;
					}
						break;
					default: {
						System.out.println("Invalid input!");
					}
					break;
					}
					
				} while (exit1 != true);

			}else
			{
				System.out.println("No Record Found");
			}
			}
			break;
			case 4: {
				System.out.println("Thank you!");
				exit = true;
			}
				break;
			default: {
				System.out.println("invalid input");
			}

			}
		} while (exit != true);
	}

	private static int ageValidate(int age) {
		while(age>90)
		{
		
		
			System.out.println("You are not Human ! Please enter valid age :");
			age=sc.nextInt();
		}
		
		return age;
	}

	private static TicketBookingApp[] addDetails(int id, String name, int age, String phno, String dob, String address,
			TicketBookingApp[] details) {
		TicketBookingApp res[] = new TicketBookingApp[details.length + 1];
		for (int ticket = 0; ticket < details.length; ticket++) {
			res[ticket] = details[ticket];
		}
		res[details.length] = new TicketBookingApp(id, name, age, phno, dob, address);
		return res;
	}

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the alphabetical string");
			}
			data = sc.nextLine();
		}
		return data;
	}

	private static String phnoValidate(String data) {
        boolean valid=false;
		while (!data.matches("[0-9]+")) {
			System.out.println("Please retype the phone Number");
			data = sc.next();
		}
	
		while(valid==false)
		{
			if(!(data.length()==10))
			{
				System.out.println("Please enter 10 digits !");
				data=sc.next();
			}
			else if(data.length()==10)
			{
				valid=true;
			}
		}
		return data;
	}

	private static String dobValidate(String data) {

		while (!data.matches("((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
			System.out.println("Please retype the Date ");
			data = sc.next();
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

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = sc.nextInt();
		}
		return integer;
	}

}
