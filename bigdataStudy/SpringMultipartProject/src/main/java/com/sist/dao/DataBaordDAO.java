package com.sist.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
// DAO+Service
/*
 *   List<String> list=new ArrayList();
 *    list.add(1);  ==> add(String s)
 *    list.add("aaa")
 *    list.add(vo);
 *    list.add(10.5)
 *    list.add("bb")
 *    
 *    interface I
 *    class A implements I
 *    
 *    A a=new A()
 *    I i=new A()
 *    
 *    
 */
@Repository
public class DataBaordDAO implements DataBoard{
   @Autowired
    private MongoTemplate mt;
	@Override
	public List<BoardVO> boardAllData(int page) {
		
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC,"no"));
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		query=query.skip(skip).limit(rowSize);
		List<BoardVO> list=mt.find(query, BoardVO.class,"databoard");
		/*
		 *   class A<T>
		 *   {
		 *       T t;
		 *      public T getT(T t)
		 *      {
		 *         return t;
		 *      }
		 *   }
		 *   
		 *   A<String>
		 */
		return list;
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		int max=0;
		Query query=new Query();
		List<BoardVO> list=mt.find(query,BoardVO.class,"databoard");
		for(BoardVO dvo:list)
		{
			if(max<dvo.getNo())
				max=dvo.getNo();
		}
		vo.setNo(max+1);
		mt.insert(vo,"databoard");
	}

	@Override
	public int boardTotal() {
		// TODO Auto-generated method stub
		Query query=new Query();
		int count=(int)mt.count(query,"databoard");
		// 11 => 2  11/10 ==> 1.1 => 2
		return (int)(Math.ceil(count/10.0));
	}

	@Override
	public BoardVO boardContent(int no) {
		BasicQuery query = new BasicQuery("{no"+no+"}");
		Update up =new Update();
		BoardVO vo = mt.findOne(query, BoardVO.class,"databoard");
		up.set("hit", vo.getHit()+1);
		mt.upsert(query, up, "databoard");
		return mt.findOne(query, BoardVO.class,"databoard");
	}

}









