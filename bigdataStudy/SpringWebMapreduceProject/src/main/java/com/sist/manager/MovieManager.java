package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;

import java.util.*;


@Component
public class MovieManager {
	MovieDAO dao = new MovieDAO();
	public static void main(String[] args) {		
		MovieManager m = new MovieManager();
		m.dao.movieDrop();
		List<String> list = m.movieLinkData();
		int i=0;
		for(String s:list){
			
			m.movieDetailData(s,i);
			i++;
		}
		
		System.out.println("insert end");
	}

	public void movieDetailData(String link,int no){
		try {
			Document doc = Jsoup.connect("http://www.cgv.co.kr"+link).get();
			/*
			<div class="wrap-movie-detail" id="select_main">			    
			
			<div class="sect-base-movie">
			    <h3><strong>범죄도시</strong>기본정보</h3>
			 */
			Element title=doc.select("div.sect-base-movie h3 strong").first();
			Element poster=doc.select("div.box-image span.thumb-image img").first();
			Element director=doc.select("div.spec dl dd a").first();
			Element actor=doc.select("div.spec dl dd.on").get(0);//text사용하면 복수추출 가능
			int k=2;
//			if(no==1||no==4||no==5){
//				k=2;
//			}
			if(no==2||no==6){
				k=3;
			}
			Element genre=doc.select("div.spec dl dt").get(k);//3th
			Element grade=doc.select("div.spec dl dd.on").get(1);//2nd
			Element reserve=doc.select("div.score strong.percent span").first();
			
			System.out.println("===================================");
			System.out.println(title.text());//element.text()
			System.out.println(poster.attr("src"));
			System.out.println(director.text());
			System.out.println(actor.text());
			System.out.println(genre.text());
			System.out.println(grade.text());
			System.out.println(reserve.text());
			
			MovieVO vo = new MovieVO(); 
			vo.setMno(no);
			vo.setTitle(title.text());
			vo.setPoster(poster.attr("src"));
			vo.setDirector(director.text());
			vo.setActor(actor.text());
			vo.setGenre(genre.text().substring(genre.text().indexOf(":")+1).trim());
			vo.setGrade(grade.text().substring(0,grade.text().indexOf(",")));
			vo.setReserve(reserve.text().substring(0, reserve.text().lastIndexOf("%")));
			dao.movieInsert(vo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	  <div class="box-image" >
	                        <strong class="rank">No.1</strong>	
	                        <a href="/movies/detail-view/?midx=79960">
	 */
	public List<String> movieLinkData(){
		List<String> list =new ArrayList<String>();
		try {
			Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
			Elements link = doc.select("div.box-contents a");
			int j =0;
			for(int i=0;i<link.size();i++){
				System.out.println(link.get(j).attr("href"));
				list.add(link.get(j).attr("href"));
				j+=2;
				if(j>=14){
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	

}
