package com.sist.spark2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;


import scala.Tuple2;
import scala.tools.nsc.util.ClassPath.JavaContext;

/*
 *    public interface I 
 *    {
 *        public final static int a=10;
 *          ======================
 *        public abstract void display();
 *         ===================
 *    }
 */
public class SparkMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] data={"아이유|IU","멜로망스|MeloMance","김나영",
	    		   "방탄소년단",
	    		   "박원","비투비|BTOB","폴킴","도끼|Dok2","엑소|EXO",
	    		   "볼빨간사춘기"};
		
		final Pattern[] p=new Pattern[data.length];
		final Matcher[] m=new Matcher[data.length];
		// Spark연결 
		SparkConf conf=new SparkConf().setAppName("music").setMaster("local");
		JavaSparkContext sc=new JavaSparkContext(conf);
		// 분석할 파일 읽기 
		JavaRDD<String> file=sc.textFile("./music");
		// 한줄씩 분석 => 필요한 데이터 추출 flatMap()
		JavaRDD<String> words=file.flatMap(new FlatMapFunction<String, String>() {
			List<String> list = new ArrayList<String>();
			@Override
			public Iterator<String> call(String line) throws Exception {
				for(int i=0;i<p.length;i++){
					p[i]=Pattern.compile(data[i]);
				}
				for(int i=0;i<m.length;i++){
					m[i]=p[i].matcher(line);
					if(m[i].find()){
						list.add(m[i].group());
					}
				}
				return list.iterator();
			}
		
		});
		// 각단어당 1씩 부여 => mapToPair
		JavaPairRDD<String, Integer> mapper=words.mapToPair(new PairFunction<String, String, Integer>() {

			//tuple method : String + integer '묶음'을 만들어주는 것의 이름
			@Override
			public Tuple2<String, Integer> call(String word) throws Exception {
				// TODO Auto-generated method stub
				return new Tuple2<String, Integer>(word,1);
			}
		});
		// 같은 단어를 찾아서 갯수를 누적 reduceByKey
		JavaPairRDD<String, Integer> counts=mapper.reduceByKey(new Function2<Integer, Integer, Integer>() {
			
			@Override
			public Integer call(Integer sum, Integer i) throws Exception {
				// TODO Auto-generated method stub
				// sum=sum+i
				return sum+i;
			}
		});
		// 저장한다 
		counts.saveAsTextFile("./output2");
		sc.close();
	}

}






