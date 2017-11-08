package com.sist.main.dao;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MBLVO")
public class BookListVO {
	private double isbn;
	private String title;
	private String reviewer;
	private String publisher;
	private String pdate;
	private int price;
	private int star;
	private String bimg;
	private String bookintro;
	private String bookin;
	private String pwriter;
	private int count;
	private int count1;
	
	
	public int getCount1() {
		return count1;
	}
	public void setCount1(int count1) {
		this.count1 = count1;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getIsbn() {
		return isbn;
	}
	public void setIsbn(double isbn) {
		System.out.println(isbn);
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
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
	public String getBookin() {
		return bookin;
	}
	public void setBookin(String bookin) {
		this.bookin = bookin;
	}
	public String getPwriter() {
		return pwriter;
	}
	public void setPwriter(String pwriter) {
		this.pwriter = pwriter;
	}
}
