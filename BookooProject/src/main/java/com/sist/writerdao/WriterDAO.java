package com.sist.writerdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class WriterDAO {
	@Autowired	
	private MongoTemplate mt;
		

	public void writerInsert(WriterVO vo){

		/*mt.dropCollection("writer_top100");
		mt.dropCollection("writerlist_top300");*/
		mt.insert(vo,"writer_acc_top100");
		

	}
	
	
	public List<WriterVO> writerAllData(){
		Query query = new Query();

		return mt.find(query, WriterVO.class,"writer_acc_top100");

	}

	
	public void writerWeekInsert(WriterWeekVO wvo){
		mt.insert(wvo,"writer_week_top100");
	}
	
	public List<WriterWeekVO> writerWeekAllData(){
		Query query = new Query();

		return mt.find(query, WriterWeekVO.class,"writer_week_top100");

	}

}
