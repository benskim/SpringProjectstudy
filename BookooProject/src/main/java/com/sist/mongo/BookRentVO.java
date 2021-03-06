package com.sist.mongo;

public class BookRentVO {
	private int no;	//그냥 번호 프라이머리키로 써도됨
	private String startDt; //책 대여 시작한 날짜 특별히 의미 없음
	private int gender;  //빌린 사람 성별
	private int age; //빌린 사람 나이
	private int category; //장르 1~9까지 잇음 철학,종교,사회과학,자연과학,기술과학,예술,언어,문화,역사 
	private double isbn13; //책 고유 번호
	private String bookname; 
	private String rentNO;
	private double loan_count; //빌린 횟수
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
	public double getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(double loan_count) {
		this.loan_count = loan_count;
	}
	public String getRentNO() {
		return rentNO;
	}
	public void setRentNO(String rentNO) {
		this.rentNO = rentNO;
	}
	
	
	
}
