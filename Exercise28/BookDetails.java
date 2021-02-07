package com.mind.Exercise28;

import java.util.Scanner;

public class BookDetails {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		
		int size;
		System.out.println("Enter the number of books you want to store: ");
		size = intValidate();
		size = checkIfPositive(size);

		Bookstore bookDetails[] = new Bookstore[size];

		for (int book = 0; book < bookDetails.length; book++) {
			String authorName, bookName;
			int yearOfPublication;
			int price;
			System.out.println("Enter the Author Name");
			authorName = sc.nextLine();
			authorName = stringValidate(authorName);
			System.out.println("Enter the Book Name");
			bookName = sc.nextLine();
			bookName = stringValidate(bookName);
			System.out.println("Enter the price of the book");
			//price = sc.nextDouble();
			price = intValidate();
			price = checkIfPositive(price);
			System.out.println("Enter Year of Publication");
			yearOfPublication = intValidate();
			yearOfPublication = checkIfPositive(yearOfPublication);
			//yearOfPublication = sc.nextInt();
			Bookstore obj = new Bookstore();
			obj.setAuthorname(authorName);
			obj.setBookname(bookName);
			obj.setPrice(price);
			obj.setYearofpub(yearOfPublication);
			obj.setFindBook(false);
			bookDetails[book] = obj;
			
		}
		System.out.println("Book name's that are in book Store");
		for (int i = 0; i < bookDetails.length; i++) {
			System.out.println((i + 1) + "." + bookDetails[i].getBookname() + "\n");
		}

		System.out.println("Enter the book name to find the details of the book");
		// reading book name from the user
		String bookName = sc.nextLine();
		// validating user input
		bookName = stringValidate(bookName);
		// searching for the book to get details
		bookDetails = getBookDetails(bookName, bookDetails);
		int temp=0;
		for (int bookIndex = 0; bookIndex < bookDetails.length; bookIndex++) {
			if (bookDetails[bookIndex].isFindBook() == true) {
				// finding the book based on index value of the book and printing the details

				System.out.println("Book Name: " + bookDetails[bookIndex].getBookname());
				System.out.println("Author Name: " + bookDetails[bookIndex].getAuthorname());
				System.out.println("Book Price: " + bookDetails[bookIndex].getPrice());
				System.out.println("Year of bublishing: " + bookDetails[bookIndex].getYearofpub());
				temp++;
			} 
			}
		if(temp==0) {
			System.out.println("Book not found");
		}

		}
	

	
	private static Bookstore[] getBookDetails(String bookName, Bookstore[] details) {

		for (int index1 = 0; index1 < details.length; index1++) {
			if (bookName.toLowerCase().equals(details[index1].getBookname().toLowerCase())) {
				details[index1].setFindBook(true);

			}
		}
		return details;
	}

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the name");
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

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type positive value ! please type positive");
			integer = sc.nextInt();
		}
		return integer;
	}

}
