package com.mind.Exercise29;

public class Bank {

	private int custId;
	private String custName;
	private String custAddress;
	private String accType;
	private Double custBalance;

	public Bank(int i, String name, String address, String type, double balance) {
		custId = i;
		custName = name;
		custAddress = address;
		accType = type;
		custBalance = balance;
	}

	public Bank(int i, String name, String address) {
		custId = i;
		custName = name;
		custAddress = address;
		this.accType = null;
		this.custBalance = null;
	}

	public Bank(int i, String name) {
		custId = i;
		custName = name;
		this.custAddress = null;
		this.accType = null;
		this.custBalance = null;
	}

	public int getCustId() {
		return custId;
	}

	

	public String getCustName() {
		return custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	

	public String getAccType() {
		return accType;
	}

	public Double getCustBalance() {
		return custBalance;
	}

	
}