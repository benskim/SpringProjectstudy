package com.sist.janre.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class JanreListDAO {
	@Autowired
	private MongoTemplate mt;
	
	public List<JanreListVO> BasicJanreList()
	{
		List<JanreListVO> list = new ArrayList<JanreListVO>();
		String find = "title";		// 콜렉션의 컬럼명
		String search = "종교";		// 검색할 단어
		
		Criteria criteria = new Criteria(find);
		criteria.regex(search);		
		
		MatchOperation match = Aggregation.match(criteria);
		LimitOperation lmt = Aggregation.limit(30);
		
		Aggregation exequery = Aggregation.newAggregation(match, lmt);
		
		AggregationResults<JanreListVO> result = mt.aggregate(exequery,"booklist", JanreListVO.class);
		
		list = result.getMappedResults();
				
		System.out.println("---Janre List---");
		for(JanreListVO vo : list)
		{
			System.out.println(vo.getTitle());
		}
		
		return list;
	}
	
	public List<RentVO> A_T_JanreList(String age, String theme)
	{
		List<RentVO> list = new ArrayList<RentVO>();
		
		int findage = Integer.parseInt(age);
		
		Criteria criteria = new Criteria("age");
		Criteria criteria2 = new Criteria("bookname");
		criteria.lt(findage);
		criteria2.regex(theme);
		
		MatchOperation amatch = Aggregation.match(criteria);
		MatchOperation tmatch = Aggregation.match(criteria2);
		LimitOperation lmt = Aggregation.limit(30);
		
		Aggregation exequery = Aggregation.newAggregation(amatch,tmatch, lmt);
		
		AggregationResults<RentVO> result = mt.aggregate(exequery,"bookRent", RentVO.class);
		
		list = result.getMappedResults();
				
		System.out.println("---A_T_Janre List---");
		for(RentVO vo : list)
		{
			System.out.println(vo.getBookname());
		}
		
		return list;
	}
	
	public List<RentVO> A_JanreList(String age)
	{
		List<RentVO> list = new ArrayList<RentVO>();
		
		
		Criteria criteria = new Criteria("age");
		criteria.lt(age);		
		
		MatchOperation match = Aggregation.match(criteria);
		LimitOperation lmt = Aggregation.limit(30);
		
		Aggregation exequery = Aggregation.newAggregation(match, lmt);
		
		AggregationResults<RentVO> result = mt.aggregate(exequery,"booklist", RentVO.class);
		
		list = result.getMappedResults();
				
		System.out.println("---ageJanre List---");
		for(RentVO vo : list)
		{
			System.out.println(vo.getBookname());
		}
		
		return list;
	}
	
	public List<RentVO> T_JanreList(String theme)
	{
		List<RentVO> list = new ArrayList<RentVO>();
				
		Criteria criteria = new Criteria("bookname");
		criteria.regex(theme);		
		
		MatchOperation match = Aggregation.match(criteria);
		LimitOperation lmt = Aggregation.limit(30);
		
		Aggregation exequery = Aggregation.newAggregation(match, lmt);
		
		AggregationResults<RentVO> result = mt.aggregate(exequery,"booklist", RentVO.class);
		
		list = result.getMappedResults();
				
		System.out.println("---ageJanre List---");
		for(RentVO vo : list)
		{
			System.out.println(vo.getBookname());
		}
		return list;
	}
}
