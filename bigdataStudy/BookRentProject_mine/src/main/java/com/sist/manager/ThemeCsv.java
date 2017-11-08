package com.sist.manager;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.book.BookDAO;

import au.com.bytecode.opencsv.CSVReader;

public class ThemeCsv {
	static BookDAO dao = new BookDAO();

	public static void main(String[] args) {
		ThemeCsv b = new ThemeCsv();
		try {
//			dao.bookDrop();
//			CSVReader cr = new CSVReader(new FileReader("/home/sist/csv_data/distinct_book2.csv"));
//			List<String[]> lists = cr.readAll();
			String[] isbnOfTheme = {
					"9791158790721",
					"9788956608846",
					"9788954640756",
					"9788990514400",
					"9788991239449",
					"9788927804789",
					"9788995501474",
					"9788901074603",
					"9788986836240",
					"9788956601373",
					"9788931001143" ,		//같은 책인데 서로 다르다
//					"9788930705981" ,
//					"9788963651224" ,	
//					"9788959130443"   ,		//뒤에 4자리만 다르다	
					"9788959130030"   ,
//					"9788959135103"   ,
//					"9788959130450"    
			};
			
			
			for (String isbn : isbnOfTheme) {
				String url = "http://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="
						+ isbn;
				Document doc = Jsoup.connect(url).get();
				Element book = doc.select("ul.basic li div div a").first();
				//도서 상세페이지 링크
				String link = book.attr("href");
				//도서 리뷰페이지 링크
				List<String> rlist = b.BookReviewLinkData(link);							
				
				//리뷰블로그 링크
				String vo ="";
				for (String rlink : rlist) {
					vo = b.BookReviewData(rlink);								
				}
				FileWriter fw = new FileWriter("/home/sist/theme/"+isbn+".txt");
				fw.write(vo);
				fw.close();				
			}
				
				
			}catch(Exception e)	{
				System.out.println(e.getMessage());
			}

		}
//책검색하고 상세페이지 링크 가져오기
	public String BookGetcodeData(String isbn) {
		String link = "";
		try {
			String url = "http://http://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="
					+ isbn;
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
				// System.out.println(rlink.get(i).attr("href"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rlist;
	}

	// 블로그 내용 가져오기
	public String BookReviewData(String rlink) {
		String vo = "";
		try {
			for (int p = 1; p < 80; p++) {
				Document doc = Jsoup.connect("http://book.naver.com" + rlink + "&page=" + p).get();
				for (int i = 1; i < 11; i++) {
					Elements txt = doc.select("dd#review_text_" + i);
					System.out.println("블로그 내용 : " + txt.text());
					System.out.println();
					if(txt.text() != null){
						vo += txt.text() +"\n";	
					}
					
				}
			}
			

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return vo;
	}
}