package com.mind.Exercise30;

public class Bank {
	private double balance;
	private int intrestRate;
	private int accountNo;

	Bank() {

	}

	public Bank(int accountNo2, int intrestRate2, double balance2) {
		this.accountNo = accountNo2;
		this.intrestRate = intrestRate2;
		this.balance = balance2;
	}

	public double withDraw(double amount) {
		double balanceCheck = -1;
		if (amount < balance) {
			double blc = amount;
			balanceCheck = blc;
		}
		return balanceCheck;

	}

	public void display() {
		System.out.println("Account Number: " + accountNo);
		System.out.println("Intrest Rate: " + intrestRate);
		System.out.println("Balance: " + balance);

	}

	public int calculateIntrest(double blc, int intrestRate2, int time) {
		int intrest = ((int) blc * intrestRate2 * time) / 100;

		return intrest;
	}

}