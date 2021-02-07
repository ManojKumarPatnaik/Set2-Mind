package com.mind.Practice3;

import java.util.Scanner;

public class FindNReplaceString {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a String :");
		String string = sc.nextLine();
		System.out.println("Enter replace word :");
		String replaceWord = sc.nextLine();
		System.out.println("Enter new word :");
		String newWord = sc.nextLine();
		int firstIndex = string.indexOf(replaceWord);
		String frontPart = getFrontPart(string, firstIndex);
		int lastIndex = replaceWord.length() + firstIndex;
		String lastPart = getLastPart(string, lastIndex);
		String revNewWord = getRevNewWord(newWord);
		String finalResultString = getFinalString(frontPart, revNewWord, lastPart);
		System.out.println("Result :");
		System.out.println(finalResultString);

	}

	private static String getFinalString(String frontPart, String revNewWord, String lastPart) {
		String temp = "";
		temp = frontPart + revNewWord + lastPart;
		return temp;
	}

	private static String getRevNewWord(String newWord) {
		String temp = "";
		for (int i = newWord.length() - 1; i >= 0; i--) {
			temp = temp + newWord.charAt(i);
		}
		return temp;
	}

	private static String getLastPart(String string, int lastIndex) {
		String temp = "";
		int length = string.length();
		for (int i = lastIndex; i < length; i++) {
			temp = temp + string.charAt(i);
		}
		return temp;
	}

	private static String getFrontPart(String string, int index) {
		String temp = "";
		for (int i = 0; i < index; i++) {
			temp = temp + string.charAt(i);
		}
		return temp;
	}

}
