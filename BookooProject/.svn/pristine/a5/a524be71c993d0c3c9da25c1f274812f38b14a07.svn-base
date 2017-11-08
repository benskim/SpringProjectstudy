package com.sist.main.news.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class NewsDAO {
	@Autowired
	private MongoTemplate mt;	//application-mongo.xml에서 설정해준거랑 같아야 함
	
	public void newsInsert(NewsVO vo)
	{
		vo.setTitle(vo.getTitle());
		vo.setLink(vo.getLink());
		vo.setDescription(vo.getDescription());
		mt.insert(vo, "booknews");
	}
	
	public void newsDrop()
	{
		//mt.dropCollection("booknews");
	}
	
	
	public List<NewsVO> newsAllData(int page)
	{
		int rowSize=5;
		int skip = (rowSize*page) - rowSize;
			
		SkipOperation skp = Aggregation.skip(skip);
		LimitOperation lmt = Aggregation.limit(rowSize);
		
		Aggregation exequery = Aggregation.newAggregation(skp,lmt);
		
		AggregationResults<NewsVO> result = mt.aggregate(exequery, "booknews", NewsVO.class);
		List<NewsVO> dataresult = result.getMappedResults();
		for(NewsVO vo : dataresult)
		{
			System.out.println(vo.getTitle());
		}
		return dataresult;
	}
	
	
}
