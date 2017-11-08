package com.sist.janre.dao;

public class RentVO {
	private int no;
	private String startDt;
	private int gender;
	private int age;
	private int category;
	private double isbn13;
	private String bookname;
	private String rentNo;
	private double loan_count;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public double getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(double isbn13) {
		this.isbn13 = isbn13;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getRentNo() {
		return rentNo;
	}
	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}
	public double getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(double loan_count) {
		this.loan_count = loan_count;
	}
	
	
}
