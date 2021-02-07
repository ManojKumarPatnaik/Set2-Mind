package com.mind.Exercise33;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);

	private int studentId;
	private String studentName;
	private float marks;
	private boolean secondChance;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public boolean isSecondChance() {
		return secondChance;
	}

	public void setSecondChance(boolean secondChance) {
		this.secondChance = secondChance;
	}

	public Student(int sId, String sName, boolean sChance) {
		studentId = sId;
		studentName = sName;
		secondChance = sChance;
	}
	

}