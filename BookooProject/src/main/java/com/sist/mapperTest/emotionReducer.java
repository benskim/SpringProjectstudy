package com.sist.mapperTest;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.springframework.stereotype.Component;

@Component
public class emotionReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	private MultipleOutputs<Text, IntWritable> mos; //파일이 여러개
	private Text outputKey = new Text();
	private IntWritable res = new IntWritable();
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		mos.close(); //메모리 해제
	}
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String[] columns = key.toString().split(",");//,로 자른다.
		outputKey.set(columns[1]+","+columns[2]); //0번은 A, D이기에 제외, 몇년도 몇월인지만 저장하려고 한다.
		if(columns[0].equals("A")){
			int sum = 0; 
			for(IntWritable i:values ){
				//누적
				sum+=i.get();
				
			}
			res.set(sum);
						//파일명
			mos.write("arrtime", outputKey, res);
		}else{
			
			int sum = 0; 
			for(IntWritable i:values ){
				//누적
				sum+=i.get();
				
			}
			res.set(sum);
						//파일명
			mos.write("deptime", outputKey, res);
			
			
		}
	}
	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		mos = new MultipleOutputs<Text, IntWritable >(context);
	}
	
	

}
