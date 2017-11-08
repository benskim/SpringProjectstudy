package com.sist.manager;

import java.io.FileReader;
import java.net.URLEncoder;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.book.BookDAO;

import au.com.bytecode.opencsv.CSVReader;

public class ReviewTable {
	static BookDAO dao=new BookDAO();
	public static void main(String[] args) {
		ReviewTable b = new ReviewTable();
		try {
//			dao.bookDrop();
			CSVReader cr = new CSVReader(new FileReader("/home/sist/csv_data/distinct_book2.csv"));
			List<String[]> lists = cr.readAll();
			String data = "";
			for (String[] ss : lists) {
				if (ss.length < 2) {
					for (String s : ss) {
						String url = "http://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="
								+ s;
						Document doc = Jsoup.connect(url).get();
						Element noReslut = doc.select("div#content > div.no_result").first();
						if (noReslut == null) {
							Element book = doc.select("ul.basic li div div a").first();
							String link = book.attr("href");
//							System.out.println(link);
							List<String> rlist = b.BookReviewLinkData(link);
							
							for (String rlink : rlist) {
								ReviewVO vo = b.BookReviewData(rlink,s);						
								
							}
						}
					}
				}
			}
			System.out.println("insert end..");
			cr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


	public String BookGetcodeData(String isbn) {
		String link = "";
		try {
			String url = "http://http://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="
					+isbn;
			Document doc = Jsoup.connect(url).get();
			Element book = doc.select("ul.basic li div div a").first();
			link = book.attr("href");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return link;
	}
	
	// 상세페이지에서 리뷰링크가져오기 
	public List<String> BookReviewLinkData(String link) {
		List<String> rlist = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(link).get();
			Elements rlink = doc.select("div.book_info_inner div.txt_desc a");
			for (int i = 0; i < rlink.size(); i++) {
				rlist.add(rlink.get(i).attr("href"));
//				System.out.println(rlink.get(i).attr("href"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rlist;
	}

	// 블로그 링크 가져오기
	public ReviewVO BookReviewData(String rlink,String s) {
		int count = 1;
		List<String> rvlist = new ArrayList<String>();
		ReviewVO vo = new ReviewVO();
		try {
			for (int p = 1; p < 500; p++) {
				Document doc = Jsoup.connect("http://book.naver.com" + rlink + "&page=" + p).get();
				for (int i = 1; i < 11; i++) {

					Elements rvlink = doc.select("dd#review_author_" + i + " a");
					Element title = doc.select("ul.basic li dl dt").get(i);

					Elements date = doc.select("ul.basic li dd.txt_inline");

					Elements txt = doc.select("dd#review_text_" + i);
					Elements write = doc.select("dd#review_author_" + i);
					
					// ---------
					
					String writer = write.text();
					writer = writer.substring(writer.indexOf("명 :")+3, writer.lastIndexOf("|")).trim();
					
					// ---------

					for (int j = 0; j < rvlink.size(); j++) {
						System.out.println("링크 : " + rvlink.get(j).attr("href"));

						System.out.println("제목 : " + title.text());
						System.out.println("작성일 : " + date.text());
						System.out.println("블로그 내용 : " + txt.text());
						System.out.println("작성자 : " + writer);//writer
						System.out.println();
						System.out.println();
						
						// vo.setLink(rvlink.get(j).attr("href"));
						vo.setLink(rvlink.get(j).attr("href").trim());
						vo.setTitle(title.text());
						// vo.setDate(date.text());
						vo.setDate(date.text().trim());						
						vo.setContent(txt.text());
						vo.setWriter(writer);		//isbn은 다른곳에서..	
						vo.setIsbn(s);
						if(vo.getTitle()!=null){
							dao.reviewInsert(vo);
							System.out.println("inserting...");
						}
					}

				}
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}return vo;
	}
}