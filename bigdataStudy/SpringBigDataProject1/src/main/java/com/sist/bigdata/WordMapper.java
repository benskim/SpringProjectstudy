package com.sist.bigdata;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/*
 * 	1 , Hello Java Hello Java Hello
 *
 * 	  Mapping        Shuffling       Reducing
 *  
 * 	  Hello 1
 *   Java 1
 *   Hello 1  ==>  Hello [1,1,1] ==> Hello 3
 *   Java 1   ==>  Java [1,1]    ==> Java 2
 *   Hello 1
 *   
 *   	WordMapper w;
 *   	WordMapper w1; 	w+w1
 */
import java.util.*;
public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final IntWritable one=new IntWritable(1);
	private Text res=new Text();
	// Text ==> String (toString())
	// String ==> Text (set())
	// IntWritable (get())==> int , int set()=> IntWritable
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		StringTokenizer st=new StringTokenizer(value.toString());
		while(st.hasMoreTokens())
		{
			res.set(st.nextToken());
			context.write(res, one);
			
		}
	}
}
