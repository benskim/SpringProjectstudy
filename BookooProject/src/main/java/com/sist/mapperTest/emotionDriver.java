package com.sist.mapperTest;

import java.io.File;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

@Component
public class emotionDriver {
	public static void main(String[] args) {
		/*
		 * 라이브러리만 이용하는 것 독립모드
		 */
		
		try{
			File dir = new File("./output_test");
			if(dir.exists()){
				File[] files = dir.listFiles();
				for(File file:files){
					file.delete();
				}
				dir.delete();
				
			}
			
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf);
			
			job.setMapperClass(emotionMapper.class);
			job.setReducerClass(emotionReducer.class);
			job.setJarByClass(emotionDriver.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.addInputPath(job, new Path("./긍정.csv"));
			/*FileOutputFormat.setOutputPath(job, new Path("./output"));
			*/
			FileOutputFormat.setOutputPath(job, new Path("./output_test"));
			
			
			MultipleOutputs.addNamedOutput(job, "deptime", TextOutputFormat.class, Text.class, IntWritable.class);
			MultipleOutputs.addNamedOutput(job, "arrtime", TextOutputFormat.class, Text.class, IntWritable.class);
			
			job.waitForCompletion(true);
			
			rData();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void rData(){
		
		
		try{
		
			RConnection rc = new RConnection();
			rc.voidEval("arr<-read.table(\"/home/sist/bigdataDiv/bigdataStudy/BigdataExamProject2/output/arrtime-r-00000\")");
			rc.voidEval("dep<-read.table(\"/home/sist/bigdataDiv/bigdataStudy/BigdataExamProject2/output/deptime-r-00000\")");
			rc.voidEval("data<-merge(arr,dep,by=\"V1\")");
			REXP p = rc.eval("data$V1"); //실행된 데이터를 읽어올떄 사용.
			String[] year = p.asStrings(); //그래프를 그리는 것이 아닌 데이터를 가지고 있다.
			
			p=rc.eval("data$V2.x");
			int[] arr = p.asIntegers();
			
			p=rc.eval("data$V2.y");
			int[] dep = p.asIntegers();
			
			rc.close();
			
			for(int i=0; i<year.length; i++){
				System.out.println(year[i]+" "+arr[i]+" "+dep[i]);
				System.out.println(year[i]+" "+(arr[i]+dep[i]));
				
			}
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
