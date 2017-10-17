package com.sist.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class NewsDAO {
   @Autowired
   private MongoTemplate mt;
   //insert, drop, find(select) 모두 mt내장함수다
   public void newsInsert(NewsVO vo)
   {
	   mt.insert(vo, "news");
   }
   public void newsDrop()
   {
	   mt.dropCollection("news");
   }
   public List<NewsVO> newsAllData(int page)
   {
	   List<NewsVO> list=new ArrayList<NewsVO>();
	   try
	   {
		   Query query=new Query();
		   int rowSize=10;
		   int skip=(rowSize*page)-rowSize;
		   query=query.skip(skip).limit(rowSize);
		   /*skip 자르기 limit 가져오기
		    *   0~9 1page
		    *   10~19 2page
		    *     ===
		    *     
		    */
		   list=mt.find(query, NewsVO.class,"news");//news table, result는 newsVO
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
}




