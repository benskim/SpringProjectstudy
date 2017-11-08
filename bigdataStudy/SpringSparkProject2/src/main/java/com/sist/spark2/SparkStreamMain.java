package com.sist.spark2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import twitter4j.Status;
import org.apache.spark.streaming.twitter.*;

import scala.Tuple2;
public class SparkStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try
        {
    	   Configuration c=new Configuration();
    	   c.set("fs.default.name", "hdfs://Namenode:9000");
    	   JobConf jc=new JobConf(c);
    	   /* String ss="^[A-Za-z]+";
    	    String sss="abc123abcfabc123 aaa bbb ccc";
    	    Pattern pp=Pattern.compile(ss);
    	    Matcher mm=pp.matcher(sss);
    	    while(mm.find())
    	    {
    	    	System.out.println(mm.group());
    	    }
    	    System.out.println(ss);*/
        	SparkConf conf=new SparkConf().setAppName("twitter").setMaster("local[2]");
        	String[] filters={
        			"hQ7xOiVZGWnGKrcVgBU5tJEoN",
        			"Qy6aeHExuWGW2Bogyai2zlsYhE7SAoyfP9Lzg8XLgTOzNNgYd4",
        			"911026876440707077-9DiY0cCbv1I5Ge7n4cB41TCrjtjAfdZ",
        			"ywKNh9w1vpLRluZfAGmSGWn1Orecq8lsoJ2f1O6Rp01L3"
        	};
        	JavaStreamingContext jssc=
        			new JavaStreamingContext(conf,new Duration(10000));
        	System.setProperty("twitter4j.oauth.consumerKey", filters[0]);
        	System.setProperty("twitter4j.oauth.consumerSecret", filters[1]);
        	System.setProperty("twitter4j.oauth.accessToken", filters[2]);
        	System.setProperty("twitter4j.oauth.accessTokenSecret", filters[3]);
        	final String[] data={"문재인","홍준표","안철수",
        			"박지원","서청원","이명박","박근혜","전두환","트럼프","아베"};
        	// String s="문재인[가-힣]" 는 가 을 
        	final Pattern[] p=new Pattern[data.length];
        	final Matcher[] m=new Matcher[data.length];
        	JavaReceiverInputDStream<Status> twitterStream=
        			TwitterUtils.createStream(jssc, data);
        	
        	JavaDStream<String> status=twitterStream.map(new Function<Status, String>() {

				@Override
				public String call(Status s) throws Exception {
					// TODO Auto-generated method stub
					
					return s.getText();
				}
			});
        	JavaDStream<String> words=status.flatMap(new FlatMapFunction<String, String>() {
               
				@Override
				public Iterable<String> call(String s) throws Exception {
					// TODO Auto-generated method stub
					List<String> list=new ArrayList<String>();
					for(int i=0;i<p.length;i++)
					{
						p[i]=Pattern.compile(data[i]);
					}
					for(int i=0;i<m.length;i++)
					{
						m[i]=p[i].matcher(s);
						if(m[i].find())
						{
							list.add(m[i].group());
						}
					}
					return list;
				}
			});
        	JavaPairDStream<String, Integer> mapper=words.mapToPair(new PairFunction<String, String, Integer>() {

				@Override
				public Tuple2<String, Integer> call(String key) throws Exception {
					// TODO Auto-generated method stub
					return new Tuple2<String, Integer>(key, 1);
				}
			});
        	JavaPairDStream<String, Integer> reduce=mapper.reduceByKey(new Function2<Integer, Integer, Integer>() {
				
				@Override
				public Integer call(Integer sum, Integer i) throws Exception {
					// TODO Auto-generated method stub
					return sum+i;
				}
			});
        	reduce.print();
        	reduce.saveAsHadoopFiles("hdfs://Namenode:9000/user/spark/data/twitter", "", Text.class, IntWritable.class, TextOutputFormat.class,jc);
        	jssc.start();
        	jssc.awaitTermination();
       }catch(Exception ex)
        {
          System.out.println(ex.getMessage());	
        }
	}

}


