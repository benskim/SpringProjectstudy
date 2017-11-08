package com.sist.newbookdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import org.springframework.stereotype.Repository;

import com.sist.main.dao.BookListVO;
import com.sist.mongo.BookRentVO;
import com.sist.mongo.ReviewVO;

import java.util.*;
@Repository
public class NewBooklistDAO implements bookooData{
	
	@Autowired
	private MongoTemplate mt;
	
	public List<NewBooklistVO> newbookAllData(int page){
		
		List<NewBooklistVO> list=new ArrayList<NewBooklistVO>();
		
		int rowSize=12;
		int skip=(rowSize*page)-(rowSize);				
		BasicQuery query=new BasicQuery("{\"pdate\":{$gt:\"2017-07-01\"}}");//BasicQuery는 몽고디비 에서 사용하는 쿼리문
		query.skip(skip).limit(rowSize);
		query.with(new Sort(Sort.Direction.DESC,"pdate"));	//그냥 Query는 라이브러리 같이 자바에서 쿼리르 보내는것
		
		return mt.find(query, NewBooklistVO.class, "booklist");
		
	}
	
	public int NewsTotalPage(){
		BasicQuery query=new BasicQuery("{\"pdate\":{$gt:\"2017-07-01\"}}");
		return (int)Math.ceil(mt.count(query,"booklist")/12.0);
	}
	
	public BookListVO bookDetailData(double isbn){
		
		BasicQuery query = new BasicQuery("{isbn:"+isbn+"}");
		
		BookListVO vo = mt.findOne(query, BookListVO.class,"booklist");
		
		
		return vo;
	}
	
	
	public ReviewVO reviewGraphData(double isbn){
		
			BasicQuery query = new BasicQuery("{isbn:"+isbn+"}");
		
			ReviewVO vo = mt.findOne(query, ReviewVO.class,"Review");
		
		
		return vo;
		
	}
	
	public BookRentVO detailRandomBook(double isbn){
		
		BasicQuery query = new BasicQuery("{isbn13:"+isbn+"}");
		
		
		
		//북리스트의 isbn을 이용하여 북렌트에서 카테고리를 가지고 온다.
		
		return mt.findOne(query, BookRentVO.class, "bookRent");
		
	}
	
	
	public List<BookListVO> RandomBookDetail(int category){
		
		//카테고리를 가지고 북렌트에서 연관도서를가지고 온다.
		
		int totalCount = 100000;
		int skipsize = (int) Math.floor(Math.random()*totalCount);
		List<BookListVO> list = new ArrayList<BookListVO>();
		
		//System.out.println(skipsize);
		
		BasicQuery query = new BasicQuery("{category:"+category+"}");
		
		query=(BasicQuery) query.skip(skipsize).limit(10);
		
		List<BookRentVO> rlist = mt.find(query, BookRentVO.class,"bookRent");
		int i = 0;
		
		
		for(BookRentVO rrvo: rlist){//10
			while(i<3){
				BookListVO rvo = detailRandomBimg(rrvo.getIsbn13());
				if(rvo!=null){
					list.add(rvo);
					i++;
				}
				break;
			}
		}
		
		for(BookListVO rrvo: list){
			System.out.println(rrvo.getIsbn());
		}
		System.out.println(list.size());
		System.out.println(list);
		return list;
		//return mt.find(query, BookRentVO.class,"booRent");
	}
	
	public BookListVO detailRandomBimg(double isbn){
		
		//그 연관도서의 isbn을 가지고 이미지를 가지고온다.
		
		BasicQuery query = new BasicQuery("{isbn:"+isbn+"}");
		
		
		return mt.findOne(query, BookListVO.class,"booklist");
		
	}


	
}
