package com.sist.spark;

import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

import java.util.*;

public class SparkMain {

	public static void main(String[] args) {
		// 분산된 데이터 셋 : RDD (문장 데이터셋 -> 단어RDD)
       try
        {
           //configuration 새로 만들기
    	   SparkConf conf=new SparkConf().setAppName("wordcount").setMaster("local");
            //configuration 사용하기
           JavaSparkContext sc=new JavaSparkContext(conf);
             final String name="";
            
             //고정데이터 읽기클래스 : input file context(1 sentence) 가져오기
             //file을 한줄씩 잘라서 만들어진 결과가 RDD
           JavaRDD<String> input=sc.textFile("./input");
           	
           //input sentence - divided by "String"()
           //FlatMapFunction = interface/override
           JavaRDD<String> words=input.flatMap(new FlatMapFunction<String, String>() {
              List<String> list=new ArrayList<String>();
				
           // FlatMapFunction<String, String>의 두번째String == Iterator<String> 
            @Override
				public Iterator<String> call(String s) throws Exception {
			
					/*StringTokenizer st=new StringTokenizer(s);
					while(st.hasMoreTokens())
					{
						list.add(st.nextToken());
					}*/
					String name="";
					return Arrays.asList(s.split(" ")).iterator();
					//iterator : looping for splitting the list to make an Array.
				}
		    });
          JavaPairRDD<String, Integer> counts=words.mapToPair(new PairFunction<String, String, Integer>() {

			@Override
			public Tuple2<String, Integer> call(String s) throws Exception {
				// TODO Auto-generated method stub
				return new Tuple2<String, Integer>(s,1);
			}
		 });
          JavaPairRDD<String, Integer> reduce=counts.reduceByKey(new Function2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer sum, Integer x) throws Exception {
				// String -> key ; integer 산술연산
				// 마지막 integer가 call함수의 리턴값이다.(sume+x)
				return sum+x;
			}
		});
          
          reduce.saveAsTextFile("./output");
       }catch(Exception ex)
        {
    	   System.out.println(ex.getMessage());
        }
	}

}




