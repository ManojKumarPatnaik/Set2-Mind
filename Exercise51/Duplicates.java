package com.mind.Exercise51;

import java.util.Scanner;

public class Duplicates {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array;
		int[] duplicateArray;
		int size;
		do
		{
			System.out.println("Enter the array size");
			size = intValidate();
			
		}while(size<0);
		array = new int[size];
		array = arrayInitialization(array, size);
		array = Insertion_sort(array);

		duplicateArray = findDuplicates(array);
		if (duplicateArray.length <= 0) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < duplicateArray.length; i++) {
				System.out.print(duplicateArray[i] + " ");
			}
		}

	}

	private static int[] arrayInitialization(int[] array, int size) {
		System.out.println("Enter the elements into an Array : \n");
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the element for location "+i+" : ");
			array[i] = intValidate();
			if (array[i] <= 0) {
				System.out.println("please enter the positive number: ");
				array[i] = intValidate();
			}
		}
		return array;
	}

	public static int[] Insertion_sort(int[] arr) {
		int length = arr.length;

		for (int j = 1; j < length; j++) {
			int a = arr[j];
			int k = j - 1;
			while ((k > -1) && (arr[k] > a)) {
				arr[k + 1] = arr[k];
				k--;
			}
			arr[k + 1] = a;
		}
		return arr;
	}

	private static int[] findDuplicates(int[] arr) {
		int[] res = {};
		int result = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] == arr[j]) && (arr[j] != result) && (arr[i] != result)) {
					res = addToArray(res, arr[i]);
					result = arr[i];

				}
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
