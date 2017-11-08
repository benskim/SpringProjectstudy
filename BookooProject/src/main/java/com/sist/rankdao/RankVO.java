package com.sist.rankdao;

public class RankVO {
	private String bookname;
	private float isbn;
	private int category;
	private int totloan_count;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public float getIsbn() {
		return isbn;
	}
	public void setIsbn(float isbn) {
		this.isbn = isbn;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getTotloan_count() {
		return totloan_count;
	}
	public void setTotloan_count(int totloan_count) {
		this.totloan_count = totloan_count;
	}
	
}
