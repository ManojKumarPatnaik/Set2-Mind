package com.mind.Exercise46;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TicketBookingApp {
	static Scanner sc = new Scanner(System.in);
	private String name;
	private String mobileNumber;
	private String sourse;
	private String destination;
	private String date;
	private int id;
	private int age;
	private String dob;
	private String Address;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setDate(String date2) {
		this.date = date2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public TicketBookingApp() {

	}

	public TicketBookingApp(int id2, String name2, int age2, String phno, String Dob, String address) {
		this.id = id2;
		this.name = name2;
		this.age = age2;
		this.mobileNumber = phno;
		this.dob = Dob;
		this.Address = address;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSourse() {
		return sourse;
	}

	public void setSourse(String sourse) {
		this.sourse = sourse;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public String bookTicket(TicketBookingApp[] details, int id2, String phn) throws ParseException {

		String result;

		boolean compare = Compare(id2, phn, details);
		if (compare == true) {
			System.out.println("Enter the source");
			String source = sc.nextLine();
			source = stringValidate(source);
			System.out.println("Enter the Destination");
			String destination = sc.nextLine();
			destination = stringValidate(destination);
			System.out.println("Enter the  journey Date(yyyy-mm-dd)");
			String date = sc.nextLine();
			date = dobValidate(date);
			System.out.println("Enter today date : ");
			String todayDate=sc.next();
			todayDate=dobValidate(todayDate);
			boolean dateCompare=checkJourneyDate(date,todayDate);
			
			if ((source.compareTo(destination) != 0)
					&& dateCompare ) {
				this.setId(id);
				this.setMobileNumber(phn);
				this.setSourse(source);
				this.setDestination(destination);
				this.setDate(date);

				result = "Ticket Conformed";

			} else {
				result = "Ticket Booking Failed";
			}
		} else {

			result = "Customer Details not found";
		}
		return result;
	}

	private boolean checkJourneyDate(String date2, String todayDate) throws ParseException  {
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd"); 
         Date testDate1=sdfo.parse(date2);
         Date testDate2=sdfo.parse(todayDate);
         if(testDate1.compareTo(testDate2)>0)
         {
        	 return true;
         }
         else if(testDate1.compareTo(testDate2)<0)
         {
        	 return false;
         }
		
		return false;
	}

	private boolean Compare(int id2, String phn, TicketBookingApp[] details) {
		boolean result = false;
		for (int i = 0; i < details.length; i++) {
			if (id2 == details[i].getId() && (phn.compareTo(details[i].getMobileNumber()) == 0)) {
				result = true;
			}
		}
		return result;
	}

	private static String stringValidate(String data) {

		while (!data.matches("[a-zA-Z\\s]+")) {
			if(!data.isEmpty())
			{
			System.out.println("Please retype the Empname");
			}
			data = sc.nextLine();
		}
		return data;
	}

	private static String dobValidate(String data) {

		while (!data.matches("((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
			System.out.println("Please retype the Date of Birth");
			data = sc.next();
		}
		return data;
	}

	public TicketBookingApp[] names(TicketBookingApp[] details) {
		String tempname;
		for (int j = 0; j < details.length - 1; j++) {
			for (int i = j + 1; i < details.length; i++) {
				if (details[j].getName().compareTo(details[i].getName()) > 0) {

					tempname = details[j].getName();
					details[j].setName(details[i].getName());
					details[i].setName(tempname);
				}
			}
		}
		return details;

	}

	public int basedId(TicketBookingApp[] details, int id2) {

		int index = -1;
		int length = details.length;
		for (int i = 0; i < length; i++) {
			System.out.println();
			if (id2 == details[i].getId()) {

				index = i;
			}
		}

		return index;

	}

	public int basedCity(TicketBookingApp[] details, String city) {
		int length = details.length;
		int index = -1;
		for (int i = 0; i < length; i++) {
			if (city.compareTo(details[i].getAddress()) == 0) {

				index = i;
			}
		}
		return index;

	}
}