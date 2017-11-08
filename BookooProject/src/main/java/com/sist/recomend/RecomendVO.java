package com.sist.recomend;

public class RecomendVO {
	private double isbn;
	private String title;
	private String publisher;
	private int price;
	private int star;
	private String bimg;
	private String bookintro;
	private int category;
	private int totloan_count;
	private int gender;  //빌린 사람 성별
	private int age; //빌린 사람 나이
	public double getIsbn() {
		return isbn;
	}
	public void setIsbn(double isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getBookintro() {
		return bookintro;
	}
	public void setBookintro(String bookintro) {
		this.bookintro = bookintro;
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

	
}
