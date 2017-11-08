package com.sist.mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TwitterReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable res = new IntWritable();
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum=0;
		for(IntWritable i :value){
			sum+=i.get();
		}
		res.set(sum);
		//R에서 공백처리하기 위해서 ""로 감싸야
		String str = "\""+key.toString()+"\"";
		key.set(str);				
		context.write(key,res);
	}
	
}
