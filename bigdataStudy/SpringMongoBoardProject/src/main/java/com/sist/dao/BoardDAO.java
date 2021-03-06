package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO {
   @Autowired
   private MongoTemplate mt;
   public void boardInsert(BoardVO vo)
   {
	   Query query=new Query();
	   List<BoardVO> list=mt.find(query, BoardVO.class,
			   "board");
	   int max=0;
	   for(BoardVO v:list)
	   {
		   if(max<v.getNo())
			   max=v.getNo();
	   }
	   vo.setNo(max+1);
	   mt.insert(vo,"board");
   }
   public List<BoardVO> boardAllData(int page)
   {
	   Query query=new Query();
	   int rowSize=10;
	   int skip=(rowSize*page)-rowSize;
	   query=query.skip(skip).limit(rowSize);
	   query.with(new Sort(Sort.Direction.DESC, "no"));
	   // rownum BETWEEN 1 AND 10
	   
	   return mt.find(query, BoardVO.class,"board");
   }
   public int boardTotalPage()
   {
	   Query query=new Query();
	   // mt.count() ==> select count(*) from board
	   return (int)(Math.ceil(mt.count(query,"board")/10.0));
   }
   public BoardVO boardContent(int no)
   {
	   // {no:1}  $gt  > {no:{"$gt":10}}
	   // {content:{"$regex:.*"+"값"} like
	    /*
	     *    비교연산자 = < > <= >= !
	     *    like
	     *    in
	     */
	   
	   BasicQuery query=new BasicQuery("{no:"+no+"}");
	   BoardVO vo=mt.findOne(query, BoardVO.class,"board");
	   Update u=new Update();
	   u.set("hit", vo.getHit()+1);
	   mt.upsert(query, u, "board");
	   return mt.findOne(query, BoardVO.class,"board");
   }
   public BoardVO boardUpdate(int no)
   {
	   // {no:1}  $gt  > {no:{"$gt":10}}
	   // {content:{"$regex:.*"+"값"} like
	    /*
	     *    비교연산자 = < > <= >= !
	     *    like
	     *    in
	     */
	   
	   BasicQuery query=new BasicQuery("{no:"+no+"}");
	   
	   return mt.findOne(query, BoardVO.class,"board");
   }
   public boolean boardUpdateOk(BoardVO vo){
	   boolean bCheck=false;
	   BasicQuery query = new BasicQuery("{no:"+vo.getNo()+"}");
	   BoardVO db = mt.findOne(query, BoardVO.class,"board");
	   if(db.getPwd().equals(vo.getPwd())){
		   bCheck=true;
		   Update u = new Update();
		   u.set("name", vo.getName());
		   u.set("subject", vo.getSubject());
		   u.set("content", vo.getContent());
		   mt.upsert(query, u, "board");
	   }
	   return bCheck;
   }
   public List<BoardVO> boardFind(String fs,String ss){
	   BasicQuery query = new BasicQuery("{"+fs+":"+"{$regex:'.*"+ss+"'}}");
	   return mt.find(query, BoardVO.class,"board");
   }
}










