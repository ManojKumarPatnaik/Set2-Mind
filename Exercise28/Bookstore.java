package com.mind.Exercise28;

public class Bookstore {
	private String author_name;
	private String book_name;
	private int yearofpub;
	private double price;
	private boolean findBook;
	public boolean isFindBook() {
		return findBook;
	}

	public void setFindBook(boolean findBook) {
		this.findBook = findBook;
	}

	public String getAuthorname() {
		return author_name;
	}

	public void setAuthorname(String author_name) {
		this.author_name = author_name;
	}

	public String getBookname() {
		return book_name;
	}

	public void setBookname(String book_name) {
		this.book_name = book_name;
	}

	public int getYearofpub() {
		return yearofpub;
	}

	public void setYearofpub(int yearofpub) {
		this.yearofpub = yearofpub;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}