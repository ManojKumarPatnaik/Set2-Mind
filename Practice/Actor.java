package com.mind.Practice;

public class Actor {
	private int actorId=0;
	private String actorName="";
	private int movieCount=0;
	private int age=0;
	private String gender="";

	public Actor(int actorId, String actorName, int movieCount, int age, String gender) {
		this.actorId=actorId;
		this.actorName=actorName;
		this.age=age;
		this.movieCount=movieCount;
		this.gender=gender;
	}

	public String getGender() {

		return gender;
	}

	public int getActorId() {

		return actorId;
	}

	public int getMovieCount() {

		return movieCount;
	}

	public String getActorName() {

		return actorName;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	
}
