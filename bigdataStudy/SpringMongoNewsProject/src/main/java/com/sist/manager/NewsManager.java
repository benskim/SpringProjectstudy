package com.sist.manager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sist.mongo.*;
import java.net.*;
import java.util.List;
/*
 *    1. 데이터수집 : naver => news
 *    2. 데이터저장 : mongo,file(*****)
 *    3. 데이터분석 : mapreduce,spark
 *    4. 시각화 : r
 */
@Component
public class NewsManager {
	 @Autowired
    private NewsDAO dao;
	 public void newsData(String data)
	 {
		 try
		 {
			 JAXBContext jc=JAXBContext.newInstance(Rss.class);
			 String strUrl="http://newssearch.naver.com/"
					        +"search.naver?where=rss&query="
					        +URLEncoder.encode(data,"UTF-8");
			 URL url=new URL(strUrl);
			 Unmarshaller un=jc.createUnmarshaller();
			 Rss rss=(Rss)un.unmarshal(url);
			 List<Item> list=rss.getChannel().getItem();
			 for(Item i:list)
			 {
				 NewsVO vo=new NewsVO();
				 vo.setTitle(i.getTitle());
				 vo.setLink(i.getLink());
				 vo.setDescription(i.getDescription());
				 dao.newsInsert(vo);
			 }
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
	 }
}






