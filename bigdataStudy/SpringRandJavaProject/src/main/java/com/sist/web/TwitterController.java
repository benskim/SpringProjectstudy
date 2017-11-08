package com.sist.web;

import java.util.*;
import com.sist.mgr.*;
import com.sist.r.RManager;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Controller;
/*  구조이해	  
 * web.xml : Controller
 *  -> application-context : 클래스 관계도
 *  -> @Controller 클래스 접근: 모델
	1)naver data
	2)twitter data,flume
	 hadoop : file 삭제후 올리기
	3)mapreduce,spark
	 mapred : jr.call()
	 hadoop : file 복사(part-r-0000)
 	*전자는 파일저장후 작업, 후자는 한줄씩 읽고 작업	
	4)mongodb,hive
	5)r,d3
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TwitterController {
	@Autowired
	private Configuration conf;
	@Autowired
	private JobRunner jr;
	@Autowired
	private RManager rm;
	@RequestMapping("main/main.do")
	public String main_main(){
		execute();
		hadoopDelete();
		copyFromLocal();
		execute();
		copyToLocal();
		rm.twitterView();
		return "main/main";
	}
	public void copyFromLocal(){
		try {
			FileSystem fs=FileSystem.get(conf);
			fs.copyFromLocalFile(
					new Path("/home/sist/bigdataDev/bigdataStudy/SpringRandJavaProject/app.log"), 
					new Path("/tween/app2.log"));//local to fs
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void copyToLocal(){
		try {
			FileSystem fs=FileSystem.get(conf);
			fs.copyToLocalFile(
					new Path("/output/part-r-00000"), 
					new Path("/home/sist/csv_data/twitter_result.txt"));//fs(output) to folder
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void hadoopDelete(){
		try {
			
			FileSystem fs = FileSystem.get(conf);
			if(fs.exists(new Path("/tween/app2.log"))){
				fs.delete(new Path("/tween/app2.log"),true);
			}
			if(fs.exists(new Path("/output"))){
				fs.delete(new Path("/output"),true);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void execute(){//맵리듀스 실행
		try {
			jr.call();
			System.out.println("execute call");
		} catch (Exception e) {
			
		}
	}
}
