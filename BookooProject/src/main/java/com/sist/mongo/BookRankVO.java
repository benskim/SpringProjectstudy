package com.sist.mongo;

public class BookRankVO {

	private int category;
	private String bookname;
	private double totloan_count;

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getTotloan_count() {
		return totloan_count;
	}
	public void setTotloan_count(double totloan_count) {
		this.totloan_count = totloan_count;
	}
	
	
}
