package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sist.mgr.MusicVO;
import java.util.*;
@Repository
public class MusicDAO {
	@Autowired
	private MongoTemplate mt;
	public void musicInsert(MusicVO vo){
		mt.insert(vo, "music");
	}
	public List<MusicVO> musicTop50(int page){
		Query query=new Query();
		int rowSize=10;
		int skip=(page*rowSize)-rowSize;
		query=query.skip(skip).limit(rowSize);
		query.with(new Sort(Sort.Direction.ASC, "rank"));
		return mt.find(query, MusicVO.class,"music");
	}
	public MusicVO musicDetail(int rank){
		/*Criteria c=new Criteria("rank");
		c.is(rank);
		Query query=new Query(c);*/
		// where rank=1 rank>2 {rank: {"$gt",2}}
		BasicQuery query=new BasicQuery("{rank:"+rank+"}");
		return mt.findOne(query, MusicVO.class,"music");
	}
	/*
	 *  int a=(int)10L;
	 *   double d =123456.78;
	 *    int a=123456;
	 *    	int r=(int)((d-a)*100); ==>77
	 *    	7 7 9999999 (반올림)=> 부동소숫점
	 */
	public int musicTotalPage(){
		Query query=new Query();
		return (int)mt.count(query, Integer.class,"music");
	}
}
