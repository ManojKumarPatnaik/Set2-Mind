package com.mind.Exercise37;

public class MatrixElement {

	public static void main(String[] args) {
		int[][] table=new int[5][10];
		for(int row=0;row<table.length;row++)
		{
			for(int col=0;col<table[row].length;col++)
			{
				table[row][col]=row*10+col;
			}
		}
		for(int row=0;row<table.length;row++)
		{
			for(int col=0;col<table[row].length;col++)
			{
				System.out.print(table[row][col]+" ");
			}
			System.out.println();

	}

}
}
