package com.sist.mapperTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sist.main.dao.BookListVO;
import com.sist.mongo.ReviewVO;
import com.sist.newbookdao.NewBooklistVO;

@Component
public class emotionMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one = new IntWritable(1);
	
	private Text result = new  Text();
	
	/*String[] xml = {"application-context.xml","application-mongo.xml"};
	//클래스 관리자
	ApplicationContext app = new ClassPathXmlApplicationContext(xml);
	//FoodManager fm = (FoodManager)app.getBean("fm");
*/	@Autowired
	private MongoTemplate mt;

	public List<BookListVO> EmotionBookList(){
		
		Query query=new Query();
		List<BookListVO> Tlist=mt.find(query, BookListVO.class,"booklist");
		
		return Tlist;
	}
	
	
	public List<ReviewVO> EmotionReviewList(){
		
		Query query=new Query();
		List<ReviewVO> Rlist=mt.find(query, ReviewVO.class,"Review");
		
		return Rlist;
	}
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		if(key.get()>0){
			String[] columns = value.toString().split(",");
			
			if(columns!=null && columns.length>0){ //데이터가 있다면
				
				try{
					
					if(!columns[0].equals("")){
						//null이 아닐 때,
						result.set("자신감,"+columns[0]);
						
				
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[1].equals("")){
						//null이 아닐 때,
						result.set("감동,"+columns[1]);
						
						
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
					
					}
					if(!columns[2].equals("")){
						//null이 아닐 때,
						result.set("기쁨,"+columns[2]);
						
					
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[3].equals("")){
						//null이 아닐 때,
						result.set("안심,"+columns[3]);
						
						
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[4].equals("")){
						//null이 아닐 때,
						result.set("감사,"+columns[4]);
				
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[5].equals("")){
						//null이 아닐 때,
						result.set("신뢰,"+columns[5]);
						
				
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[6].equals("")){
						//null이 아닐 때,
						result.set("기대감,"+columns[6]);
						
					
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[7].equals("")){
						//null이 아닐 때,
						result.set("좋아함,"+columns[7]);
						
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
					if(!columns[8].equals("")){
						//null이 아닐 때,
						result.set("선의,"+columns[8]);
						
						
					
							//- 는일찍 왔다는 것이다.
							System.out.println(result+":"+one);
							
							context.write(result, one); //기록.
						
						
					}
				}catch(Exception e){
					
					System.out.println(e.getMessage());
					
				}
			}
		}
	}
}
