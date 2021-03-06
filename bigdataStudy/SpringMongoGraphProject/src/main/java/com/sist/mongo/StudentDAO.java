package com.sist.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	@Autowired
	private MongoTemplate mt;
	
	public void stdInsert(StudentVO vo){
		try {
			int max =0;
			Query query = new Query();
			List<StudentVO> list = mt.find(query, StudentVO.class,"student");
			for(StudentVO svo : list){
				if(max<svo.getHakbun()) max=svo.getHakbun();
			}
			vo.setHakbun(max+1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		vo.setTotal((vo.getKor()+vo.getEng()+vo.getMath()+vo.getPhy()+vo.getHistory()+vo.getChem()));
		vo.setAvg(Math.round(vo.getTotal()/6.0));
		mt.insert(vo,"student");
	}
	public List<StudentVO> stdAllData(){
		Query query = new Query();
		return mt.find(query, StudentVO.class,"student");
	}
	
}
