package com.mind.Exercise38;

import java.util.Scanner;

public class MatrixSum {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the matrix 1 row size");
		int m1RowSize = intValidate();
		m1RowSize=checkIfPositive(m1RowSize);
		System.out.println("Enter the matrix 1 col size");
		int m1ColSize = intValidate();
		m1ColSize=checkIfPositive(m1ColSize);
		System.out.println("Enter the matrix 2 row size");
		int m2RowSize = intValidate();
		m2RowSize=checkIfPositive(m2RowSize);
		System.out.println("Enter the matrix 2 col size");
		int m2ColSize = intValidate();
		m2ColSize=checkIfPositive(m2ColSize);
		int[][] matrix1 = new int[m1RowSize][m1ColSize];
		int[][] matrix2 = new int[m2RowSize][m2ColSize];

		if (m1RowSize == m2RowSize && m1ColSize == m2ColSize) {
			System.out.println("Enter Matrix 1 values: ");
			matrix1 = initializeMatrix(matrix1, m1RowSize, m1ColSize);

			System.out.println("Enter Matrix 2 values: ");
			matrix2 = initializeMatrix(matrix2, m2RowSize, m2ColSize);

			marixSum(matrix1, matrix2, m1RowSize,m1ColSize);
		} else {
			System.out.println("row and column size should be same for 2 matxix");
		}

		s.close();

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

	private static void marixSum(int[][] matrix1, int[][] matrix2, int m1rowSize, int m1colSize) {
	    int[] resultMatrix = new int[m1rowSize+m1colSize];
	    for (int i = 0; i < m1rowSize; i++) {
	    	for (int j = 0; j <m1colSize; j++) {
	    	
	    	resultMatrix[i+(m1colSize*j)]=matrix1[i][j]+matrix2[i][j];
	    	}
		}
		/*
		 * for (int row = 0; row < m1rowSize; row++) { for (int col = 0; col <
		 * m1colSize; col++) { matrixSum[row][col] = matrix1[row][col] +
		 * matrix2[row][col]; } }
		 */
		/*
		 * System.out.println("Sum of the matrices is: \n"); for (int row = 0; row <
		 * m1rowSize; row++) { for (int col = 0; col < m1colSize; col++) {
		 * System.out.print(matrixSum[row][col] + "  "); } System.out.println(); }
		 */
	    for (int i = 0; i < resultMatrix.length; i++) {
	    	System.out.print(resultMatrix[i]+" ");
	    	
			
		}

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
	}private static int checkIfPositive(int integer) {
		while(integer<0)
		{
			System.out.println("you didn't type an integer value ! please type an integer");
			integer=s.nextInt();
		}
		return integer;
	}

}
