package com.sist.manager;

public class ReviewVO {
//	System.out.println("제목 : " + title.text());
//	System.out.println("작성일 : " + date.text());
//	System.out.println("블로그 내용 : " + txt.text());
//	System.out.println("작성자 : " + write.text());
	private String title,content,writer,date,link;
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
