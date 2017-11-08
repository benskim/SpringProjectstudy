package com.sist.twitter;
import com.sist.mgr.RealFindData;

import twitter4j.FilterQuery;
//pom.xml
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import java.util.*;

public class TwitterMain {

	public static void main(String[] args) {
		TwitterStream ts=new TwitterStreamFactory().getInstance();
		//stream을 사용한 결과가 성공인지 실패인지 알고싶어서 리스너사용/등록
		TwitterListener listen = new TwitterListener();
		ts.addListener(listen);
		RealFindData rd = new RealFindData();
		List<String> list = rd.daumFinddata();
		String[] data = new String[list.size()];
		list.toArray(data); //list data copy and change the type to data
									//toArray(array),Arrays.asList(list)
		FilterQuery fq = new FilterQuery();
		fq.track(data);
		ts.filter(fq);
//		for(String s:data){
//			System.out.println(s);
//		}
	}

}
