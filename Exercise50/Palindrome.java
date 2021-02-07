package com.mind.Exercise50;

import java.util.Scanner;

public class Palindrome {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int choice;
		boolean exit=false;
		do {
			System.out.println("1.Number Palindrome \n2.String Palindrome \n3.Exit \n");
			System.out.println("Enter your choice");
			choice = intValidate();
			{
				switch (choice) {
				case 1: {
					
					int number=getNumber();
					boolean isPalindrome=numberPalindrome(number);
					if(isPalindrome)
					{
						System.out.println("The number is Palindrome \n");
					}else
					{
						System.out.println("The number is not a palindrome\n");
					}
				}
					break;
				case 2: {
					String string=getString();
					boolean isPalindrome=stringPalindrome(string);
					if(isPalindrome)
					{
						System.out.println("The string is Palindrome \n");
					}else
					{
						System.out.println("The string is not a palindrome\n");
					}
				}
					break;
				case 3: {
					System.out.println("Thank you ! ");
					exit=true;
				}
				break;
				default: {
					System.out.println("Invalid Input \n");
				}
				}
			}
		}while(exit!=true);
	}

	

	private static String getString() {
		String string="";
		boolean temp=false;
		do
		{
			System.out.println("Enter a string to chech if it's a palindrome :");
			string=sc.nextLine();
			temp=stringValidate(string);
			
		}
		while(!temp);
		return string;
	}



	private static int getNumber() {
		int number=0;
		do
		{
			System.out.println("Enter a number to chech if it's a palindrome");
			number = intValidate();
		}while(number<=0);
		return number;
	}



	private static boolean stringValidate(String string) {
		int length=string.length();
		int integer,count=0;
		for (int i = 0; i < length; i++) {
			integer=string.charAt(i);
			if((integer>65 && integer<90)|| (integer>97 && integer<122))
			{
				count++;
			}
		}
		if(count==length)
		{
			return true;
		}
		return false;
	}



	private static boolean stringPalindrome(String string) {
		boolean result=false;
		int stringLength=string.length();
		int count=0;
		for (int i = 0; i < stringLength/2; i++) {
			if(string.charAt(i)==string.charAt(stringLength-i-1))
			{
				count++;
			}
		}
		if(count==stringLength/2)
		{
			result=true;
		}
		return result;
	}

	private static boolean numberPalindrome(int number) {
		int rev = 0, rem;
		boolean result=false;
		int temp = number;
		while (number != 0) {
			rem = number % 10;
			rev = rev * 10 + rem;
			number /= 10;
		}
		if (temp == rev) {
			result=true;
		}
		return result;

	}
	private static int intValidate() {

		int data = 0;
		boolean validation = false;
		while (!validation) {
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

}
