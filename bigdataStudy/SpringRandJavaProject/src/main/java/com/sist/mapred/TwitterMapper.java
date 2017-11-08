package com.sist.mapred;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;
import com.sist.mgr.RealFindData;

public class TwitterMapper extends Mapper<LongWritable, Text,Text,IntWritable>{
	//클래스안에 선언만하고 기능은 메소드로 구현-override!
	private final IntWritable one = new IntWritable(1);
	private Text result = new Text();
	private String[] data = new String[10];
	private Pattern[] p = new Pattern[10];
	private Matcher[] m = new Matcher[10];
/*
 
 */
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for(int i=0;i<10;i++){
			m[i]=p[i].matcher(value.toString());//1줄읽기
			while(m[i].find()){
				result.set(m[i].group());
				context.write(result, one);//누적
			}
		}
		
	}
	
	// 생성자 역할을 한다. - 메모리할당	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		RealFindData rd = new RealFindData();
		List<String> list = rd.daumFinddata();
		list.toArray(data);
		for(int i=0;i<10;i++){//지금 10개 생성하지만..이런식으로 만개만든다? 문제생김
			p[i]=Pattern.compile(data[i]);
		}
	}}
