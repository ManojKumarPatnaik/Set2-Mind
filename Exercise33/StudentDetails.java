package com.mind.Exercise33;

import java.util.Scanner;

public class StudentDetails {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter Student Id");
		int sId = intValidate();
		sId = checkIfPositive(sId);
		System.out.println("Enter Student Name");
		String studentName = sc.nextLine();
		studentName = stringValidate(studentName);
		System.out.println("is Student is haveing chance or not Enter true or false");
		boolean secondChance = booleanValidate();
		Student details = new Student(sId, studentName, secondChance);

		/*
		 * details.setStudentId(sId); details.setStudentName(sName);
		 * details.setSecondChance(sChance);
		 */

		if (details.isSecondChance() == true) {
			System.out.println("Enter First attempt marks");
			float firstMarks = sc.nextFloat();
			System.out.println("Enter Second attempt marks");
			float secondMarks = sc.nextFloat();

			float marks=identifyMarks(firstMarks, secondMarks);
			details.setMarks(marks);
			display(details);
		} else {
			System.out.println("Enter First Chance marks");
			float firstMarks = sc.nextFloat();
			float marks=identifyMarks(firstMarks);
			details.setMarks(marks);
			display(details);
		}
	}public static float identifyMarks(float marks) {
		return marks;

	}

	public static float identifyMarks(float marks1, float marks2) {
		float marks;
		if (marks1 > marks2) {
			marks = marks1;
		}

		else {
			marks = marks2;
		}

		return marks;

	}


	private static void display(Student details) {
		System.out.println("Student Id :" + details.getStudentId());
		System.out.println("Student Name :" + details.getStudentName());
		System.out.println("Second Cance :" + details.isSecondChance());
		System.out.println("Student Marks : "+details.getMarks()+"\n");
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

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please give alphabetical input");
			}
			data = sc.nextLine();
		}
		return data;
	}

	private static boolean booleanValidate() {
		boolean data = false;
		boolean validation = false;
		while (validation == false) {
			if (sc.hasNextBoolean()) {
				data = sc.nextBoolean();
				validation = true;
			} else if (!sc.hasNextBoolean()) {
				System.out.println("Please enter true or false");
				sc.next();
			}
		}
		return data;
	}
}