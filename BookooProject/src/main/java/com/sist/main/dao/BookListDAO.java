package com.sist.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;

import java.util.*;

@Repository()
public class BookListDAO {
	@Autowired
	private MongoTemplate mt;
	
	
	public List<BookListVO> mainlist()
	{
		//BasicQuery query = new BasicQuery("");
		//query.with(new Sort(Sort.Direction.DESC,"pdate")).limit(5);

		SortOperation sort = Aggregation.sort(Sort.Direction.DESC,"pdate");
		LimitOperation lm = Aggregation.limit(4);
		//SkipOperation skp = Aggregation.skip(4); 4개 밖에 안가져왔는데 4개 스킵하라고 하니까 값이 없지 멍충아	

		
		Aggregation exequery = Aggregation.newAggregation(sort,lm);
		
		AggregationResults<BookListVO> result = mt.aggregate(exequery, "booklist", BookListVO.class);
		
		List<BookListVO> dataresult = result.getMappedResults();
		
		System.out.println("--1p_list--");
		int a=1;
		for(BookListVO vo : dataresult)
		{
			System.out.println(a+". "+vo.getTitle());
			a++;
		}
		System.out.println("-----------");
		return dataresult;
	}

	public List<BookListVO> mainlist2()
	{
		SortOperation sort2p = Aggregation.sort(Sort.Direction.DESC,"pdate");
		LimitOperation lm2p = Aggregation.limit(8);
		SkipOperation sk2p = Aggregation.skip(4);
		
		Aggregation exequery2 = Aggregation.newAggregation(sort2p, lm2p, sk2p);
		
		AggregationResults<BookListVO> result2 = mt.aggregate(exequery2, "booklist", BookListVO.class);
		
		List<BookListVO> dataresult2 = result2.getMappedResults();
		
		System.out.println("--2p_list--");
		int a=1;
		for(BookListVO vo : dataresult2)
		{
			System.out.println(a+". "+vo.getTitle());
			a++;
		}
		System.out.println("-----------");
		
		return dataresult2;
	}
	
	public List<BookListVO> mainlist3()
	{
		SortOperation sort3p = Aggregation.sort(Sort.Direction.DESC,"pdate");
		LimitOperation lm3p = Aggregation.limit(12);
		SkipOperation sk3p = Aggregation.skip(8);
		
		Aggregation exequery3 = Aggregation.newAggregation(sort3p, lm3p, sk3p);
		
		AggregationResults<BookListVO> result3 = mt.aggregate(exequery3, "booklist", BookListVO.class);
		
		List<BookListVO> dataresult3 = result3.getMappedResults();
		
		System.out.println("--3p_list--");
		int a=1;
		for(BookListVO vo : dataresult3)
		{
			System.out.println(a+". "+vo.getTitle());
			a++;
		}
		System.out.println("-----------");
		
		return dataresult3;
	}
	
	
	public List<BookListVO> bookSearch(String searchWord, int page) {
        // db.getCollection('booklist').find({title:{"$regex":"철학"}})
       
        int rowSize=12;
        int skip=(rowSize*page)-(rowSize);
       
        searchWord = searchWord.substring(0, searchWord.lastIndexOf(",")).trim();
       
        System.out.println("검색어 : "+searchWord);
       
        BasicQuery query = new BasicQuery("{title:{$regex:'"+searchWord+"'}}");
        query.skip(skip).limit(rowSize);
       
       
        return mt.find(query, BookListVO.class, "booklist");
       
    } 
	
	public List<BookListVO> assistJanre(String theme)
	{
		List<BookListVO> list = new ArrayList<BookListVO>();
		String find = "title";		// 콜렉션의 컬럼명
		String search = "";
		if(theme==null)
		{
			search="종교";
		}
		else{
		search = theme;		// 검색할 단어
		}
		
		Criteria criteria = new Criteria(find);
		criteria.regex(search);		
		
		MatchOperation match = Aggregation.match(criteria);
		LimitOperation lmt = Aggregation.limit(30);
		
		Aggregation exequery = Aggregation.newAggregation(match, lmt);
		
		AggregationResults<BookListVO> result = mt.aggregate(exequery,"booklist", BookListVO.class);
		
		list = result.getMappedResults();
				
		System.out.println("---Janre IMG src list---");
		for(BookListVO vo : list)
		{
			System.out.println(vo.getBimg());
		}
		return list;
	}
}
