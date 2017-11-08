package com.sist.manager;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import scala.collection.script.End;

import com.sist.book.BookDAO;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;

public class BookIsbn {
//	private BookDAO dao=new BookDAO();
	public static void main(String[] args) {
		BookIsbn nm = new BookIsbn();
		
//		nm.dao.bookDrop();
		nm.bookData();
//		System.out.println("insert end..");
			
	}
	
	public void bookData(){
		List<String> list = new ArrayList<String>();
		try {
			CSVReader cr = new CSVReader(new FileReader("/home/sist/csv_data/distinct_book.csv"));
//			List<String[]> lists =cr.readAll();
			List<String[]> lists =cr.readAll();
			//db.bookRent.count() : 3,804,000 
			//db.bookRent_copy.distinct("isbn13") : 183,612
			//bestseller 추가했을 경우?  3,806,350  && 183,729 (겹치는 책 많음)
			//이제 내가 csv파일만 넘겨주면 너는 기본테이블에 넣기만 하면 됨.
			//!!!
			if(lists.isEmpty()){
				System.out.println("no data");	
			}
			String data = "";
			for(String[] ss :lists){
				if (ss.length<2){
					for (String s :ss) {
						 String url = "http://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="+ s;
				       Document doc = Jsoup.connect(url).get();
//				       Elements link = doc.select("div#content div.no_result");


						Element noReslut = doc.select("div#content > div.no_result").first();
						if(noReslut != null){
						    System.out.println(s);
						    data += s+","+"\n";
//						     list.add(s);
						}

					}
				}
			}
			cr.close();
//			System.out.println(list.size()+": filtering End...");
			
			FileWriter fw = new FileWriter("/home/sist/csv_data/bookIsbn.csv");
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

//	public void makeCsv(){
//		try {
//			CSVWriter cw = new CSVWriter(new FileWriter("/home/sist/csv_data/total.csv"));
//			List<String[]> list = new ArrayList<String[]>();
//			
//			while(rs.next()){
////				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
////						+rs.getString(3));
//				String[] ss = {
//						String.valueOf(rs.getInt(1)),
//						rs.getString(2),
//						rs.getString(3),
//						rs.getDate(4).toString(),
//						String.valueOf(rs.getInt(5)),
//						String.valueOf(rs.getInt(6))
//				};
//				list.add(ss);
//			}
//			cw.writeAll(list);
//			cw.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	

	
}