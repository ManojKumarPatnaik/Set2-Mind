package com.mind.Exercise39;

import java.util.Scanner;

public class RowMagic {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		System.out.println("Enter the matrix row size");
		int rowSize = intValidate();
		rowSize=checkIfPositive(rowSize);
		System.out.println("Enter the matrix col size");
		int colSize = intValidate();
		colSize=checkIfPositive(colSize);
		int[][] matrix = new int[rowSize][colSize];

		System.out.println("Enter Matrix values: ");
		matrix = initializeMatrix(matrix, rowSize, colSize);
		int rowMagic[]=getRowMagic(matrix);
		int rowsum = 0;
		int count=0;
		
		for (int row = 0; row < 1; row++) {
			for (int col = 0; col < matrix.length; col++) {
				rowsum += matrix[row][col];
			}
		}
		for(int i=0;i<rowMagic.length;i++)
		{
			if(rowMagic[i]==rowsum)
			{
				count++;
			}
		}
		if(count==rowMagic.length)
		{
			System.out.println("Matrix is a Row Magic Square");
		} else {
			System.out.println("Matrix is Not a Row magic Square");
		}
		
	
	}

	private static int[] getRowMagic(int[][] matrix) {
		
		int[] sumArr=new int[matrix.length];
		for (int row = 0; row < matrix.length; row++) {
			int rowSum1=0;
			for (int col = 0; col < matrix.length; col++) {
				rowSum1 += matrix[row][col];
			}
			sumArr[row]=rowSum1;
		}
		return sumArr;
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
