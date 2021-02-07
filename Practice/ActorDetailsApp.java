package com.mind.Practice;

import java.util.Scanner;

public class ActorDetailsApp {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		ActorDetailsApp ad=new ActorDetailsApp();
		boolean temp=true;
		System.out.println("Enter No of Actors :");
		@SuppressWarnings("unused")
		int noOfActors=sc.nextInt();
		Actor actorDetails[]= {};
		do
		{
			int choice=ad.getChoice();
			switch(choice)
			{
			case 1:int actorId=ad.addActorId();
			       actorId=ad.intValid();
			       String actorName=ad.addActorName();
			       actorName=ad.stringValid(actorName);
			       int movieCount=ad.addActorMovieCount();
			       movieCount=ad.intValid();
			       int age=ad.addAge();
			       age=ad.intValid();
			       age=ad.ageValid(age);
			       String gender=ad.addGender();
			       gender=ad.stringValid(gender);
			       gender=ad.genderValid(gender);
			       actorDetails=ad.addActorDetails(actorId,actorName,movieCount,age,gender,actorDetails);
			       break;
				case 2:
					if (actorDetails.length > 0) {
						System.out.println("Male Actor Details :");
						System.out.println("===================");
						for (int actor = 0; actor < actorDetails.length; actor++) {
							if (actorDetails[actor].getGender().equalsIgnoreCase("male")) {
								System.out.println("Actor ID :" + actorDetails[actor].getActorId());
								System.out.println("Actor Name :" + actorDetails[actor].getActorName());
								System.out.println("Actor Movie count :" + actorDetails[actor].getMovieCount());
								System.out.println("Actor Age :" + actorDetails[actor].getAge());
								System.out.println("Actor Gender :" + actorDetails[actor].getGender());
								System.out.println("--------------");
							}
						}
					} else {
						System.out.println("No Records Found");
					}
					break;
				case 3:
					Actor sortedActorDetails[] = ad.getSortedAge(actorDetails);
					for (int actor = 0; actor < sortedActorDetails.length; actor++) {
						if(sortedActorDetails[actor].getActorId()!=0) {
						System.out.println("Actor ID :" + sortedActorDetails[actor].getActorId());
						System.out.println("Actor Name :" + sortedActorDetails[actor].getActorName());
						System.out.println("Actor Movie count :" + sortedActorDetails[actor].getMovieCount());
						System.out.println("Actor Age :" + sortedActorDetails[actor].getAge());
						System.out.println("Actor Gender :" + sortedActorDetails[actor].getGender());
						System.out.println("--------------");
					}
					}
					break;
				case 4:
					System.out.println("Actor Details whom movie count>10");
					System.out.println("=================================");
					for (int actor = 0; actor < actorDetails.length; actor++) {
						if (actorDetails[actor].getMovieCount() > 10) {
							System.out.println("Actor ID :" + actorDetails[actor].getActorId());
							System.out.println("Actor Name :" + actorDetails[actor].getActorName());
							System.out.println("Actor Movie count :" + actorDetails[actor].getMovieCount());
							System.out.println("Actor Age :" + actorDetails[actor].getAge());
							System.out.println("Actor Gender :" + actorDetails[actor].getGender());
							System.out.println("--------------");
						}
					}
					break;

				case 5:
					System.out.println("Thanks for using application :)");
					temp = false;
					break;
			}
			
		}while(temp);

	}
	private String genderValid(String gender) {
		if(gender.equalsIgnoreCase("male")|| gender.equalsIgnoreCase("female"))
		{
			return gender;
		}
		else
		{
			System.out.println("Enter valid gender (Male/Female):");
			String gender1=sc.nextLine();
			return gender1;
		}
	
	}
	private int getChoice() {
		System.out.println("Enter your choice :");
		System.out.println("===================");
		System.out.println("1.Enter Actor Details");
		System.out.println("2.Display All Male Actors");
		System.out.println("3.Display All Actors in asc order to his or her age");
		System.out.println("4.Display All Actors whom movie count >10");
		System.out.println("5.Exit");
		int choice=sc.nextInt();
		return choice;
	}
	private Actor[] getSortedAge(Actor[] actorDetails) {
		Actor temp;
		for (int i = 0; i < actorDetails.length; i++) {
			for (int j = 1; j < (actorDetails.length-i); j++) {
			if(actorDetails[j-1].getAge()>actorDetails[j].getAge())
			{
				temp=actorDetails[j-1];
				actorDetails[j-1]=actorDetails[j];
				actorDetails[j]=temp;
			}
		}
		}
		return actorDetails;
	}
	private int ageValid(int age) {
		while(age>90)
		{
		
		
			System.out.println("You are not Human ! Please enter valid age :");
			age=sc.nextInt();
		}
		
		return age;
	}
	private String stringValid(String actorName) {

		while (!actorName.matches("[a-zA-Z\\s]+")) {
			if (!actorName.isEmpty()) {
				System.out.println("Please retype the alphabetical string");
			}
			actorName = sc.nextLine();
		}
		return actorName;
	}
	private int intValid() {
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
	private Actor[] addActorDetails(int actorId, String actorName, int movieCount, int age, String gender, Actor[] actorDetails) {
		Actor res[]=new Actor[actorDetails.length+1];
		for (int actor = 0; actor < actorDetails.length; actor++) {
			res[actor]=actorDetails[actor];
		}
		res[actorDetails.length]=new Actor(actorId,actorName,movieCount,age,gender);
		return res;
	}
	private String addGender() {
		System.out.println("Enter Actor Gender:");
		String gender=sc.nextLine();
		return gender;
	}
	private int addAge() {
		System.out.println("Enter Actor Age:");
		int age=0;
		return age;
	}
	private int addActorMovieCount() {
		System.out.println("Enter Movie Count :");
		int mcount=0;
		return mcount;
	}
	private String addActorName() {
		System.out.println("Enter Actor Name :");
		String name=sc.nextLine();
		return name;
	}
	private int addActorId() {
		System.out.println("Enter Actor Id :");
		int id=0;
		return id;
	}


}
