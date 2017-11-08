package com.sist.rankdao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sist.main.dao.BookListVO;
import com.sist.mongo.BookRankVO;
import com.sist.mongo.BookRentVO;
//랭크 테이블 만들기
@Repository
public class RankDAO {
	@Resource(name="mt")
	private MongoTemplate mt;	
	public void MakeBookRank(int cate){
		List<BookRentVO> list=new ArrayList<BookRentVO>();
		BasicQuery query=new BasicQuery("{category:"+cate+"}");
		
		list=mt.find(query,BookRentVO.class,"bookRent");
		for(BookRentVO vo:list){
			//int loeancount=vo.getLoan_count();
			//System.out.println(loeancount);
			System.out.println(vo.getBookname());
		}		
	}
	public List<String> rentbookDistinct(int category){
		/*Criteria criteria = new Criteria();
		criteria.where("category").is(category);
		Query query=new Query();
		query.addCriteria(criteria);*/
		BasicQuery query=new BasicQuery("{category:"+category+"}");
		List<String> list = mt.getCollection("bookRent").distinct("bookname",query.getQueryObject());
		return list;
	}
	public double oneBookLoanTotal(int category,String bookname){
		double loansum=0.0;
		BasicQuery query=new BasicQuery("{bookname:\""+bookname+"\"}");
		List<BookRentVO> list=new ArrayList<BookRentVO>();
		list=mt.find(query, BookRentVO.class,"bookRent");
		for(BookRentVO vo:list){
			loansum+=vo.getLoan_count();
		}
		return loansum;
	}
	public void makeBookRanktable(){
		int category;
		BookRankVO vo=new BookRankVO();
		for(category=1;category<=9;category++){
			List<String> list=new ArrayList<String>();
			list=rentbookDistinct(category);
			//System.out.println("start");
			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i));
				double totloan_count=oneBookLoanTotal(category, list.get(i));
				System.out.println(category+"||"+list.get(i)+"||"+totloan_count);
				if(totloan_count>4000){
					vo.setCategory(category);
					vo.setBookname(list.get(i).replaceAll("\"", ""));
					vo.setTotloan_count(totloan_count);
					mt.insert(vo,"loanrank");
				}
			}	
		}
	}
	//db.getCollection('loanrank').find({"category":1}).sort({"totloan_count":-1}).limit(5)
	public List<RankVO> bestByCategory(int category){
		List<RankVO> list=new ArrayList<RankVO>();
		Criteria c=new Criteria("category");
		c.is(category);
		Query query=new Query(c);
		//BasicQuery query=new BasicQuery("{\"category\":"+category+"}.sort({\"totloan_count\":-1}).limit(5)");//BasicQuery는 몽고디비 에서 사용하는 쿼리문
		query=query.limit(10);
		query.with(new Sort(Sort.Direction.DESC, "totloan_count"));
		//query.with(new Sort(Sort.Direction.DESC,"totloan_count"));	//그냥 Query는 라이브러리 같이 자바에서 쿼리르 보내는것		
		list=mt.find(query, RankVO.class, "loanrank");
		/*for(RankVO vo:list)
		{
			System.out.println(vo.getBookname());
		}*/
		return list;
	}
	public List<BookListVO> bestBooks(){
		List<RankVO> list1=new ArrayList<RankVO>();
		List<BookListVO> list=new ArrayList<BookListVO>();
		
		for(int category=1;category<=9;category++){
		list1=bestByCategory(category);		
			System.out.println("=================================================================");
			System.out.println(category+"<=카테고리별가져온횟수 : "+list1.size());//카테고리별 상위 5개책 가져옴
			//System.out.println("list1"+list1);
			for(RankVO vo:list1){
				//System.out.println("카테고리별가저온 책제목"+vo.getBookname().trim());
				BasicQuery query=new BasicQuery("{\"title\":\""+vo.getBookname().trim()+"\"}");
				//List<BookRentVO> list2=mt.getCollection("bookRent").distinct("bookname",query.getQueryObject());	
				//mt.getCollection("bookRent").distinct("bookname",query.getQueryObject());
				//쿼리로 책제목 distinct 해야함
				query.limit(1);
				List<BookListVO> list2=mt.find(query, BookListVO.class,"booklist");
				
				for(BookListVO vo1:list2){
					System.out.println(vo1.getTitle());
					list.add(vo1);				
				}
				//vo1=mt.find(query, BookRentVO.class, "bookRent");
				
				/*List<BookRentVO> list2=mt.find(query, BookRentVO.class,"bookRent");
				System.out.println("리스트2사이즈"+list2.size());
				for(BookRentVO v:list2)
				{
					list.add(v);
					//System.out.println(v.getBookname());
				}*/
			}
		}
		return list;
	}
}
