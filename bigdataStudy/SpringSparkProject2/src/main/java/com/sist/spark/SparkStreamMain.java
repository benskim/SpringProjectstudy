package com.sist.spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;
/*
 *   NameNode = local[0] = local
 *   S          local[1]
 *   =============================
 *   D          local[2],[3],[4]
 */
public class SparkStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
         {
        	SparkConf conf=new SparkConf().setAppName("netcat").setMaster("local[2]");
        	JavaStreamingContext jssc=
        			new JavaStreamingContext(conf,new Duration(2000));
        	// 데이터를 받기 시작 
        	JavaReceiverInputDStream<String> lines=
        			jssc.socketTextStream("localhost", 9999);
        	JavaDStream<String> words=lines.flatMap(new FlatMapFunction<String, String>() {

				@Override
				public Iterable<String> call(String s) throws Exception {
					// TODO Auto-generated method stub
					return Arrays.asList(s.split(" "));
				}
			});
        	JavaPairDStream<String, Integer> mapper=words.mapToPair(new PairFunction<String, String, Integer>() {

				@Override
				public Tuple2<String, Integer> call(String s) throws Exception {
					// TODO Auto-generated method stub
					return new Tuple2<String, Integer>(s, 1);
				}
			});
        	JavaPairDStream<String, Integer> reduce=mapper.reduceByKey(new Function2<Integer, Integer, Integer>() {
				
				@Override
				public Integer call(Integer sum, Integer i) throws Exception {
					// TODO Auto-generated method stub
					// sum=sum+i  sum+=i
					return sum+i;
				}
			});
        	reduce.print();
        	jssc.start();
        	jssc.awaitTermination();
        }catch(Exception ex)
         {
        	System.out.println(ex.getMessage());
         }
	}

}
