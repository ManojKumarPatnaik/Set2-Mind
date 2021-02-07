package com.mind.Exercise49;

import java.util.Scanner;

public class SumOfSubsets {
	static Scanner sc = new Scanner(System.in);
	static int[] stack = new int[20];
	static int top = -1;

	static void push(int a) {
		stack[++top] = a;
	}

	static void clear() {
		top = -1;
	}

	static int[] insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		return array;
	}

	static void check(int s) {
		int sum = 0;
		for (int i = top; i >= 0; i--)
			sum += stack[i];
		if (sum == s) {
			for (int i = top; i >= 0; i--)
				System.out.print(stack[i] + " ");
			System.out.println();
		}
		clear();
	}

	static void findSub(int[] a, int s) {
		a = insertionSort(a);
		
		int n = a.length;
		
		for (int i = 1; i < (1 << n); i++) {
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) > 0)
					push(a[j]);
			check(s);
		}
	}

	
	public static void main(String[] args) {
		System.out.print("Enter the size of the array: ");
		int s = intValidate();
		int[] array = getElements(s);
		
		System.out.print("Enter sum: ");
		int sum = intValidate();
		findSub(array, sum);
	}

	private static int[] getElements(int s) {
		int[] a=new int[s];
		System.out.print("Enter the elements of the array: ");
		for (int i = 0; i < s; i++) {
			a[i] = intValidate();
			if (a[i] < 0) {
				System.out.print("Invalid input!");
			}
		}
		return a;
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
