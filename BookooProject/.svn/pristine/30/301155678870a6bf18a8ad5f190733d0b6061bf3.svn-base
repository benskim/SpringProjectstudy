package com.sist.recomend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sist.main.dao.BookListVO;
import com.sist.mongo.BookRentVO;
import com.sist.rankdao.RankVO;

@Repository
public class RecomendDAO {
	@Autowired
	private MongoTemplate mt;
	public List<ThemaVO> recomendByThema(int thema){
		List<ThemaVO> list=new ArrayList<ThemaVO>();
		BasicQuery query=new BasicQuery("{\"tnum2\":"+thema+"}");
		list=mt.find(query, ThemaVO.class,"themelist");
		System.out.println(list.size());
		return list;
	}
	
	public List<RankVO> bestBookInLoanRank(){
		List<RankVO> list=new ArrayList<RankVO>();
		Query query=new Query();
		query=query.limit(100);
		query.with(new Sort(Sort.Direction.DESC, "totloan_count"));
		list=mt.find(query, RankVO.class, "loanrank");
		return list;
	}
	
	public List<RecomendVO> bestBooks(){//대여 상위 100개 가져와서 그 제목으로 북리스트에서 정보 가져오기
		List<RankVO> list1=new ArrayList<RankVO>();
		List<RecomendVO> list=new ArrayList<RecomendVO>();
		list1=bestBookInLoanRank();	//대여 상위 100개 가져와 list1에 담음	
		for(RankVO vo:list1){
			String title=vo.getBookname();			
		}
		
		return list;
	}
	public BookListVO booklistByTitle(String title){
		BookListVO vo=new BookListVO();
		BasicQuery query=new BasicQuery("{\"title\":\""+title.trim()+"\"}");
		query.limit(1);
		vo=mt.findOne(query, BookListVO.class, "booklist");
		return vo;
	}
	public RankVO loanrankByTitle(String title){
		RankVO vo=new RankVO();
		BasicQuery query=new BasicQuery("{\"title\":\""+title.trim()+"\"}");
		query.limit(1);
		vo=mt.findOne(query, RankVO.class, "loanrank");
		return vo;
	}
	public BookRentVO bookrentByTitle(String title){
		BookRentVO vo=new BookRentVO();
		BasicQuery query=new BasicQuery("{\"title\":\""+title.trim()+"\"}");
		query.limit(1);
		vo=mt.findOne(query, BookRentVO.class, "bookRent");
		return vo;
	}
	
}
