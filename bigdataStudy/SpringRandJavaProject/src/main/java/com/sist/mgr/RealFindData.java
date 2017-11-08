package com.sist.mgr;

import java.util.*;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
@Component
public class RealFindData {

	public static void main(String[] args) {
		RealFindData rfd = new RealFindData();
		rfd.daumFinddata();
		

	}
	public List<String> daumFinddata(){
		List<String> list = new ArrayList<String>();
		try {
//			<div class="rank_cont">
//			<span class="num_pctop rank1"><span class="ir_wa">1위</span></span>
//			<span class="txt_issue"><a href="https://search.daum.net/search?w=tot&amp;q=%EC%A0%95%ED%95%98%EB%82%98&amp;DA=ATG&amp;rtmaxcoll=1TH" class="link_issue">정하나</a></span>
//			</div>
			Document doc = Jsoup.connect("http://www.daum.net").get();
			Elements elem = doc.select("div.realtime_part div.rank_cont span.txt_issue a");
			int j=0;
			for(int i=0;i<elem.size();i++){
				Element e =elem.get(j);
				list.add(e.text());
				j+=2;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
