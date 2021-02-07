package com.mind.Exercise48;

import java.util.Scanner;

public class NumberGuessingGame {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Guessing game");
		String customerName=getCustomerName();
		int randomNumber = randomNumberGenerator(customerName);
		int guessNumber, count = 1;
		System.out.println("Guess the number");
		guessNumber = intValidate();

		int gussings = guessingGame(randomNumber, guessNumber, count);
		System.out.println("The number is " + randomNumber + "\nNumber of guesses it took: " + gussings);
	}

	private static String getCustomerName() {
		String customerName="";
		boolean temp=true;
		do
		{
			System.out.println("Please enter your name : ");
			customerName=s.nextLine();
			temp=stringValidate(customerName);
		}while(!temp);
		return customerName;
	}

	private static boolean stringValidate(String customerName) {
		int length=customerName.length();
		int integer,count=0;
		for (int i = 0; i < length; i++) {
			integer=customerName.charAt(i);
			if((integer>65 && integer<90)|| (integer>97 && integer<122))
			{
				count++;
			}
		}
		if(count==length)
		{
			return false;
		}
		return true;
	}

	private static int randomNumberGenerator(String customerName) {
		int oneChar,secondChar,randomNumber;
		oneChar=customerName.charAt(0);
		secondChar=customerName.charAt(customerName.length()-1);
		randomNumber=(oneChar*2)+(secondChar*3);
		return randomNumber;
	}

	private static int guessingGame(int randomNumber, int guessNumber, int count) {

		while (guessNumber != randomNumber) {
			if (guessNumber < randomNumber) {
				System.out.println("Too Low...");
				count++;
				System.out.println("Please Guess again");
				guessNumber = intValidate();
			} else {
				System.out.println("Too High...");
				count++;
				System.out.println("Please Guess again");
				guessNumber = intValidate();
			}
		}
		return count;

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