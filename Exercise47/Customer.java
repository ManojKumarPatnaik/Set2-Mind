package com.mind.Exercise47;

import java.util.Scanner;

public class Customer {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		AccountInfo details[] = {};
		boolean exit = false;
		do {
			AccountInfo obj1 = new AccountInfo();
			int choice = getChoice();
			switch (choice) {
			case 1: {
				String acountNumber, customerName, acountType, dateOfBirth, address;
				double balance;

				System.out.println("enter Account Number of the customer ");
				acountNumber = sc.next();
				acountNumber = acnoValidate(acountNumber);

				System.out.println("enter name of the customer ");
				customerName = sc.nextLine();
				customerName = stringValidate(customerName);
				System.out.println("enter Account Type of the customer ");
				acountType = sc.nextLine();
				acountType = stringValidate(acountType);
				while (!(acountType.compareToIgnoreCase("Saving") == 0 || acountType.compareToIgnoreCase("Loan") == 0
						|| acountType.compareToIgnoreCase("Current") == 0)) {
					System.out.println("Enter a valid accountType \nSaving \nLoan \nCurrent");
					acountType = sc.next();
				}
				System.out.println("enter Date of Birth of the customer(YYYY-MM-DD) ");
				dateOfBirth = sc.next();
				dateOfBirth = dobValidate(dateOfBirth);
				System.out.println("enter Balance of the customer ");
				balance = doubleValidate();
				System.out.println("enter address of the customer ");
				address = sc.nextLine();
				address = stringValidate(address);
				boolean isPresent = true;
				boolean nameFound = false;
				boolean idFound = false;
				boolean nonZero = false;
				details = addDetails(acountNumber, customerName, acountType, dateOfBirth, balance, address, isPresent,
						nameFound, nonZero, idFound, details);

				break;
			}
			case 2: {
				for (int i = 0; i < details.length; i++) {
					if (details[i].isPresent() == true) {
						System.out.println(details[i].getAccountNumber());
					}
				}
				String accountNumber;

				System.out.println("Enter the account number to update");
				accountNumber = sc.next();
				boolean found = checkAccountNumber(accountNumber, details);
				if (found == true) {
					int subChoice;
					boolean exit1 = false;
					do {
						subChoice = getSubChoice();
						switch (subChoice) {
						case 1: {
							System.out.println("Enter your new Name");
							String newName = sc.nextLine();
							newName = stringValidate(newName);
							details = obj1.updateName(details, accountNumber, newName);
						}
							break;
						case 2: {
							System.out.println("Enter your new Address");
							String newAddress = sc.nextLine();
							newAddress = stringValidate(newAddress);
							details = obj1.updateAddress(details, accountNumber, newAddress);
						}
							break;
						case 3: {
							System.out.println("Thank you");
							exit1 = true;
						}
							break;
						default: {
							System.out.println("Enter a valid input ");
						}
						}
					} while (exit1 == false);

				}
			}

				break;

			case 3: {
				if (details.length > 0) {
					for (int i = 0; i < details.length; i++) {
						if (details[i].isPresent() == true) {
							System.out.println((i + 1) + "." + details[i].getAccountNumber());
						}
					}
					System.out.println("Enter the account number to delete the Account");
					String accountNumber = sc.next();
					boolean found = checkAccountNumber(accountNumber, details);
					if (found == true) {
						details = obj1.delete(details, accountNumber);
						System.out.println("Account Number" + accountNumber + "is Deleted.");
					} else {
						System.out.println("Account Number not found");
					}
				} else {
					System.out.println("Record is Empty");
				}
				break;
			}
			case 4: {

				if (details.length > 0) {
					boolean exit1 = false;
					do {
						int subChoice2 = getsubChoice2();
						switch (subChoice2) {
						case 1: {
							for (int i = 0; i < details.length; i++) {
								if (details[i].isPresent() == true) {
									System.out.println((i + 1) + ". " + details[i].getAccountNumber());
								}
							}
							System.out.println("Enter the Account Number");
							String accountNumber = sc.next();
							boolean found = checkAccountNumber(accountNumber, details);
							if (found == true) {
								details = obj1.basedId(details, accountNumber);
								for (int index = 0; index < details.length; index++)
									if (details[index].isIdFound() == true) {
										System.out.println("Customer Name: " + details[index].getName());
										System.out
												.println("Customer Date Of Birth: " + details[index].getDateOfBirth());
										System.out.println("Customer Account Type: " + details[index].getAccountType());
										System.out.println("Customer Address: " + details[index].getAddress());
										System.out.println("Customer Balance: " + details[index].getBalance());
									}
							} else {
								System.out.println("Account Number not found");
							}

							break;
						}

						case 2: {
							for (int i = 0; i < details.length; i++) {
								if (details[i].isPresent() == true) {
									System.out.println((i + 1) + ". " + details[i].getName());
								}
							}
							System.out.println("Enter the Account Holder Name : ");
							String name = sc.nextLine();
							name = stringValidate(name);
							boolean found = checkCustomer(details, name);
							if (found == true) {
								details = obj1.basedName(details, name);
								for (int index = 0; index < details.length; index++) {
									if (details[index].isNameFound() == true) {
										System.out.println(
												"Customer Account Number: " + details[index].getAccountNumber());
										System.out
												.println("Customer Date Of Birth: " + details[index].getDateOfBirth());
										System.out.println("Customer Account Type: " + details[index].getAccountType());
										System.out.println("Customer Address: " + details[index].getAddress());
										System.out.println("Customer Balance: " + details[index].getBalance());
									}
								}
							} else {
								System.out.println("Customer not found");
							}

						}

							break;

						case 3: {
							details = obj1.nonZero(details);
							for (int i = 0; i < details.length; i++) {
								if (details[i].isNonZero() == true) {
									System.out.println("Customer Account Number: " + details[i].getAccountNumber());
									System.out.println("Customer Name: " + details[i].getName());
									System.out.println("Customer Date Of Birth: " + details[i].getDateOfBirth());
									System.out.println("Customer Account Type: " + details[i].getAccountType());
									System.out.println("Customer Address: " + details[i].getAddress());
									System.out.println("Customer Balance: " + details[i].getBalance());
								}
							}

						}
							break;
						case 4: {
							AccountInfo[] addressSortedArray = obj1.addressSorted(details);

							System.out.println("Customer Names in sorted order based on address (alphabetical order) ");
							for (int i = 0; i < addressSortedArray.length; i++) {
								if (details[i].isPresent() == true) {
									System.out.println("Address :" + addressSortedArray[i].getAddress() + "\nName : "
											+ addressSortedArray[i].getName() + "\nAccount Number : "
											+ addressSortedArray[i].getAccountNumber() + "\n");
								}
							}
						}
							break;
						case 5: {
							AccountInfo[] accountSortedArray = obj1.accountSorted(details);
							System.out.println("Customer Names in sorted order based on address (alphabetical order) ");
							for (int i = 0; i < accountSortedArray.length; i++) {
								if (details[i].isPresent() == true) {
									System.out.println("AccountNumber : " + accountSortedArray[i].getAccountNumber()
											+ "\nName : " + accountSortedArray[i].getName() + "\nAddress : "
											+ accountSortedArray[i].getAddress() + "\n");
								}
							}
						}
							break;
						case 6: {
							System.out.println("Thank you!");
							exit1 = true;
						}
							break;
						default: {
							System.out.println("Invalid input!");
						}

						}

					} while (exit1 != true);
				}

				else {
					System.out.println("Record is Empty");
				}

			}
				break;

			case 5: {
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

	private static int getsubChoice2() {
		int subChoice2 = 0;
		System.out.println(
				"1.Display customer based on ID \n2.Display customer based on Name \n3.Display customers with non zero balance \n4.Display user sorted based on address (location wise) \n5.Display users sorted based on account id \n6.Exit ");

		System.out.println("Choose an option");
		subChoice2 = sc.nextInt();
		return subChoice2;
	}

	private static int getSubChoice() {
		int subChoice = 0;
		System.out.println("Enter your choice");
		System.out.println("==================");
		System.out.println("1.Update Name \n2.Update Address \n3.Exit");
		subChoice = intValidate();
		return subChoice;
	}

	private static int getChoice() {
		int choice = 0;
		System.out.println(
				"enter your choice \n 1. Add Customer Details \n 2. Update Customer Details \n 3. Delete Customer \n 4. Display Customers \n 5. exit ");
		choice = intValidate();
		return choice;
	}

	private static String acnoValidate(String acno) {
		boolean valid = false;
		int count = 0;
		char[] temp = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		while (valid == false) {
			for (int i = 0; i < acno.length(); i++) {
				for (int j = 0; j < temp.length; j++) {
					if (acno.charAt(i) == temp[j]) {
						count++;
					}
				}

			}
			// System.out.println(count);
			if (count == acno.length()) {
				valid = true;
			}
			if (count == acno.length()) {
				return acno;
			} else {
				System.out.println("Please enter numbers only :");
				acno = sc.next();
			}
		}
		return acno;
	}

	private static boolean checkCustomer(AccountInfo[] details, String name) {
		boolean found = false;
		for (int i = 0; i < details.length; i++) {
			if (details[i].getName().compareToIgnoreCase(name) == 0 && (details[i].isPresent() == true)) {
				found = true;
			}
		}
		return found;
	}

	private static boolean checkAccountNumber(String accountNumber, AccountInfo[] details) {
		boolean found = false;
		for (int i = 0; i < details.length; i++) {
			if (details[i].getAccountNumber().compareToIgnoreCase(accountNumber) == 0
					&& (details[i].isPresent() == true)) {
				found = true;
			}
		}
		return found;
	}

	private static AccountInfo[] addDetails(String acno, String name, String acType, String dob, double blc,
			String address, boolean isPrasent, boolean nameFound, boolean nonZero, boolean idFound,
			AccountInfo[] details) {
		AccountInfo res[] = new AccountInfo[details.length + 1];
		for (int i = 0; i < details.length; i++) {
			res[i] = details[i];
		}
		res[details.length] = new AccountInfo(acno, name, acType, dob, blc, address, isPrasent, nameFound, idFound,
				nonZero);
		return res;
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

	private static double doubleValidate() {

		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextDouble()) {
				data = sc.nextDouble();
				validation = true;
			} else if (!sc.hasNextDouble()) {
				System.out.println("you didn't type double value ! please type valid input");
				sc.next();
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

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the alphabetical string");
			}
			data = sc.nextLine();
		}
		return data;
	}
}