package com.mind.Exercise35;

import java.util.Scanner;

public class StudentDetails {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the number of students: ");
		int students = intValidate();
		students = checkIfPositive(students);
		Student details[] = new Student[students];
		for (int student = 0; student < students; student++) {
			details[student] = new Student();
			System.out.println("Enter student " + (student + 1) + " id");
			int id = intValidate();
			id = checkIfPositive(id);
			System.out.println("Enter student " + (student + 1) + " name");
			String name = s.nextLine();
			name = stringValidate(name);
			System.out.println("Enter branch of the Student " + (student + 1));
			String branch = s.nextLine();
			branch = stringValidate(branch);
			System.out.println("Enter score of the Student " + (student + 1));
			double score = doubleValidate();
			score = checkIfPositive(score);
			details[student].setId(id);
			details[student].setName(name);
			details[student].setBranch(branch);
			details[student].setScore(score);
		}
		int maxScoreIndex = maxscore(details);
		System.out.println("students List who scored the heighest marks");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("StudentId \tStudent Name \t\tStudent Branch \t\tStudent Score");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(details[maxScoreIndex].getId() + "\t\t" + details[maxScoreIndex].getName() + "\t\t\t"
				+ details[maxScoreIndex].getBranch() + "\t\t\t" + details[maxScoreIndex].getScore());

	}public static int maxscore(Student[] details) {
		int maxScoreIndex = 0;
		double maxScore = details[0].getScore();
		for (int studentScore = 0; studentScore < details.length; studentScore++) {
			if (details[studentScore].getScore() > maxScore) {
				maxScoreIndex = studentScore;
			}
		}
		return maxScoreIndex;

	}

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if (!data.isEmpty()) {
				System.out.println("Please retype the Empname");
			}
			data = s.nextLine();
		}
		return data;
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

	private static double doubleValidate() {

		double data = 0;
		boolean validation = false;
		while (validation == false) {
			if (s.hasNextDouble()) {
				data = s.nextDouble();
				validation = true;
			} else if (!s.hasNextDouble()) {
				System.out.println("you didn't type an Double value ! please type Double value");
				s.next();
			}
		}
		return data;

	}

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = s.nextInt();
		}
		return integer;
	}

	private static double checkIfPositive(double integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = s.nextDouble();
		}
		return integer;
	}
}
