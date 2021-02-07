package com.mind.Exercise34;

import java.util.Scanner;

public class StudentDetails {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		int id, ch;
		String name, branch;

		Student details[] = {};
		System.out.println("The Student record is empty Please enter number of students you want to Load : ");
		int size = intValidate();
		size = checkIfPositive(size);
		for (int i = 0; i < size; i++) {
			System.out.println("enter id of student: ");
			id = intValidate();
			id = checkIfPositive(id);
			System.out.println("enter name of student: ");
			name = sc.nextLine();

			name = stringValidate(name);
			System.out.println("enter branch of student: ");
			branch = sc.nextLine();
			branch = stringValidate(branch);

			details = addStudents(id, name, branch, details);
		}
		boolean exit = false;
		do {

			System.out.println(
					"enter your choice \n 1. to add student record \n 2. Display Student Names in sorted order based on branch (alphabetical order) \n 3. Display Student ID in ascending sorted order \n 4. exit ");
			ch = intValidate();
			switch (ch) {
			case 1: {
				System.out.println("enter id of student: ");
				id = intValidate();
				id = checkIfPositive(id);
				System.out.println("enter name of student: ");
				name = sc.nextLine();

				name = stringValidate(name);
				System.out.println("enter branch of student: ");
				branch = sc.nextLine();
				branch = stringValidate(branch);

				details = addStudents(id, name, branch, details);

				break;
			}
			case 2: {
				if (details.length > 0) {
					Student[] branchSortedDetails = branchsort(details);
					System.out.println("Student Names in sorted order based on branch (alphabetical order) ");
					System.out.println("----------------------------------------");
					System.out.println("ID \t\t Name \t\t Branch");
					System.out.println("----------------------------------------");
					for (int student = 0; student < branchSortedDetails.length; student++) {
						System.out.println(
								branchSortedDetails[student].getId() + " \t\t " + branchSortedDetails[student].getName()
										+ "\t  " + branchSortedDetails[student].getBranch());
						System.out.println("----------------------------------------");
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 3: {
				if (details.length > 0) {
					Student[] idSortedDetails = idsort(details);
					System.out.println("Student Names in sorted order based on Student id ");
					System.out.println("----------------------------------------");
					System.out.println("ID \t\t Name \t\t Branch");
					System.out.println("----------------------------------------");
					for (int student = 0; student < idSortedDetails.length; student++) {
						System.out.println(idSortedDetails[student].getId() + " \t\t "
								+ idSortedDetails[student].getName() + "\t  " + idSortedDetails[student].getBranch());
						System.out.println("----------------------------------------");
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
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

	private static Student[] addStudents(int id, String name, String branch, Student[] details) {
		Student res[] = new Student[details.length + 1];
		for (int student = 0; student < details.length; student++) {
			res[student] = details[student];
		}
		res[details.length] = new Student(id, name, branch);
		return res;
	}

	public static Student[] branchsort(Student[] details) {

		Student temp = null;
		System.out.println(details.length);
		for (int student1 = 0; student1 < details.length - 1; student1++) {
			for (int student2 = student1 + 1; student2 < details.length; student2++) {
				if (details[student1].getBranch().compareTo(details[student2].getBranch()) > 0) {
					temp = details[student1];
					details[student1] = details[student2];
					details[student2] = temp;

				}
			}
		}
		return details;
	}

	public static Student[] idsort(Student[] details) {
		Student temp;
		int n = details.length;

		for (int student1 = 0; student1 < n - 1; student1++) {
			for (int student2 = student1 + 1; student2 < n; student2++) {
				if (details[student1].getId() > details[student2].getId()) {
					temp = details[student1];
					details[student1] = details[student2];
					details[student2] = temp;

				}

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

	public static int intValidate() {

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