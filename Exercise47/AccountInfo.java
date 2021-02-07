package com.mind.Exercise47;

import java.util.Scanner;


public class AccountInfo {
	static Scanner sc = new Scanner(System.in);

	private String accountNumber;
	private String name;
	private String accountType;
	private String dateOfBirth;
	private double balance;
	private String address;
	private boolean isPresent;
	private boolean nameFound;
	private boolean idFound;

	public boolean isIdFound() {
		return idFound;
	}

	public void setIdFound(boolean idFound) {
		this.idFound = idFound;
	}

	private boolean nonZero;

	public boolean isNonZero() {
		return nonZero;
	}

	public void setNonZero(boolean nonZero) {
		this.nonZero = nonZero;
	}

	public boolean isNameFound() {
		return nameFound;
	}

	public void setNameFound(boolean nameFound) {
		this.nameFound = nameFound;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	
	public AccountInfo(String acno, String name2, String acType, String dob, double blc, String address2,
			boolean isPrasent, boolean nameFound, boolean idFound, boolean nonZero) {
		this.accountNumber = acno;
		this.name = name2;
		this.accountType = acType;
		this.dateOfBirth = dob;
		this.balance = blc;
		this.address = address2;
		this.isPresent = isPrasent;
		this.nameFound = nameFound;
		this.idFound = idFound;
		this.nonZero = nonZero;
	}

	public AccountInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;

	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountInfo[] updateName(AccountInfo[] details, String accountNumber, String newName) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getAccountNumber().compareToIgnoreCase(accountNumber) == 0
					&& (details[i].isPresent() == true)) {
				details[i].setName(newName);
				System.out.println("Updated successfuly");
			}
		}
		return details;

	}

	public AccountInfo[] updateAddress(AccountInfo[] details, String accountNumber, String newAddress) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getAccountNumber().compareToIgnoreCase(accountNumber) == 0
					&& (details[i].isPresent() == true)) {
				details[i].setAddress(newAddress);
				System.out.println("Updated successfuly");
			}
		}
		return details;
	}

	public AccountInfo[] delete(AccountInfo[] details, String accountNumber) {
		for (int i = 0; i < details.length; i++) {
			if (details[i].getAccountNumber().compareToIgnoreCase(accountNumber) == 0
					&& (details[i].isPresent() == true)) {
				details[i].setPresent(false);
			}
		}
		return details;
	}

	public AccountInfo[] accountSorted(AccountInfo[] details) {
		AccountInfo temp;
		for (int j = 0; j < details.length - 1; j++) {
			for (int i = j + 1; i < details.length; i++) {
				if (details[j].getAccountNumber().compareTo(details[i].getAccountNumber()) > 0) {
					temp = details[j];
					details[j] = details[i];
					details[i] = temp;

				}
			}
		}

		return details;

	}

	public AccountInfo[] addressSorted(AccountInfo[] details) {
		AccountInfo temp;
		for (int j = 0; j < details.length - 1; j++) {
			for (int i = j + 1; i < details.length; i++) {
				if (details[j].getAddress().compareTo(details[i].getAddress()) > 0) {
					temp = details[j];
					details[j] = details[i];
					details[i] = temp;

				}
			}
		}

		return details;

	}

	public AccountInfo[] nonZero(AccountInfo[] details) {

		for (int i = 0; i < details.length; i++) {
			System.out.println();
			if (details[i].getBalance() != 0) {
				details[i].setNonZero(true);
			}
		}

		return details;

	}

	public AccountInfo[] basedName(AccountInfo[] details, String name) {

		for (int i = 0; i < details.length; i++) {
			if (name.compareToIgnoreCase(details[i].getName()) == 0 && details[i].isPresent == true) {
				details[i].setNameFound(true);
			}
		}
		return details;
	}

	public AccountInfo[] basedId(AccountInfo[] details, String accountNumber) {

		for (int i = 0; i < details.length; i++) {
			if (accountNumber.compareToIgnoreCase(details[i].getAccountNumber()) == 0 && details[i].isPresent == true) {
				details[i].setIdFound(true);
			}
		}
		return details;

	}

}
