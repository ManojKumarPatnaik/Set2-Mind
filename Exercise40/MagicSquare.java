package com.mind.Exercise40;

import java.util.Scanner;

public class MagicSquare {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the matrix row size");
		int rowSize = intValidate();
		rowSize = checkIfPositive(rowSize);
		System.out.println("Enter the matrix col size");
		int colSize = intValidate();
		colSize = checkIfPositive(colSize);
		if (rowSize != colSize) {
			System.out.println("Not a magic Square'Row and col Size should be equal'");
		} else {
			int[][] matrix = new int[rowSize][colSize];

			System.out.println("Enter Matrix values: ");
			matrix = initializeMatrix(matrix, rowSize, colSize);

			if (isMagicSquare(matrix, rowSize)) {
				System.out.println("Matrix is a Magic Square");
			} else {
				System.out.println("Matrix is Not a magic Square");
			}
			s.close();
		}
	}

	private static int[][] initializeMatrix(int[][] matrix, int rowSize, int colSize) {
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				System.out.println("Enter the value for row " + row + " and " + col);
				matrix[row][col] = intValidate();
			}
		}
		return matrix;
	}

	private static boolean isMagicSquare(int[][] matrix, int rowSize) {
		int sum = 0, sum2 = 0;
		for (int diagonal = 0; diagonal < rowSize; diagonal++) {
			sum = sum + matrix[diagonal][diagonal];
		}
		for (int row = 0; row < rowSize; row++) {
			sum2 = sum2 + matrix[row][rowSize - 1 - row];
		}
		if (sum != sum2) {
			return false;
		}

		for (int row = 0; row < rowSize; row++) {

			int rowSum = 0;
			for (int col = 0; col < rowSize; col++) {
				rowSum += matrix[row][col];
			}

			if (rowSum != sum) {
				return false;
			}
		}

		for (int row = 0; row < rowSize; row++) {

			int colSum = 0;
			for (int col = 0; col < rowSize; col++) {
				colSum += matrix[col][row];
			}

			if (sum != colSum) {
				return false;
			}
		}

		return true;
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

	private static int checkIfPositive(int integer) {
		while (integer < 0) {
			System.out.println("you didn't type an integer value ! please type an integer");
			integer = s.nextInt();
		}
		return integer;
	}
}
