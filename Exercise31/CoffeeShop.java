package com.mind.Exercise31;

public class CoffeeShop {
	private String Name;
	private String MobileNo;
	private double feedbackRating;

	public CoffeeShop(String name, String phn, double fb) {
		this.Name = name;
		this.MobileNo = phn;
		this.feedbackRating = fb;
	}

	public CoffeeShop() {
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public double getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(double feedbackRating) {
		
		this.feedbackRating = feedbackRating;
		
	}

}