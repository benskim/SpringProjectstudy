package com.sist.spark;

import java.io.FileReader;
import java.io.StringReader;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;

import com.google.common.base.Optional;

import au.com.bytecode.opencsv.CSVReader;
import scala.Tuple2;

public class SparkJoinMain {

	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setAppName("music").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> genie = sc.textFile("/home/sist/music_data/genie.csv");
		JavaPairRDD<String, String> geniePair=genie.mapToPair(new PairFunction<String, String, String>() {
			
			@Override
			public Tuple2<String, String> call(String s) throws Exception {
				// TODO Auto-generated method stub
				CSVReader csv = new CSVReader(new StringReader(s));
				try {
					String[] d = csv.readNext(); // 1줄 읽기
					return new Tuple2<String, String>(d[1],d[0]);//0~2,rank/title/singer
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return new Tuple2<String, String>("-1","1");//데이터가 없다면, -1 : 문장끝
			}
		});

		//melon
		JavaRDD<String> melon = sc.textFile("/home/sist/music_data/melon.csv");
		JavaPairRDD<String, String> melonPair=melon.mapToPair(new PairFunction<String, String, String>() {
			
			@Override
			public Tuple2<String, String> call(String s) throws Exception {
				// TODO Auto-generated method stub
				CSVReader csv = new CSVReader(new StringReader(s));
				try {
					String[] d = csv.readNext(); // 1줄 읽기
					return new Tuple2<String, String>(d[1],d[0]);//0~2,rank/title/singer
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return new Tuple2<String, String>("-1","1");//데이터가 없다면, -1 : 문장끝
			}
		});
		
//		JavaPairRDD<String, Tuple2<String,String>> joinData=geniePair.join(melonPair);
//		joinData.saveAsTextFile("/home/sist/music_data/genie_melon");
		JavaPairRDD<String, Tuple2<Optional<String>,Optional<String>>> fulljoinData
		=geniePair.fullOuterJoin(melonPair);
		fulljoinData.saveAsTextFile("/home/sist/music_data/genie_melon_outer");
		
	}

}
