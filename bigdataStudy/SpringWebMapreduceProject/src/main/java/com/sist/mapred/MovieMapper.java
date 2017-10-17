package com.sist.mapred;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/*
 * 1. read a book
 * 2. write a book => LongWritable Text
 */
public class MovieMapper extends Mapper<LongWritable,	Text, Text, IntWritable>{
	private final IntWritable one = new IntWritable(1);
//	mapper -> shuffle(sort,bind) -> Reducer
	private Text res=new Text();
	private String[] feel = {"사랑","로맨스","매력","즐[가-깋]","스릴",
			"소름","긴장","공포","유머","웃[가-잏]","개그","호감","비호감",
			"행복","전율","경이","우울","절망","신비","극혐","호응","혹평","호평",
			"여운","희망","긴박","감동","감성","휴머니즘","실망","유쾌","통쾌","심쿵","신선",
			"자극","재미","액션","반전","비극","미스[타-팋]리","짜릿","박력","입덕",
			"판타지","꿈","설레[다-힣]","흥미","일상","소심","기[빠-삫]",
			"순수","힐링","눈물","그리[아-잏]","호러","충격","잔혹","섹시","유혹","치유",
			"후회","감사","지루","멜로","애정","화려","지루","킬링","꿀잼","노잼","존잼",
			"미운","모험","슬[파-핗]","느와르","다큐","잔인","웃기","자랑","어마무시","억울",
			"코미디","친근","애니","아깝","짜증","짠[하-힣]"
	};
	
	private Pattern[] p=new Pattern[feel.length];
	private Matcher[] m = new Matcher[feel.length];
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
	   for(int i=0;i<p.length;i++){
		   p[i]=Pattern.compile(feel[i]);
	   }
	   for(int i=0;i<m.length;i++){
		   m[i]=p[i].matcher(value.toString());
		   while(m[i].find()){
			   res.set(m[i].group());//group : "즐[가-힣]"에 해당하는 모든 단어를 그룹지정함.
			   context.write(res, one);
		   }
	   }		
	}
	
}
