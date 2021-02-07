package com.mind.Exercise36;

import java.util.Scanner;

public class Duplicates {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int[] array1;
		int[] array2;

		System.out.println("Enter the size of array 1");
		int array1Size = intValidate();
		array1Size = checkIfPositive(array1Size);
		array1 = new int[array1Size];
		array1 = arrayInitialization(array1, array1Size);

		System.out.println("Enter the size of array 2");
		int array2Size = intValidate();
		array2Size = checkIfPositive(array2Size);
		array2 = new int[array2Size];
		array2 = arrayInitialization(array2, array2Size);

		int[] nonDuplicates = uniqueElements(array1, array2);
		System.out.print("{");
		for (int i = 0; i < nonDuplicates.length; i++) {
			System.out.print(nonDuplicates[i] + ",  ");
		}
		System.out.print("}");

	}

	private static int[] arrayInitialization(int[] array, int arraysize) {
		for (int index = 0; index < arraysize; index++) {
			System.out.println("Enter the " + (index + 1) + "st value into an array");
			array[index] = intValidate();
		}
		return array;
	}

	private static int[] removeDuplicates1(int[] totalArray) {
		int res[] = {};
		int count;
		int n = totalArray.length;
		System.out.println("Non duplicate elements are: ");
		for (int i = 0; i < n; i++) {
			count = 0;

			for (int j = 0; j < n; j++) {

				if (totalArray[i] == totalArray[j] && i != j)
					count++;
			}

			if (count == 0) {
				res = addToArray(res, totalArray[i]);
			}
		}
		return res;

	}

	private static int[] addToArray(int[] arr, int n) {
		int[] res = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];

		}
		res[res.length - 1] = n;
		return res;
	}

	public static int[] uniqueElements(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int length = arr1.length + arr2.length;
		int count = 0;
		int[] arr3 = new int[length];
		for (int index = 0; index < n; index++) {
			arr3[index] = arr1[index];
			count++;
		}
		for (int index = 0; index < m; index++) {
			arr3[count++] = arr2[index];
		}
		int[] nonDuplicates = removeDuplicates1(arr3);
		return nonDuplicates;

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
