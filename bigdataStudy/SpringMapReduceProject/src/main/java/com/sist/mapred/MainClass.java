package com.sist.mapred;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	@Autowired
	private Configuration conf;
	public static void main(String[] args){
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MainClass mc =(MainClass)app.getBean("mainClass");
		try {
			FileSystem fs = FileSystem.get(mc.conf);
			if(fs.exists(new Path("./reply1"))){
				fs.delete(new Path("./reply1"),true);
			}
			fs.copyFromLocalFile(new Path("/home/sist/reply1"), new Path("./reply1"));
			System.out.println("Save end..");
			
			fs.copyToLocalFile(new Path("./reply1"), new Path("/home/sist/data/news"));
			System.out.println("Copy end..");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
