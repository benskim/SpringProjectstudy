package com.sist.news;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

/*
 하둡							몽고			R
 데이터 수집 -> 데이터 분석 -> 데이터 저장 -> 시각화
 
 하둡수집기: flume, sqoop, chukwa, storm
 하둡분석기: MapReduce, Spark, Pig
 하둡저장소:데이터 관리자: HBASE, HIVE, INPALA  -> 몽고
 하둡시각화: Zepplin								  ->  R
  
  text=pattern
  oracle = jdbc
  
  @XmlElement : tag 내 text  // <link>text</link>
  @XmlAttribute : attr("src")      // <link src="text"/>
 */
@XmlRootElement
public class Rss {
	private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}
	@XmlElement
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
