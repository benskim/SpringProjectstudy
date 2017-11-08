package com.sist.twitter;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/*
  아이유 (IU)
2 멜로망스 (MeloMance)
3 김나영
4 방탄소년단
5 박원
6 비투비 (BTOB)
7 폴킴
8 도끼 (Dok2)
9 EXO
10 볼빨간사춘기 
 */
public class TwitterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] data={"아이유|IU","멜로망스|MeloMance","김나영",
    		   "방탄소년단",
    		   "박원","비투비|BTOB","폴킴","도끼|Dok2","엑소|EXO",
    		   "볼빨간사춘기"};
    	//interface-하나로 계속 쓰기위해서 "스트림 인스턴스" 사용
        // (이벤트등록)가져오는 기능실현 : 리스너
        // 조건문: 필터쿼리
        //
        TwitterStream ts=new TwitterStreamFactory().getInstance();
        ts.addListener(new TwitterListener());//정상작동/비정상작동 처리방식 지정
        FilterQuery fq=new FilterQuery();
        fq.track(data);//pattern
        ts.filter(fq);//matcher
        
	}

}





