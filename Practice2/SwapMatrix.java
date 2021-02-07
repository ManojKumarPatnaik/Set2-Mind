package com.mind.Practice2;

import java.util.Scanner;

public class SwapMatrix {
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) {
		System.out.println("Enter the row size of the Matrix (n) :");
		int rowSize=sc.nextInt();
		System.out.println("Enter the col size of the Matrix (n) :");
		int colSize=sc.nextInt();
		int matrix[][]=getMatrixElements(rowSize,colSize);
		System.out.println("Enter the column ! u want to swap :");
		int firstCol=sc.nextInt();
		System.out.println("Enter the target column :");
		int secondCol=sc.nextInt();
		int resultMatrix[][]=getSwappedMatrix(matrix,firstCol,secondCol);
		System.out.println("Result matrix :");
		System.out.println("===============");
		for (int i = 0; i < resultMatrix.length; i++) {
			for(int j=0;j<resultMatrix[i].length;j++) {
				System.out.print(resultMatrix[i][j]+" ");
			}System.out.println();
			
		}
	}
	private static int[][] getSwappedMatrix(int[][] matrix, int firstCol, int secondCol) {
		int length=matrix.length;
		for (int i = 0; i < length; i++) {
			int temp=matrix[i][firstCol-1];
			int flag=matrix[i][secondCol-1];
			matrix[i][secondCol-1]=temp*temp;
			matrix[i][firstCol-1]=flag*flag;	
			
			}
		return matrix;
	}
	private static int[][] getMatrixElements(int rowSize, int colSize) {
		int temp[][]=new int[rowSize][colSize];
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				System.out.println("Enter the value for row " + row + " and " + col);
				temp[row][col] = intValidate();
			}
		}
		return temp;
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

}
